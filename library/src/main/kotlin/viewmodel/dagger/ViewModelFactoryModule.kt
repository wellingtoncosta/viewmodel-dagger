package viewmodel.dagger

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * @author WellingtonCosta on 19/07/18
 */
@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}