package com.example.lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class Converting extends Service {
    public class ServiceBinder extends Binder{
        public Converting getService(){
            return Converting.this;
        }
    }
    public Converting() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new ServiceBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service is started", Toast.LENGTH_SHORT).show();
        return  START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service is destroyed", Toast.LENGTH_SHORT).show();
    }

    public static String fromDecToBin(int number){
        return Integer.toBinaryString(number);
    }

    public static String fromDecToOct(int number){
        return Integer.toOctalString(number);
    }

    public static String fromDecToHex(int number){
        return Integer.toHexString(number);
    }
}
