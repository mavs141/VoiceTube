package chenyijie.voicetube.network

import chenyijie.voicetube.data.HW1DataList
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by chenyijie on 2018/8/1.
 */
interface VoiceTubeService {
    @POST("/thirdparty/test.php")
    fun getData(@Body body: RequestBody): Observable<HW1DataList>

}