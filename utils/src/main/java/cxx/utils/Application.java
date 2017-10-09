package cxx.utils;

/**
 * Created by LJN on 2017/10/9.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashUtil crashUtil = CrashUtil.getInstance();
        crashUtil.init(this);
    }
}
