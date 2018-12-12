package chenyijie.voicetube.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import chenyijie.voicetube.R
import chenyijie.voicetube.databinding.ActivityMainBinding
import chenyijie.voicetube.fragment.HW1Fragment
import chenyijie.voicetube.fragment.HW2Fragment
import chenyijie.voicetube.fragment.HW3Fragment
import chenyijie.voicetube.viewmodel.MainActivityViewModel
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun createViewModel(): ViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, getLayoutId())
        binding.vm = viewModel as MainActivityViewModel

        subscriptions.add(clickEvent())
    }

    private fun clickEvent(): Disposable {
        return (viewModel as MainActivityViewModel).clickSource
                .throttleFirst(150, TimeUnit.MILLISECONDS)
                .doOnNext {
                    when (it) {
                        R.id.button1 -> changeFragment(HW1Fragment(), false)
                        R.id.button2 -> changeFragment(HW2Fragment(), false)
                        R.id.button3 -> changeFragment(HW3Fragment(), false)
                    }
                }
                .subscribe()
    }
}
