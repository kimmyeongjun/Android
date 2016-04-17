package com.example.user.step07_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by lee on 2016-04-16.
 */
public class BootCompleteReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context, MyService.class);
        context.startService(i);
    }
}
