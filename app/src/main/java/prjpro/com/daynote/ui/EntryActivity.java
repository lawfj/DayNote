package prjpro.com.daynote.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import prjpro.com.daynote.R;
import prjpro.com.daynote.base.BaseActivity;
import prjpro.com.daynote.db.DB_User;


public class EntryActivity extends BaseActivity implements OnClickListener {
    EditText et_pass;
    ImageView iv_lock;
    ImageView iv_forget_pass;
    Animation shakeAnim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        initView();
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPass();
    }

    void initView() {
        et_pass = (EditText) findViewById(R.id.et_pass);
        iv_lock = (ImageView) findViewById(R.id.iv_lock);
        iv_forget_pass = (ImageView) findViewById(R.id.iv_forget_pass);

        iv_lock.setOnClickListener(this);
        iv_forget_pass.setOnClickListener(this);
    }

    void loadData() {
        shakeAnim = AnimationUtils.loadAnimation(mActivity, R.anim.shake);
    }

    void checkPass() {
        String pass = new DB_User(mActivity).getPassword();
        if (TextUtils.isEmpty(pass)) {
            new DB_User(mActivity).setPassword("123");
            startActivity();
            return;
        }
        String ed_pass = et_pass.getText().toString();
        if (pass.equals(ed_pass)) {
            startActivity();
        } else {
            et_pass.startAnimation(shakeAnim);
            et_pass.selectAll();
        }
    }

    void startActivity() {
        startActivity(new Intent(mActivity, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_lock:
                checkPass();
                break;
            case R.id.iv_forget_pass:
                break;
        }

    }
}
