package chenyijie.voicetube.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import chenyijie.voicetube.R
import chenyijie.voicetube.VoiceTubeApplication
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by chenyijie on 2018/7/30.
 */
abstract class BaseActivity: DaggerAppCompatActivity() {

    lateinit var subscriptions: CompositeDisposable
    lateinit var viewModel: ViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        subscriptions = CompositeDisposable()
        viewModel = createViewModel()

    }

    @NonNull
    @LayoutRes
    abstract fun getLayoutId(): Int

    @NonNull
    abstract fun createViewModel(): ViewModel

    override fun onDestroy() {
        super.onDestroy()
        unRegisterSubscription(subscriptions)
    }

    private fun unRegisterSubscription(subscription: CompositeDisposable) {
        if (subscriptions.isDisposed) {
            subscription.dispose()
        }
    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        val ft = supportFragmentManager.beginTransaction()
        if (cleanStack) {
            clearBackStack()
        }
//        ft.setCustomAnimations(
//                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.replace(R.id.content_fragment, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun clearBackStack() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            val first = supportFragmentManager.getBackStackEntryAt(0)
            supportFragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}