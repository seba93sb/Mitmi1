package com.uaistudents.top5.mitmil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_page extends AppCompatActivity {
Button Eventoss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Eventoss = (Button)findViewById(R.id.MyB);
        Eventoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Eventosi = new Intent(Main_page.this,com.uaistudents.top5.mitmil.My_events.class);

                startActivity(Eventosi);
                setContentView(R.layout.activity_my_events);

            }
        });

    }
}
