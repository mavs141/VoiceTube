package chenyijie.voicetube.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import chenyijie.voicetube.data.VideoData
import chenyijie.voicetube.manager.ApiManager
import chenyijie.voicetube.utils.RxUnit
import io.reactivex.Observable
import okhttp3.MultipartBody
import javax.inject.Inject

/**
 * Created by chenyijie on 2018/7/30.
 */
class HW1FragmentViewModel @Inject constructor(private val apiManager: ApiManager) : ViewModel() {
    val info: LiveData<List<VideoData>>
        get() = _info
    private val _info = MutableLiveData<List<VideoData>>()

    fun getInfo(key: String, value: String): Observable<RxUnit> {
        val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(key, value)
                .build()

        return RxUnit.just()
                .concatMap {
                    if (_info.value == null) {
                        getDataFromNetwork(requestBody).doOnNext { _info.postValue(it) }
                    } else {
                        getDataFromLocal()
                    }
                }
                .map { RxUnit.unit }
    }

    private fun getDataFromNetwork(requestBody: MultipartBody): Observable<List<VideoData>> {
        return apiManager.postApi(requestBody)
                .map { it.videos }
    }

    private fun getDataFromLocal(): Observable<List<VideoData>> {
        return Observable.just(_info.value)
    }
}