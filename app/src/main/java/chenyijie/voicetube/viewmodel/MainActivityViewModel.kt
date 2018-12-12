package chenyijie.voicetube.viewmodel

import android.arch.lifecycle.ViewModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by chenyijie on 2018/7/30.
 */
class MainActivityViewModel @Inject constructor() : ViewModel() {
    val clickSource = PublishSubject.create<Int>()
}