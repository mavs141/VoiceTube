package chenyijie.voicetube.di.module

import chenyijie.voicetube.activity.MainActivity
import chenyijie.voicetube.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (MainFragmentBuilderModule::class)])
    abstract fun mainActivity(): MainActivity
}