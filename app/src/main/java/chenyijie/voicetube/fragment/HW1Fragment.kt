package chenyijie.voicetube.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import chenyijie.voicetube.R
import chenyijie.voicetube.common.ConstValues
import chenyijie.voicetube.controller.InfoController
import chenyijie.voicetube.databinding.FragmentHw1Binding
import chenyijie.voicetube.viewmodel.HW1FragmentViewModel
import io.reactivex.disposables.Disposable

/**
 * Created by chenyijie on 2018/7/30.
 */
class HW1Fragment : BaseFragment<FragmentHw1Binding, HW1FragmentViewModel>() {
    private lateinit var controller: InfoController

    override val fragmentLayoutId: Int
        get() = R.layout.fragment_hw1

    override fun createViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HW1FragmentViewModel::class.java)
        binding.vm = viewModel

        subscriptions.add(subscribeNetworkRequest())

        viewModel.info.observe(this, Observer {
            if (it != null) {
                controller.setData(it)
            }
        })
    }

    override fun bindingRecyclerView(binding: FragmentHw1Binding) {
        super.bindingRecyclerView(binding)
        controller = InfoController()
        binding.recyclerView.setController(controller)
    }

    private fun subscribeNetworkRequest(): Disposable {
        return viewModel.getInfo(ConstValues.KEY, ConstValues.VALUE)
                .subscribe()
    }
}