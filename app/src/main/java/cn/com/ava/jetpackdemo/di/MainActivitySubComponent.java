package cn.com.ava.jetpackdemo.di;

import cn.com.ava.jetpackdemo.MainActivity;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {
        AndroidInjectionModule.class,
        MainActivitySubComponent.SubModule.class
})
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

    @Module
    class SubModule {

        @Provides
        String provideName() {
            return MainActivity.class.getName();
        }
    }
}
