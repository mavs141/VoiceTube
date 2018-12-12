package chenyijie.voicetube.di.module

import android.arch.lifecycle.ViewModelProvider
import chenyijie.voicetube.di.VoiceTubeViewModelProviderFactory
import chenyijie.voicetube.di.scope.PerActivity
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityViewModelBuilderModule {
    @Binds
    @PerActivity
    abstract fun bindViewModelFactory(factory: VoiceTubeViewModelProviderFactory): ViewModelProvider.Factory
}