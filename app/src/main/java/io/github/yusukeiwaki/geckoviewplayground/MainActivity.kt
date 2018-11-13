package io.github.yusukeiwaki.geckoviewplayground

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.yusukeiwaki.geckoviewplayground.databinding.ActivityMainBinding
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    private lateinit var geckoSession: GeckoSession

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        geckoSession = GeckoSession()
        geckoSession.open(GeckoRuntime.getDefault(this))
        binding.geckoview.session = geckoSession
        geckoSession.contentDelegate = MyContentDelegate(viewModel)
        geckoSession.navigationDelegate = MyNavigationDelegate(viewModel)
        geckoSession.progressDelegate = MyProgressDelegate(viewModel)
        geckoSession.loadUri("https://www.yahoo.co.jp/")
    }

    override fun onBackPressed() {
        if (viewModel.canGoBack.value == true) {
            geckoSession.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
