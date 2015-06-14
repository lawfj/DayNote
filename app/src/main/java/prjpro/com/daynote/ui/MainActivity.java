package prjpro.com.daynote.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import prjpro.com.daynote.DNApplication;
import prjpro.com.daynote.R;
import prjpro.com.daynote.adapter.RecyclerViewAdapter;
import prjpro.com.daynote.base.BaseActivity;
import prjpro.com.daynote.entity.NoteEty;
import prjpro.com.daynote.tools.DividerGridItemDecoration;
import prjpro.com.daynote.widget.CustomDialog;
import prjpro.com.daynote.widget.CustomDialog.CGravity;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    LinearLayout ll_new_layout;
    LinearLayout ll_set_layout;
    LinearLayout ll_exit_layout;

    RecyclerView recycler_view;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadData();
    }

    void initView() {
        ll_new_layout = (LinearLayout) findViewById(R.id.ll_new_layout);
        ll_new_layout.setOnClickListener(this);

        ll_set_layout = (LinearLayout) findViewById(R.id.ll_set_layout);
        ll_set_layout.setOnClickListener(this);

        ll_exit_layout = (LinearLayout) findViewById(R.id.ll_exit_layout);
        ll_exit_layout.setOnClickListener(this);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.addItemDecoration(new DividerGridItemDecoration(mActivity));
        recycler_view.setAdapter(adapter = new RecyclerViewAdapter());
    }

    void loadData(){
        List<NoteEty> list = new ArrayList<NoteEty>();
        list.add(new NoteEty("奇偶大家的理解就打飞机sodomy欧迪芬豆腐饿哦哦就个哦他较为呕吐 Joe而忘记哦人佛家饿哦"));
        list.add(new NoteEty("奇偶大家的理解就打飞机哦人佛家饿哦"));
        list.add(new NoteEty("奇偶大家的理解就打飞机sodomy欧迪芬豆吐 Joe而忘记哦人佛家饿哦"));
        list.add(new NoteEty("奇偶大家的打飞机sodomy欧迪芬豆腐饿哦哦就个哦他较为呕吐 Joe而忘记哦人佛家饿哦"));
        list.add(new NoteEty("奇偶大家的理解就打飞机sodomy欧迪芬豆oe而忘记哦人佛家饿哦"));
        list.add(new NoteEty("奇偶大呕吐 Joe而忘记哦人佛家饿哦"));
        list.add(new NoteEty("迪芬豆腐饿哦哦就个哦他家饿哦"));
        adapter.setData(list);
    }

    void exitDialog() {
        final View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_comm_dialog, null);
        final CustomDialog dialog = CustomDialog.create(MainActivity.this);
        dialog.setCanceledOnTouchOutside(true);

        view.findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                DNApplication.Instance().onTerminate();
            }
        });
        view.findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        dialog.setContentVw(view).setGravity(CGravity.CENTER).loadAnimation().show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_exit_layout:
                exitDialog();
                break;
            case R.id.ll_new_layout:
                break;
            case R.id.ll_set_layout:
                break;
        }
    }
}
