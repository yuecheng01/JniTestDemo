package com.yeucheng.customtitlebar;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private String TAG = "MyService";
    private DownLoadBinder mBinder= new DownLoadBinder();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return mBinder;
    }
    class DownLoadBinder extends Binder{
        public void startDownLoad(){
            Log.d(TAG,"startdownload executed");
        }

        public int getProgress() {
            Log.d(TAG, "getProgress");
            return 0;
        }
    }
}
