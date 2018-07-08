 package com.example.avi.crickplay3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

 public class ProfileActivity extends Activity {

    private TextView User_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        User_Name=findViewById(R.id.textView6);
    }

    @Override
    protected void onStart() {
        super.onStart();
        User_Name.setText("Hi");
    }
}
