package com.example.amgad.amgadcallsmessages;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void call (View v){
        EditText e1 = findViewById(R.id.editText_phoneNumber);
        String e2 = e1.getText().toString();
        Intent i = new Intent(Intent.ACTION_CALL);
        String phone = "tel:"+e2;
        i.setData(Uri.parse(phone));
        startActivity(i);
    }
    public void openPhoneToCall (View v){
        EditText e1 = findViewById(R.id.editText_phoneNumber);
        String e2 = e1.getText().toString();
        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        String phone = "tel:"+e2;
        i.setData(Uri.parse(phone));
        startActivity(i);
    }
    public void sendMessage (View v){
        EditText e1 = findViewById(R.id.editText_phoneNumber);
        String e2 = e1.getText().toString();
        Intent i = new Intent(this,Message.class);
        i.putExtra("phone",e2);
        startActivity(i);
    }
}
