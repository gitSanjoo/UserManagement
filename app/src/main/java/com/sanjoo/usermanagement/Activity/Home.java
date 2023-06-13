package com.sanjoo.usermanagement.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sanjoo.usermanagement.R;
import com.sanjoo.usermanagement.fragments.Dasboard;
import com.sanjoo.usermanagement.fragments.Profile;
import com.sanjoo.usermanagement.fragments.Users;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new Dasboard());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;
        switch (item.getItemId()){
            case R.id.dashboard:
                fragment=new Dasboard();
                break;
            case R.id.user:
                fragment=new Users();
                break;
            case R.id.profile:
                fragment=new Profile();
                break;
        }

        if(fragment!=null){
            loadFragment(fragment);
        }
        return true;
    }
    public void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.relative_layout,fragment).commit();
    }

}