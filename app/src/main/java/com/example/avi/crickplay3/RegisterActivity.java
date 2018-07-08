package com.example.avi.crickplay3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends Activity {

    private EditText register_email;
    private EditText register_password;
    private EditText register_password_confirm;
    private ProgressBar register_progressbar;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_email=findViewById(R.id.editText);
        register_password=findViewById(R.id.editText4);
        register_password_confirm=findViewById(R.id.editText6);
        register_progressbar=findViewById(R.id.progressBar3);

        mAuth=FirebaseAuth.getInstance();
    }

    public void OnLoginButtonClicked(View v){
        Toast.makeText(RegisterActivity.this,"Login Button Clicked",Toast.LENGTH_LONG).show();
        Intent signInIntent=new Intent(this,LoginActivity.class);
        startActivity(signInIntent);
        finish();
    }

    public void OnSignUpButtonClick(View v){
        Toast.makeText(RegisterActivity.this,"Sign up Button Clicked",Toast.LENGTH_LONG).show();
        register_progressbar.setVisibility(View.VISIBLE);

        String Email=register_email.getText().toString();
        String Password=register_password.getText().toString();
        String Confirm_Password=register_password_confirm.getText().toString();

        if(!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Password)) {
            if(Password.matches(Confirm_Password)) {
                mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"Sign up Successfull",Toast.LENGTH_LONG).show();
                            sendToMain();
                        }else{
                            Toast.makeText(RegisterActivity.this,task.getException().toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }else{
                Toast.makeText(RegisterActivity.this,"Password didn't match.",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(RegisterActivity.this,"Black Field",Toast.LENGTH_LONG).show();
        }
    }

    private void sendToMain() {
        Toast.makeText(this,"Loading main page",Toast.LENGTH_LONG).show();
        Intent signInIntent=new Intent(this,MainActivity.class);
        startActivity(signInIntent);
        finish();
    }
}
