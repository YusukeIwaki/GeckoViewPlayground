package io.github.yusukeiwaki.geckoviewplayground

import android.util.Log
import org.mozilla.geckoview.AllowOrDeny
import org.mozilla.geckoview.GeckoResult
import org.mozilla.geckoview.GeckoSession

class MyNavigationDelegate(private val viewModel: MainActivityViewModel) : GeckoSession.NavigationDelegate {
    override fun onLocationChange(session: GeckoSession, url: String) {
        Log.d("MyNavigationDelegate", "onLocationChange: url:${url}")
        viewModel.url.postValue(url)
    }

    override fun onCanGoBack(session: GeckoSession, canGoBack: Boolean) {
        Log.d("MyNavigationDelegate", "onCanGoForward: canGoBack:${canGoBack}")
        viewModel.canGoBack.postValue(canGoBack)
    }

    override fun onCanGoForward(session: GeckoSession, canGoForward: Boolean) {
        Log.d("MyNavigationDelegate", "onCanGoForward: canGoForward:${canGoForward}")
        viewModel.canGoForward.postValue(canGoForward)
    }

    override fun onLoadRequest(
        session: GeckoSession,
        request: GeckoSession.NavigationDelegate.LoadRequest
    ): GeckoResult<AllowOrDeny>? {
        Log.d("MyNavigationDelegate", "onLoadRequest: uri:${request.uri}")
        return GeckoResult.ALLOW
    }

    override fun onNewSession(session: GeckoSession, uri: String): GeckoResult<GeckoSession>? {
        Log.d("MyNavigationDelegate", "onNewSession: uri:${uri}")
        // 本来は  val newSession = GeckoSession(session.settings) したものを返す。
        session.loadUri(uri)
        return null
    }

    override fun onLoadError(session: GeckoSession, uri: String, category: Int, error: Int): GeckoResult<String>? {
        Log.d("MyNavigationDelegate", "onLoadError: uri:${uri} category=${category} error=${error}")
        return null
    }
}
