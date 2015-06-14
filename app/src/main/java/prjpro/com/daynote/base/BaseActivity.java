package prjpro.com.daynote.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import prjpro.com.daynote.ActivityManager;


public class BaseActivity extends FragmentActivity {
    public Activity mActivity;
    ActivityManager activityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;

        activityManager = ActivityManager.getScreenManager();
        activityManager.pushActivity(this);
    }

    @Override
    protected void onDestroy() {
        activityManager.popActivity(this);
        super.onDestroy();
    }
}
