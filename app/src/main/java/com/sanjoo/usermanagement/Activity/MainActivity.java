package com.sanjoo.usermanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sanjoo.usermanagement.Activity.Login;
import com.sanjoo.usermanagement.R;
import com.sanjoo.usermanagement.RetrofitClient;
import com.sanjoo.usermanagement.modelresponse.RegisterResponse;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView loginLink;
    EditText name, email, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide action bar
        getSupportActionBar().hide();

        //hide status bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

        loginLink = findViewById(R.id.login_link);
        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        register = findViewById(R.id.btn_register);

        loginLink.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                registerUser();
                break;
            case R.id.login_link:
                switchOnLogin();
                break;
        }
    }

    private void registerUser() {
        String username = name.getText().toString();
        String userPassword = password.getText().toString();
        String useremail = email.getText().toString();

        if (username.isEmpty()) {
            name.requestFocus();
            name.setError("please enter your name");
            return;
        }

        if (userPassword.isEmpty()) {
            password.requestFocus();
            password.setError("please enter your password");
            return;
        }
        if (userPassword.length() < 8) {
            password.requestFocus();
            password.setError("add more characters.");
            return;
        }

        if (useremail.isEmpty()) {
            email.requestFocus();
            email.setError("please enter your email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()) {
            email.requestFocus();
            email.setError("please enter correct email");
            return;
        }

        Call<RegisterResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .register(username,useremail,userPassword);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse=response.body();
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,registerResponse.getMessage(),Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,registerResponse.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
            }
        });
    }

        private void switchOnLogin () {
            Intent i = new Intent(this, Login.class);
            startActivity(i);

        }

}











