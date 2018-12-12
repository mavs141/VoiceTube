package chenyijie.voicetube.di.module

import android.content.Context
import android.content.SharedPreferences
import chenyijie.voicetube.common.ConstValues
import chenyijie.voicetube.manager.SharedPreferenceManager
import chenyijie.voicetube.network.VoiceTubeService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.ref.WeakReference
import javax.inject.Singleton

@Module
class DataAccessModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(context: WeakReference<Context>): SharedPreferences = context.get()!!.getSharedPreferences(ConstValues.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)

//    @Singleton
//    @Provides
//    fun provideSharedPreferenceManager(sharedPreferences: SharedPreferences): SharedPreferenceManager = SharedPreferenceManager(sharedPreferences)

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(ConstValues.BASE_URL)
            .build()

    @Singleton
    @Provides
    fun provideVoiceTubeService(retrofit: Retrofit): VoiceTubeService = retrofit.create(VoiceTubeService::class.java)
}