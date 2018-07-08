package com.example.avi.crickplay3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends Activity {

    private EditText login_Email;
    private EditText login_password;
    private ProgressBar login_progresssbar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_Email=findViewById(R.id.editText2);
        login_password=findViewById(R.id.editText3);
        login_progresssbar=findViewById(R.id.progressBar2);

        mAuth= FirebaseAuth.getInstance();
    }

    public void OnLoginButtonClicked(View v){
        Toast.makeText(LoginActivity.this,"Login Button Clicked",Toast.LENGTH_LONG).show();
        login_progresssbar.setVisibility(View.VISIBLE);

        String Email=login_Email.getText().toString();
        String Password=login_password.getText().toString();

        if(!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Password)){
            mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task!=null){
                        Toast.makeText(LoginActivity.this,"Sending to main",Toast.LENGTH_LONG).show();
                        sendToMain();
                    }else{
                        Toast.makeText(LoginActivity.this,task.getException().toString(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }else{
            Toast.makeText(LoginActivity.this,"Email or Password left blank",Toast.LENGTH_LONG).show();
        }
    }

    private void sendToMain() {
        Toast.makeText(LoginActivity.this,"Loading main page",Toast.LENGTH_LONG).show();
        Intent signInIntent=new Intent(this,MainActivity.class);
        startActivity(signInIntent);
        finish();
    }

    public void OnSignUpButtonClick(View v){
        Toast.makeText(LoginActivity.this,"Sign up Button Clicked",Toast.LENGTH_LONG).show();
        Intent signInIntent=new Intent(this,RegisterActivity.class);
        startActivity(signInIntent);
        finish();
    }
}
