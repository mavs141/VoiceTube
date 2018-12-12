package chenyijie.voicetube.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by chenyijie on 2018/8/2.
 */
data class HW1DataList(@SerializedName("status") @Expose val status: String,
                       @SerializedName("videos") @Expose val videos: List<VideoData>)