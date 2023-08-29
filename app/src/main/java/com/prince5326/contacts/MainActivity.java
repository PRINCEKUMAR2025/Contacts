package com.prince5326.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import com.prince5326.contacts.R;

public class MainActivity extends AppCompatActivity {

    Button btnList,btnCreate;
    TextView textView,textView3;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            btnList=findViewById(R.id.btnList);
            btnCreate=findViewById(R.id.btnCreate);
            textView=findViewById(R.id.textView);
            textView3=findViewById(R.id.textView3);

        AppCenter.start(getApplication(), "ae9da51b-476e-43da-bb0e-3fc750ec767b",
                Analytics.class, Crashes.class);

            btnList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(MainActivity.this,ContactList.class));
                }
            });

            btnCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    startActivity(new Intent(MainActivity.this,NewContact.class));
                }
            });
    }
}