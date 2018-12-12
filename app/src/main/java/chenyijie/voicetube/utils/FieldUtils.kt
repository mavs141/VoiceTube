package chenyijie.voicetube.utils

import android.databinding.ObservableField
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by chenyijie on 2018/8/1.
 */
object FieldUtils {
    fun <T> toObservable(field: ObservableField<T>): Observable<T> {

        val ob = BehaviorSubject.create<T>()
        field.addOnPropertyChangedCallback(object : android.databinding.Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: android.databinding.Observable, propertyId: Int) {
                if (null != field.get()) {
                    ob.onNext(field.get()!!)
                }
            }
        })

        if (null != field.get()) {
            ob.onNext(field.get()!!)
        }
        return ob
    }
}