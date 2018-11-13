package io.github.yusukeiwaki.geckoviewplayground

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val title = MutableLiveData<String>()
    val url = MutableLiveData<String>()
    val progress = MutableLiveData<Int>()
    val loading = MutableLiveData<Boolean>()
    val canGoBack = MutableLiveData<Boolean>()
    val canGoForward = MutableLiveData<Boolean>()
}
