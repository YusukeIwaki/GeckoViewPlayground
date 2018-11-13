package io.github.yusukeiwaki.geckoviewplayground

import android.util.Log
import org.mozilla.geckoview.GeckoSession

class MyProgressDelegate(private val viewModel: MainActivityViewModel) : GeckoSession.ProgressDelegate {
    override fun onPageStart(session: GeckoSession, url: String) {
        Log.d("MyProgressDelegate", "onPageStart: url:${url}")
        viewModel.loading.postValue(true)
    }

    override fun onPageStop(session: GeckoSession, success: Boolean) {
        Log.d("MyProgressDelegate", "onPageStop: success:${success}")
        viewModel.loading.postValue(false)
    }

    override fun onProgressChange(session: GeckoSession, progress: Int) {
        Log.d("MyProgressDelegate", "onProgressChange: progress:${progress}")
        viewModel.progress.postValue(progress)
    }

    override fun onSecurityChange(
        session: GeckoSession,
        securityInfo: GeckoSession.ProgressDelegate.SecurityInformation
    ) {

    }
}
