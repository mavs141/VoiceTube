package chenyijie.voicetube.di.component

import chenyijie.voicetube.VoiceTubeApplication
import chenyijie.voicetube.di.module.ActivityBuildersModule
import chenyijie.voicetube.di.module.AppModule
import chenyijie.voicetube.di.module.DataAccessModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AppModule::class), (AndroidSupportInjectionModule::class), (ActivityBuildersModule::class), (DataAccessModule::class)])
interface AppComponent : AndroidInjector<VoiceTubeApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<VoiceTubeApplication>()
}
