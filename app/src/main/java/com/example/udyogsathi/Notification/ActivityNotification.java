package com.example.udyogsathi.Notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.udyogsathi.Adapter.AdapterNotification;
import com.example.udyogsathi.Model.Notification;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityNotificationBinding;

import java.util.ArrayList;

public class ActivityNotification extends AppCompatActivity {
ActivityNotificationBinding binding;
ArrayList<Notification> notifications;
AdapterNotification adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        notifications= new ArrayList<>();
        for (int i=0;i<5;i++){
            Notification obj1= new Notification("Job Offer","hey there! looks like someone is getting placed!","15/06 4:40pm");
            notifications.add(obj1);
        }
        adapter=new AdapterNotification(this,notifications);
        binding.rcNotification.setAdapter(adapter);


    }
}