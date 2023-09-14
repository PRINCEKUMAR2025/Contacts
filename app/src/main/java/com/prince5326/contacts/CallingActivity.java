package com.prince5326.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class CallingActivity extends AppCompatActivity {
    TextView txtUser,textViewtarget;

    ZegoSendCallInvitationButton btnVoiceCall,btnVideoCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        txtUser=findViewById(R.id.txtUser);
        textViewtarget=findViewById(R.id.textViewtarget);

        btnVoiceCall=findViewById(R.id.btnVoiceCall);
        btnVideoCall=findViewById(R.id.btnVideoCall);

        String target=getIntent().getStringExtra("target");
        String username=getIntent().getStringExtra("username");
        String targetname=getIntent().getStringExtra("targetname");
        txtUser.setText("Welcome! "+username);
        textViewtarget.setText("Calling -> "+targetname.toUpperCase());

        String callingUser=target;
        VoiceCall(callingUser);
        VideoCall(callingUser);

    }
    void VoiceCall(String callingUser){
        btnVoiceCall.setIsVideoCall(false);
        btnVoiceCall.setResourceID("zego_uikit_call");
        btnVoiceCall.setInvitees(Collections.singletonList(new ZegoUIKitUser(callingUser,callingUser)));
    }

    void VideoCall(String callingUser){
        btnVideoCall.setIsVideoCall(true);
        btnVideoCall.setResourceID("zego_uikit_call");
        btnVideoCall.setInvitees(Collections.singletonList(new ZegoUIKitUser(callingUser,callingUser)));
    }
}