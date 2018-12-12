package chenyijie.voicetube.fragment

import android.arch.lifecycle.ViewModelProviders
import chenyijie.voicetube.R
import chenyijie.voicetube.common.ConstValues
import chenyijie.voicetube.databinding.FragmentHw2Binding
import chenyijie.voicetube.manager.SharedPreferenceManager
import chenyijie.voicetube.utils.FieldUtils
import chenyijie.voicetube.viewmodel.HW2FragmentViewModel
import io.reactivex.disposables.Disposable
import javax.inject.Inject


/**
 * Created by chenyijie on 2018/7/30.
 */
class HW2Fragment : BaseFragment<FragmentHw2Binding, HW2FragmentViewModel>() {
    @Inject
    lateinit var sharedPreferenceManager: SharedPreferenceManager

    override val fragmentLayoutId: Int
        get() = R.layout.fragment_hw2

    override fun createViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HW2FragmentViewModel::class.java)
        binding.vm = viewModel

        getStoredStatus()

        subscriptions.addAll(
                subscribeAutoPlaySwitch(),
                subscribeSyncSubtitleSwitch(),
                subscribePauseSwitch(),
                subscribeRecommendVideoSwitch(),
                subscribeNotifySwitch())
    }

    private fun getStoredStatus() {
        viewModel.autoPlaySwitchOn.set(sharedPreferenceManager.getBoolean(ConstValues.SHARED_PREFERENCE_AUTO_PLAY))
        viewModel.syncSubtitleSwitchOn.set(sharedPreferenceManager.getBoolean(ConstValues.SHARED_PREFERENCE_SYNC_SUBTITLE))
        viewModel.pauseSwitchOn.set(sharedPreferenceManager.getBoolean(ConstValues.SHARED_PREFERENCE_PAUSE))
        viewModel.recommendVideoSwitchOn.set(sharedPreferenceManager.getBoolean(ConstValues.SHARED_PREFERENCE_RECOMMEND_VIDEO))
        viewModel.notifySwitchOn.set(sharedPreferenceManager.getBoolean(ConstValues.SHARED_PREFERENCE_NOTIFY))
    }

    private fun subscribeAutoPlaySwitch(): Disposable {
        return FieldUtils.toObservable(viewModel.autoPlaySwitchOn)
                .doOnNext { sharedPreferenceManager.putBoolean(ConstValues.SHARED_PREFERENCE_AUTO_PLAY, it) }
                .subscribe()
    }

    private fun subscribeSyncSubtitleSwitch(): Disposable {
        return FieldUtils.toObservable(viewModel.syncSubtitleSwitchOn)
                .doOnNext { sharedPreferenceManager.putBoolean(ConstValues.SHARED_PREFERENCE_SYNC_SUBTITLE, it) }
                .subscribe()
    }

    private fun subscribePauseSwitch(): Disposable {
        return FieldUtils.toObservable(viewModel.pauseSwitchOn)
                .doOnNext { sharedPreferenceManager.putBoolean(ConstValues.SHARED_PREFERENCE_PAUSE, it) }
                .subscribe()
    }

    private fun subscribeRecommendVideoSwitch(): Disposable {
        return FieldUtils.toObservable(viewModel.recommendVideoSwitchOn)
                .doOnNext { sharedPreferenceManager.putBoolean(ConstValues.SHARED_PREFERENCE_RECOMMEND_VIDEO, it) }
                .subscribe()
    }

    private fun subscribeNotifySwitch(): Disposable {
        return FieldUtils.toObservable(viewModel.notifySwitchOn)
                .doOnNext { sharedPreferenceManager.putBoolean(ConstValues.SHARED_PREFERENCE_NOTIFY, it) }
                .subscribe()
    }
}