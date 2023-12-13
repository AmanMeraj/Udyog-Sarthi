package com.example.udyogsathi.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.OTP.ActivityOtp;
import com.example.udyogsathi.R;
import com.example.udyogsathi.Register.ActivityRegister;
import com.example.udyogsathi.databinding.ActivityLoginBinding;
import com.google.gson.Gson;

import utils.Utility;

public class ActivityLogin extends Utility {
ActivityLoginBinding binding;
LoginViewModel viewModel;
LoginResponse responsee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
viewModel= new ViewModelProvider(this).get(LoginViewModel.class);
        binding.reBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(isInternetConnected(ActivityLogin.this)){
                   if(Validation()){
                       getLogin();
                   }
               }

            }
        });
        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityLogin.this,ActivityRegister.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void getLogin() {
        String email= binding.edtEmail.getText().toString();
        binding.loader.rlLoader.setVisibility(View.VISIBLE);
        User user= new User();
        user.setEmail(email);
        Gson gson = new Gson();
        String json = gson.toJson(user);
        Log.d("TAG", "getRegistered: "+user);
        Log.d("TAG", "getLoggedIn: "+json);

        viewModel.getLogin(user).observe(this, response -> {
            Log.e("TAG", "resActi "+response);

            if (response != null) {
                binding.loader.rlLoader.setVisibility(View.GONE);
                if(response.getStatus()==200){
                    responsee = response;
savePref();
//                    pref.setPrefString(this,pref.user_token,response.getToken());
                    Log.e("TAG", "res "+response);
//                    pref.setPrefBoolean(DetailsActivity.this,pref.login_status,true);
                    Toast.makeText(this, "sucessfullllll"+response.getMessage(), Toast.LENGTH_SHORT).show();
//                    pref.setPrefString(this,pref.user_token,response.getData().getToken());
                    Intent intent = new Intent(ActivityLogin.this, ActivityOtp.class);
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
    public void savePref(){
        pref.setPrefString(this,pref.user_email,binding.edtEmail.getText().toString());
    }
    public  boolean Validation(){
        if(binding.edtEmail.getText().toString().isEmpty()&& !Patterns.EMAIL_ADDRESS.matcher(binding.edtEmail.getText().toString()).matches()){
            binding.edtEmail.setError("Enter Valid Email");
            binding.edtEmail.requestFocus();
            return false;
        }
        return true;
    }
}