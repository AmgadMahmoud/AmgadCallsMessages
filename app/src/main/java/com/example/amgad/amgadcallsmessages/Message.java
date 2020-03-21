package com.example.amgad.amgadcallsmessages;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

/**
 * Created by amgad on 1/23/18.
 */

public class Message extends AppCompatActivity {

    String phone = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        EditText e1 = findViewById(R.id.editText_phoneNumber);
        String e2 = e1.getText().toString();
        phone = getIntent().getStringExtra("phone");
        if (phone.equals("")){
            e1.setText(e2);
        }
        else {
            e1.setText(phone);
        }
    }
    public void send (View v){
        EditText e1 = findViewById(R.id.editText_phoneNumber);
        String e2 = e1.getText().toString();
        EditText m1 = findViewById(R.id.editText_message);
        String m2 = m1.getText().toString();
        SmsManager.getDefault().sendTextMessage(e2,null,m2,null,null);

    }
    public void openMessagesToSend (View v){
        EditText e1 = findViewById(R.id.editText_phoneNumber);
        String e2 = e1.getText().toString();
        EditText m1 = findViewById(R.id.editText_message);
        String m2 = m1.getText().toString();
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        String number = "sms:"+e2;
        i.setData(Uri.parse(number));
        i.putExtra("sms_body",m2);
        startActivity(i);
    }
}
