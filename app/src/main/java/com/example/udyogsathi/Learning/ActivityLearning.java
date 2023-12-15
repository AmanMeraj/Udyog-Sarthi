package com.example.udyogsathi.Learning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.udyogsathi.Model.Jobs;
import com.example.udyogsathi.Model.Module;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityLearningBinding;

import java.util.ArrayList;

public class ActivityLearning extends AppCompatActivity {
ActivityLearningBinding binding;
ArrayList<Module> data;
int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLearningBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle b= new Bundle();
        b=getIntent().getExtras();
        if(b!=null) {
            position = b.getInt("pos");

            data = (ArrayList<Module>) getIntent().getSerializableExtra("KEY");
           binding.title.setText(data.get(position).getTitle());
           binding.desc.setText(data.get(position).getDesc());
        }

    }
}