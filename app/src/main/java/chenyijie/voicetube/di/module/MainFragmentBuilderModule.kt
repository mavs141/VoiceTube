package chenyijie.voicetube.di.module

import android.arch.lifecycle.ViewModel
import chenyijie.voicetube.di.scope.PerFragment
import chenyijie.voicetube.di.scope.ViewModelKey
import chenyijie.voicetube.fragment.HW1Fragment
import chenyijie.voicetube.fragment.HW2Fragment
import chenyijie.voicetube.fragment.HW3Fragment
import chenyijie.voicetube.viewmodel.HW1FragmentViewModel
import chenyijie.voicetube.viewmodel.HW2FragmentViewModel
import chenyijie.voicetube.viewmodel.HW3FragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainFragmentBuilderModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun hw1Fragment(): HW1Fragment

    @Binds
    @IntoMap
    @ViewModelKey(HW1FragmentViewModel::class)
    abstract fun hw1ViewModel(viewModel: HW1FragmentViewModel): ViewModel

    @PerFragment
    @ContributesAndroidInjector
    abstract fun hw2Fragment(): HW2Fragment

    @Binds
    @IntoMap
    @ViewModelKey(HW2FragmentViewModel::class)
    abstract fun hw2ViewModel(viewModel: HW2FragmentViewModel): ViewModel

    @PerFragment
    @ContributesAndroidInjector
    abstract fun hw3Fragment(): HW3Fragment

    @Binds
    @IntoMap
    @ViewModelKey(HW3FragmentViewModel::class)
    abstract fun hw3ViewModel(viewModel: HW3FragmentViewModel): ViewModel
}
