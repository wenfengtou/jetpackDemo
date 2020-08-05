package cn.com.ava.jetpackdemo.di;

import cn.com.ava.jetpackdemo.JetPackApplication;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        JetPackAppModule.class,
        AllActivityModule.class,
})
public interface JetPackAppComponent {
    void inject(JetPackApplication application);
}