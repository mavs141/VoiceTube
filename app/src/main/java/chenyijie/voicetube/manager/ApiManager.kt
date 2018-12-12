package chenyijie.voicetube.manager

import chenyijie.voicetube.data.HW1DataList
import chenyijie.voicetube.network.VoiceTubeService
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiManager @Inject constructor(private val voiceTubeService: VoiceTubeService) {

    fun postApi(requestBody: RequestBody): Observable<HW1DataList> {
        return voiceTubeService
                .getData(requestBody)
                .subscribeOn(Schedulers.io())
    }

}