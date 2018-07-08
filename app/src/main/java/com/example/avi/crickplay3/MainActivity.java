package com.example.avi.crickplay3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Currency;

public class MainActivity extends Activity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser=mAuth.getCurrentUser();

        if(currentUser == null){
            Intent signInIntent=new Intent(this,LoginActivity.class);
            startActivity(signInIntent);
            finish();
        }
    }

    public void OnSettingButtonClicked(View v){
        Intent signInIntent=new Intent(this,ProfileActivity.class);
        startActivity(signInIntent);
    }
}
