package com.example.udyogsathi.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityProfileBinding;

import utils.Utility;

public class ActivityProfile extends Utility {
ActivityProfileBinding binding;
ProfileViewModel viewModel;
ProfileResponse responsee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel= new ViewModelProvider(this).get(ProfileViewModel.class);
        if(isInternetConnected(this)){
            gteProfile();
        }
    }

    private void gteProfile() {
        binding.loader.rlLoader.setVisibility(View.VISIBLE);
        String auth=pref.getPrefString(this,pref.user_token);
        String userId=pref.getPrefString(this,pref.user_id);
        User user = new User();
        user.setUserId(userId);
        Log.d("TAG", "getLoggedIn: "+auth);
        viewModel.getProfile(auth,user).observe(this, response -> {
            Log.d("TAG", "get_status: "+response);
            if (response != null) {
                Log.d("TAG", "res "+response.getStatus());
                binding.loader.rlLoader.setVisibility(View.GONE);
                if(response.getStatus()==200){
                    responsee = response;
                    binding.loader.rlLoader.setVisibility(View.GONE);
                    binding.userName.setText(responsee.data.getName());
                    binding.userAdress.setText(responsee.data.getAdress());
                    binding.userEmail.setText(responsee.data.getEmail());
                    binding.userGender.setText(responsee.data.getGender());
                    binding.userDob.setText(responsee.data.getDob());
                    binding.userQualification.setText(responsee.data.getHighQualificaton());
                }
                else {
                    // Log.e("TAG", "res "+response.getStatus());
                    Toast.makeText(this, ""+response.getMessage(), Toast.LENGTH_SHORT).show();
                    binding.loader.rlLoader.setVisibility(View.GONE);
                }
            }
        });
    }
}