package com.yeucheng.customtitlebar;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/3/23.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private MyBroadCast mMyBroadCast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(loadLayout());
        ActivitysCollector.addActivity(this);
        init();

    }

    protected abstract void init();

    protected abstract int loadLayout();

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.yeucheng.customtitlebar.FORCE_OFFLINE");
        mMyBroadCast = new MyBroadCast();
        registerReceiver(mMyBroadCast, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMyBroadCast != null) {

            unregisterReceiver(mMyBroadCast);
            mMyBroadCast = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivitysCollector.removeActivity(this);
    }
}
