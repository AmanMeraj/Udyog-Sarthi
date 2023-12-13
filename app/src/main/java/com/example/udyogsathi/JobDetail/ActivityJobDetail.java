package com.example.udyogsathi.JobDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.udyogsathi.Adapter.AdapterStudyModule;
import com.example.udyogsathi.Model.Module;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityJobDetailBinding;

import java.util.ArrayList;

public class ActivityJobDetail extends AppCompatActivity {
ActivityJobDetailBinding binding;
AdapterStudyModule adapter;
ArrayList<Module> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityJobDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        data= new ArrayList<>();
        for(int i=0;i<4;i++){
            Module obj1= new Module("Module 1",R.drawable.rightarrow);
            data.add(obj1);
            Module obj2= new Module("Module 2",R.drawable.rightarrow);
            data.add(obj2);
        }
        adapter= new AdapterStudyModule(this,data);
        binding.recycler.setAdapter(adapter);
    }
}