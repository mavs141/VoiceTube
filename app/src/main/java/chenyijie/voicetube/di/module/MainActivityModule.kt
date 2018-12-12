package chenyijie.voicetube.di.module

import android.arch.lifecycle.ViewModel
import android.support.v7.app.AppCompatActivity
import chenyijie.voicetube.activity.MainActivity
import chenyijie.voicetube.di.scope.PerActivity
import chenyijie.voicetube.di.scope.ViewModelKey
import chenyijie.voicetube.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [(ActivityViewModelBuilderModule::class)])
abstract class MainActivityModule {
    @Binds
    @PerActivity
    abstract fun activity(activity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindActivityViewModel(viewModel: MainActivityViewModel): ViewModel

}