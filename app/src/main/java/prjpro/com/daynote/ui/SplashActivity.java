package prjpro.com.daynote.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import prjpro.com.daynote.R;
import prjpro.com.daynote.base.BaseActivity;


public class SplashActivity extends BaseActivity {
    ImageView iv_ad;
    TextView tv_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iv_ad = (ImageView) findViewById(R.id.iv_ad);
        tv_version = (TextView) findViewById(R.id.tv_version);

        loadView();
    }

    void loadView() {
        iv_ad.setImageResource(R.drawable.ic_splash_ad);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mActivity, EntryActivity.class));
                finish();
            }
        }, 2000);
    }

}
