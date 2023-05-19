package com.prince811201.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.prince811201.contacts.R;

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
            imageView3=findViewById(R.id.imageView3);

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