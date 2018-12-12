package chenyijie.voicetube.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import chenyijie.voicetube.utils.RxUnit
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by chenyijie on 2018/7/30.
 */
class HW3FragmentViewModel @Inject constructor() : ViewModel() {
    val inputField = ObservableField<String>()
    val clickSource = PublishSubject.create<Boolean>()
    val keepCountingDown = ObservableBoolean(false)

    fun countDownObservable(): Observable<RxUnit> {
        return Observable.interval(1, TimeUnit.SECONDS)
                .filter { !inputField.get().isNullOrEmpty() }
                .map { inputField.get()!!.toInt() }
                .takeWhile { keepCountingDown.get() && it > 0 }
                .map { it - 1 }
                .doOnNext {
                    inputField.set(it.toString())
                    keepCountingDown.set(it > 0)
                }
                .map { RxUnit.unit() }

    }
}