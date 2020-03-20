package com.example.phones;

import android.app.Service;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ScreenService extends Service {

private  LockScR mReceiver = null;

@Override
public IBinder onBind(Intent intent){
        return  null;
        }

@Override
public  void onCreate(){
        super.onCreate();

        mReceiver = new LockScR();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mReceiver, filter);
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            super.onStartCommand(intent, flags, startId);

            if (intent != null) {
                if (intent.getAction() == null) {
                    if (mReceiver == null) {
                        mReceiver = new LockScR();
                        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
                        registerReceiver(mReceiver, filter);
                    }
                }
            }
            return  START_REDELIVER_INTENT;
        }


        @Override
        public  void onDestroy(){
            super.onDestroy();
            if(mReceiver != null){
                unregisterComponentCallbacks((ComponentCallbacks) mReceiver);
            }

        }

}
