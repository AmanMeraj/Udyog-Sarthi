package com.example.udyogsathi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.udyogsathi.Container.ContainerActivity;
import com.example.udyogsathi.Login.ActivityLogin;
import com.example.udyogsathi.Register.ActivityRegister;
import com.example.udyogsathi.databinding.ActivityMainBinding;

import utils.Utility;

public class MainActivity extends Utility {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    protected void onResume() {
        super.onResume();
        Handler handler = new Handler();
        handler.postDelayed(() -> {

            if(pref.getPrefBoolean(MainActivity.this , pref.login_status)){
                Intent i = new Intent(MainActivity.this, ContainerActivity.class);
                startActivity(i);
                finish();
            }else{
                Intent i = new Intent(MainActivity.this, ActivityLogin.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}