package chenyijie.voicetube.controller

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import chenyijie.voicetube.data.VideoData
import chenyijie.voicetube.userInfo
import com.airbnb.epoxy.TypedEpoxyController

class InfoController : TypedEpoxyController<List<VideoData>>() {
    val onClick: LiveData<Int>
        get() = _onClick
    val _onClick = MutableLiveData<Int>()

    override fun buildModels(data: List<VideoData>?) {
        data?.forEachIndexed { index, videoData ->
            userInfo {
                id("userInfo$index")
                data(videoData)
                clickEvent { _ -> _onClick.postValue(index) }
            }

        }
    }

}