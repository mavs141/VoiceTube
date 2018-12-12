package chenyijie.voicetube.utils

import io.reactivex.Observable

/**
 * Created by chenyijie on 2018/8/1.
 */

class RxUnit {

    companion object {

        val unit = RxUnit()

        fun unit(): RxUnit {
            return unit
        }

        fun just(): Observable<RxUnit> {
            return Observable.create { e ->
                e.onNext(unit)
                e.onComplete()
            }
        }
    }
}