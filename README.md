# viewmodel-dagger [![](https://jitpack.io/v/WellingtonCosta/viewmodel-dagger.svg)](https://jitpack.io/#WellingtonCosta/viewmodel-dagger)

A set of classes that helps to use Android ViewModel with Dagger 2.

```@ViewModelKey``` to sinalize Dagger 2 which type of ViewModel is returned by provider method in order to compose a map.

Example:

```kotlin
  @Module
  interface ViewModelModule {
    
    @Binds
    @IntoMap
    @ViewModelKey(FooViewModel::class)
    fun bindFooViewModel(viewModel: FooViewModel): ViewModel
    
  }
```

```ViewModelFactoryModule``` represents a Dagger 2's module that provides an instance of ```ViewModelProvider.Factory```. Just include it in some module:

```kotlin
  @Module(includes = [ViewModelFactoryModule::class])
  interface ViewModelModule {
    
    // ...
    
  }
```

```ViewModelFactory``` is the implementation of ```ViewModelProvider.Factory```, which is used to create instances of ```ViewModel```. Just inject it in your ```Activity```, ```Fragment``` or in any place that you can inject Dagger 2 dependencies.

Example:

```kotlin
  class FooActivity : DaggerAppCompatActivity() {
  
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    
    private lateinit var viewModel: FooViewModel
  
    override fun onCreate(savedInstanceState: Bundle?) {
      // ...
      viewModel = ViewModelProviders.of(this, factory).get(FooViewModel::class.java)
    }
  
  }
```
