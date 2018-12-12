package chenyijie.voicetube.di.module

import android.content.Context
import chenyijie.voicetube.VoiceTubeApplication
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(app: VoiceTubeApplication): WeakReference<Context> = WeakReference(app)

//    @Singleton
//    @Provides
//    fun provideBaseApplication(): VoiceTubeApplication = VoiceTubeApplication()


}