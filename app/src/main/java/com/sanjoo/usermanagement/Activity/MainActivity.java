package com.sanjoo.usermanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sanjoo.usermanagement.Activity.Login;
import com.sanjoo.usermanagement.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView loginLink;
    EditText name,email,password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide action bar
        getSupportActionBar().hide();

        //hide status bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

        loginLink=findViewById(R.id.login_link);
        name=findViewById(R.id.et_name);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        register=findViewById(R.id.btn_register);

        loginLink.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                Toast.makeText(this,"register",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_link:
                switchOnLogin();
                break;
        }
    }

    private void switchOnLogin() {
        Intent i=new Intent(this, Login.class);
        startActivity(i);

    }
}











