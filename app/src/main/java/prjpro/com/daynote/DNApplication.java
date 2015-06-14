package prjpro.com.daynote;

import android.app.Application;

/**
 * Created by lsd on 15/6/14.
 */
public class DNApplication extends Application {
    static Application app;

    public static Application Instance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
