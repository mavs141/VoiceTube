package chenyijie.voicetube.fragment

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by chenyijie on 2018/7/30.
 */
abstract class BaseFragment<T : ViewDataBinding, U : ViewModel> : DaggerFragment() {
    lateinit var subscriptions: CompositeDisposable
    protected lateinit var viewModel: U
    protected lateinit var binding: T
    protected abstract val fragmentLayoutId: Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @NonNull
    protected abstract fun createViewModel()

    protected open fun bindingRecyclerView(binding: T) {}

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        subscriptions = CompositeDisposable()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, fragmentLayoutId, container, false)
        bindingRecyclerView(binding)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        createViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        unRegisterSubscription(subscriptions)
    }

    private fun unRegisterSubscription(subscription: CompositeDisposable) {
        if (subscription.isDisposed) {
            subscription.dispose()
            subscription.clear()
        }
    }
}