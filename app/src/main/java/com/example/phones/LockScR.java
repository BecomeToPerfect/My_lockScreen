package com.example.phones;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LockScR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) { // 밥
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) { // 연애
            Intent a = new Intent(context, love_SC.class);
            a.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(a);
        }
    }
}
