package chenyijie.voicetube.fragment

import android.arch.lifecycle.ViewModelProviders
import chenyijie.voicetube.R
import chenyijie.voicetube.databinding.FragmentHw3Binding
import chenyijie.voicetube.viewmodel.HW3FragmentViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by chenyijie on 2018/7/30.
 */
class HW3Fragment : BaseFragment<FragmentHw3Binding, HW3FragmentViewModel>() {
    override val fragmentLayoutId: Int
        get() = R.layout.fragment_hw3

    override fun createViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HW3FragmentViewModel::class.java)
        binding.vm = viewModel

        subscriptions.add(subscribeStartClick())
    }

    private fun subscribeStartClick(): Disposable {
        return viewModel.clickSource
                .doOnNext { viewModel.keepCountingDown.set(it) }
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .concatMap { viewModel.countDownObservable() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }
}