package io.github.yusukeiwaki.geckoviewplayground

import org.mozilla.geckoview.GeckoSession

class MyContentDelegate(private val viewModel: MainActivityViewModel) : GeckoSession.ContentDelegate {
    override fun onTitleChange(session: GeckoSession, title: String) {
        viewModel.title.postValue(title)
    }

    override fun onFocusRequest(session: GeckoSession) {

    }

    override fun onCloseRequest(session: GeckoSession) {

    }

    override fun onFullScreen(session: GeckoSession, fullScreen: Boolean) {

    }

    override fun onContextMenu(session: GeckoSession, screenX: Int, screenY: Int, uri: String, elementType: Int, elementSrc: String) {

    }

    override fun onExternalResponse(session: GeckoSession, response: GeckoSession.WebResponseInfo) {

    }

    override fun onCrash(session: GeckoSession) {

    }
}
