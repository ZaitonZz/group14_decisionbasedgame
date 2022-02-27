package com.example.group14_decisionbasedgame.view;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.group14_decisionbasedgame.R;



//TODO: fix restart game and music



public class settings_screen extends Activity {

    private Button btnBack, btnUpdate, btnRestart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.4),(int)(height*.7));


        btnBack = (Button) findViewById(R.id.btn_Pause);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); }});
        btnRestart = (Button) findViewById(R.id.btn_Restart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                PendingIntent pendingIntent = PendingIntent.getActivity(settings_screen.this, 1000,
                        getIntent(),PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, pendingIntent);
            }
        });
        btnUpdate = (Button) findViewById(R.id.btn_Update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(settings_screen.this, R.string.update,Toast.LENGTH_LONG).show();
          }
        });
    }
}