package com.example.android.mediaserviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Android on 6/2/2017.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    MediaPlayer mediaPlayer;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.madukghostassassinvipftveela);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
        Toast.makeText(this, "service started!!", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
        Toast.makeText(this, "service done for", Toast.LENGTH_SHORT).show();
    }
}
