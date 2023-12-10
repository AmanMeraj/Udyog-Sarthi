package com.example.udyogsathi.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityLoginBinding;

import utils.Utility;

public class ActivityLogin extends Utility {
ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}