package com.example.udyogsathi.NewsDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityNewsDetailsBinding;

public class ActivityNewsDetails extends AppCompatActivity {
ActivityNewsDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNewsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}