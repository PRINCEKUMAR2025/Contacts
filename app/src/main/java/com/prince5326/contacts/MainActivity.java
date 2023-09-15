package com.prince5326.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import com.prince5326.contacts.R;
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnList,btnCreate;
    TextView textView,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            btnList=findViewById(R.id.btnList);
            btnCreate=findViewById(R.id.btnCreate);
            textView=findViewById(R.id.textView);
            textView3=findViewById(R.id.textView3);

        ImageSlider imageSlider=findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.dog1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bear, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cat, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.duck, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.horse, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.tiger, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        AppCenter.start(getApplication(), "ae9da51b-476e-43da-bb0e-3fc750ec767b",
                Analytics.class, Crashes.class);
        String email=ApplicationClass.user.getEmail();
        String username=email;
        proceedService(username);

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
        void proceedService(String userID){
        Application application = getApplication(); // Android's application context
        long appID = 1446913728;   // yourAppID
        String appSign ="d7e45593a18e7f6c7e1177c7efdd24c3ba6a1abada665756aa3e58813092a54e";  // yourAppSign
        String userName = userID;   // yourUserName

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        callInvitationConfig.notifyWhenAppRunningInBackgroundOrQuit = true;
        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound = "zego_uikit_sound_call";
        notificationConfig.channelID = "CallInvitation";
        notificationConfig.channelName = "CallInvitation";
        ZegoUIKitPrebuiltCallInvitationService.init(getApplication(), appID, appSign, userID, userName,callInvitationConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ZegoUIKitPrebuiltCallInvitationService.unInit();
    }
}