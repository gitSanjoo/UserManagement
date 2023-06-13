package com.sanjoo.usermanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sanjoo.usermanagement.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText email,password;
    Button login_btn;
    TextView register_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //hide action bar
        getSupportActionBar().hide();


        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        login_btn=findViewById(R.id.btn_login);
        register_link=findViewById(R.id.register_link);

        register_link.setOnClickListener(this);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_login:
                Intent i=new Intent(this, Home.class);
                startActivity(i);
                break;

            case R.id.register_link:
                switchOnRegister();
                break;
        }
    }

    private void switchOnRegister() {
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);

    }
}