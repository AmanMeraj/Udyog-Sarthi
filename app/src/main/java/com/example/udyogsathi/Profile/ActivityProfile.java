package com.example.udyogsathi.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityProfileBinding;

public class ActivityProfile extends AppCompatActivity {
ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}