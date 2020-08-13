package cn.com.ava.jetpackdemo.di;

import cn.com.ava.jetpackdemo.JetPackApplication;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        JetPackAppModule.class,
        AllActivityModule.class,
})
public interface JetPackAppComponent {
    void inject(JetPackApplication application);
}