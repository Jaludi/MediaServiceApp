package com.example.android.mediaserviceapp;


import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startBT;
    Button stopBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBT = (Button)findViewById(R.id.startBT);
        startBT.setOnClickListener(this);
        stopBT = (Button)findViewById(R.id.stopBT);
        stopBT.setOnClickListener(this);
    }
    private Intent getServiceIntent(){
        return new Intent(getBaseContext(), MyService.class);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.startBT:
                startService(getServiceIntent());
                Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stopBT:
                stopService(getServiceIntent());
        }
    }
}
