package chenyijie.voicetube.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by chenyijie on 2018/8/2.
 */
data class VideoData(@SerializedName("title")
                     @Expose
                     val title: String,
                     @SerializedName("img")
                     @Expose
                     val img: String)