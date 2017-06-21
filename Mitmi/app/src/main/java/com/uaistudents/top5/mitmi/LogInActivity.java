package com.uaistudents.top5.mitmi;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uaistudents.top5.mitmil.Main_page;

public class LogInActivity extends Activity {
    Button Log_In;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Log_In = (Button)findViewById(R.id.LogIn_button);
        Log_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Log_Ini = new Intent(LogInActivity.this,com.uaistudents.top5.mitmil.Main_page.class);

                startActivity(Log_Ini);



            }
        });


    }
}
