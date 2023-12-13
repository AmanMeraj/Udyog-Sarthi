package com.example.udyogsathi.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.udyogsathi.Home.HomeFragment;
import com.example.udyogsathi.Login.ActivityLogin;
import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityRegisterBinding;
import com.google.gson.Gson;

import utils.Utility;

public class ActivityRegister extends Utility {
ActivityRegisterBinding binding;
RegisterResponse responsee;
RegisterViewModel viewModel;
String gender="male";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
  viewModel= new ViewModelProvider(this).get(RegisterViewModel.class);



        binding.reMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.reMale.setBackgroundResource(R.drawable.bg_button);
                binding.tvMale.setTextColor(Color.WHITE);
                binding.imgMale.setBackgroundResource(R.drawable.male);
                binding.imgMale.setImageTintList(ColorStateList.valueOf(Color.WHITE));
                binding.reFemale.setBackgroundResource(R.drawable.border);
                binding.tvFemale.setTextColor(Color.BLACK);
                binding.imgFeml.setBackgroundResource(R.drawable.female);
                binding.imgFeml.setImageTintList(ColorStateList.valueOf(Color.BLACK));

                gender="male";

            }
        });

        binding.reFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                binding.reFemale.setBackgroundResource(R.drawable.bg_button);
                binding.tvFemale.setTextColor(Color.WHITE);
                binding.imgFeml.setBackgroundResource(R.drawable.female_w);
                binding.imgFeml.setImageTintList(ColorStateList.valueOf(Color.WHITE));

                binding.reMale.setBackgroundResource(R.drawable.border);
                binding.tvMale.setTextColor(Color.BLACK);
                binding.imgMale.setBackgroundResource(R.drawable.male_b);
                binding.imgMale.setImageTintList(ColorStateList.valueOf(Color.BLACK));
                gender = "female";

            }
        });
        binding.reContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isInternetConnected(ActivityRegister.this)){
                  if(Validation()){
                    getRegistered();}
                }
            }
        });
    }

    private void getRegistered() {
        String name= binding.tvName.getText().toString();
        String email= binding.tvEmail.getText().toString();
        String address= binding.tvAddress.getText().toString();
        String dob= binding.tvDob.getText().toString();
       String aadhar= binding.tvAadhar.getText().toString();
       String number=binding.tvPhone.getText().toString();
       String qualification=binding.tvQualification.getText().toString();
        User user= new User();
        user.setName(name);
        user.setEmail(email);
        user.setAdress(address);
        user.setDob(dob);
        user.setAadhar(aadhar);
        user.setPhone(number);
        user.setGender(gender);
        user.setHighQualificaton(qualification);


        binding.loader.rlLoader.setVisibility(View.VISIBLE);
        Gson gson = new Gson();
        String json = gson.toJson(user);
        Log.d("TAG", "getRegistered: "+number);
        Log.d("TAG", "getLoggedIn: "+json);

        viewModel.getRegister(user).observe(this, response -> {

            if (response != null) {
                binding.loader.rlLoader.setVisibility(View.GONE);
                if(response.getStatus()==200){
                    responsee = response;

//                    pref.setPrefString(this,pref.user_token,response.getToken());
                    Log.e("TAG", "res "+response);
//                    pref.setPrefBoolean(DetailsActivity.this,pref.login_status,true);
//                    pref.setPrefString(this,pref.user_token,response.getData().getToken());
                    Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    binding.loader.rlLoader.setVisibility(View.GONE);
                    Toast.makeText(this, ""+responsee.message, Toast.LENGTH_SHORT).show();

                }
            }else {
                binding.loader.rlLoader.setVisibility(View.GONE);
                Toast.makeText(this, "else "+responsee.message, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public boolean Validation(){
        if(binding.tvName.getText().toString().isEmpty()){
            binding.tvName.setError("Field Required");
            binding.tvName.requestFocus();
            return  false;
        }else if(binding.tvEmail.getText().toString().isEmpty()&& !Patterns.EMAIL_ADDRESS.matcher(binding.tvEmail.getText().toString()).matches()){
            binding.tvEmail.setError("Enter Valid Email");
            binding.tvEmail.requestFocus();
            return false;
        } else if (binding.tvAddress.getText().toString().isEmpty()) {
            binding.tvAddress.setError("Field Required");
            binding.tvAddress.requestFocus();
            return false;
        }else if(binding.tvDob.getText().toString().isEmpty()){
            binding.tvDob.setError("Field Required");
            binding.tvDob.requestFocus();
            return false;
        }else if(binding.tvAadhar.getText().toString().isEmpty()){
            binding.tvAadhar.setError("Enter Aadhaar number");
            binding.tvAadhar.requestFocus();
            return false;
        }else if(binding.tvPhone.getText().toString().isEmpty()){
            binding.tvPhone.setError("Enter Mobile number");
            binding.tvPhone.requestFocus();
            return false;
        }else if(binding.tvQualification.getText().toString().isEmpty()){
            binding.tvQualification.setError("Enter Highest  Qualification");
            binding.tvQualification.requestFocus();
            return false;
        }
        return true;
    }
}