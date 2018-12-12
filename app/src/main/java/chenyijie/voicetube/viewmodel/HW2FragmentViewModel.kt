package chenyijie.voicetube.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import javax.inject.Inject

/**
 * Created by chenyijie on 2018/7/30.
 */
class HW2FragmentViewModel @Inject constructor() : ViewModel() {
    val autoPlaySwitchOn = ObservableField(false)
    val syncSubtitleSwitchOn = ObservableField(false)
    val pauseSwitchOn = ObservableField(false)
    val recommendVideoSwitchOn = ObservableField(false)
    val notifySwitchOn = ObservableField(false)

    fun onAutoPlayCheckedChanged(isChecked: Boolean) {
        autoPlaySwitchOn.set(isChecked)
    }

    fun onSyncSubtitleCheckedChanged(isChecked: Boolean) {
        syncSubtitleSwitchOn.set(isChecked)
    }

    fun onPauseCheckedChanged(isChecked: Boolean) {
        pauseSwitchOn.set(isChecked)
    }

    fun onRecommendVideoCheckedChanged(isChecked: Boolean) {
        recommendVideoSwitchOn.set(isChecked)
    }

    fun onNotifyCheckedChanged(isChecked: Boolean) {
        notifySwitchOn.set(isChecked)
    }
}