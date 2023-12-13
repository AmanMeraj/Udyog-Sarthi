package com.example.udyogsathi.OTP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.udyogsathi.Container.ContainerActivity;
import com.example.udyogsathi.DisabilityType.ActivityDisabilityType;
import com.example.udyogsathi.Login.ActivityLogin;
import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.R;
import com.example.udyogsathi.Register.ActivityRegister;
import com.example.udyogsathi.OTP.ActivityOtp;
import com.example.udyogsathi.databinding.ActivityOtpBinding;
import com.google.gson.Gson;

import utils.Utility;

public class ActivityOtp extends Utility {
 ActivityOtpBinding binding;
OtpViewModel viewModel;
OtpResponse responsee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
viewModel= new ViewModelProvider(this).get(OtpViewModel.class);
        binding.reContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ActivityOtp.this, ActivityDisabilityType.class);
                startActivity(i);
            }
        });
        binding.reContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isInternetConnected(ActivityOtp.this)){
                    if(Validation()){
                        getOtp();
                    }
                }
            }
        });
    }

    private void getOtp() {
        String otp= binding.edtOtp.getOTP();
        User user= new User();
        user.setOtp(otp);
        user.setEmail(pref.getPrefString(this,pref.user_email));
        binding.loader.rlLoader.setVisibility(View.VISIBLE);
        Gson gson = new Gson();
        String json = gson.toJson(user);
        Log.d("TAG", "getRegistered: "+otp);
        Log.d("TAG", "getLoggedIn: "+json);

        viewModel.getRegister(user).observe(this, response -> {

            if (response != null) {
                binding.loader.rlLoader.setVisibility(View.GONE);
                if(response.getStatus()==200){
                    responsee = response;

//                    pref.setPrefString(this,pref.user_token,response.getToken());
                    Log.e("TAG", "res "+response);
                   pref.setPrefBoolean(ActivityOtp.this,pref.login_status,true);
                    savepref();
//                    pref.setPrefString(this,pref.user_token,response.getData().getToken());
                    Intent intent = new Intent(ActivityOtp.this, ContainerActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    binding.loader.rlLoader.setVisibility(View.GONE);
                    Toast.makeText(this, ""+response.message, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void savepref(){
        pref.setPrefString(this,pref.user_token,responsee.data.getToken());
        pref.setPrefString(this,pref.user_id,responsee.data.getUserId());
    }

    public boolean Validation(){
       if(binding.edtOtp.getOTP().isEmpty()){
           binding.edtOtp.showError();
           return false;
       }else if(binding.edtOtp.getOTP().length()< 6){
           binding.edtOtp.showError();
           return  false;
       }

        return true;
    }
}