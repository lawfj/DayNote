package prjpro.com.daynote.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import prjpro.com.daynote.R;


public class BaseActivity extends FragmentActivity {
    public BaseActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
