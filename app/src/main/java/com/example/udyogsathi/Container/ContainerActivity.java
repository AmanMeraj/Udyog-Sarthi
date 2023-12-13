package com.example.udyogsathi.Container;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.udyogsathi.Notification.ActivityNotification;
import com.example.udyogsathi.Profile.ActivityProfile;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityContainerBinding;

public class ContainerActivity extends AppCompatActivity {
    ActivityContainerBinding binding;



    public NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.frag_home,R.id.frag_job,R.id.frag_support,R.id.frag_community)
                .build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navViewBottom, navController);

        bottomMenuClick();

        binding.notificationBell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContainerActivity.this, ActivityNotification.class));

            }
        });

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContainerActivity.this, ActivityProfile.class));

            }
        });



    }

    private void bottomMenuClick() {

        binding.navViewBottom.setOnItemSelectedListener(i -> {
            if (R.id.home == i.getItemId()) {
                navController.navigate(R.id.frag_home);
            } else if (R.id.jobs == i.getItemId()) {
                navController.navigate(R.id.frag_jobs);
            }
            else if (R.id.support== i.getItemId()) {
                navController.navigate(R.id.frag_support);
            }
            else if (R.id.community == i.getItemId()) {
                navController.navigate(R.id.frag_community);
            }

            return true;
        });

    }
}