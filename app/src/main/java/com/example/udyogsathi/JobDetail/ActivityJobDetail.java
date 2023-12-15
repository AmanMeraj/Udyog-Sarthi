package com.example.udyogsathi.JobDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.udyogsathi.Adapter.AdapterStudyModule;
import com.example.udyogsathi.Model.Home;
import com.example.udyogsathi.Model.Jobs;
import com.example.udyogsathi.Model.Module;
import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.ActivityJobDetailBinding;


import java.util.ArrayList;

import utils.Utility;

public class ActivityJobDetail extends Utility {
ActivityJobDetailBinding binding;
JobDetailsViewModel viewModel;
int position;
ArrayList<Jobs>dataa;
JobDetailResponse responsee;
AdapterStudyModule adapter;
String courseid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityJobDetailBinding.inflate(getLayoutInflater());
        viewModel=new ViewModelProvider(this).get(JobDetailsViewModel.class);
        setContentView(binding.getRoot());
        Bundle b= new Bundle();
        b=getIntent().getExtras();
        if(b!=null) {
            position = b.getInt("pos");

            dataa = (ArrayList<Jobs>) getIntent().getSerializableExtra("KEY");
            courseid=dataa.get(position).getCourseId();
        }

        if(isInternetConnected(this)){
            getjobdetail();

        }

    }

    private void getjobdetail() {
        binding.loader.rlLoader.setVisibility(View.VISIBLE);
        String auth=pref.getPrefString(this,pref.user_token);
        Log.d("TAG", "getjobdetail: "+courseid);
        String courseId=courseid;
        User user= new User();
        user.setCourseId(courseId);

        Log.d("TAG", "getLoggedIn: "+auth+" "+courseId);
        viewModel.getJobDetails(auth,user).observe(this, response -> {
            Log.d("TAG", "get_status: "+response);
            if (response != null) {
                Log.d("TAG", "res "+response.getStatus());
                binding.loader.rlLoader.setVisibility(View.GONE);
                if(response.getStatus()==200){
                    responsee = response;
                    binding.loader.rlLoader.setVisibility(View.GONE);
                    Log.e("TAG", "res "+response);
                     binding.jobTitle.setText(response.data.getTitle());
                     binding.jobDesc.setText(response.data.getDesc());
                    populate();
                }
                else {
                    Toast.makeText(this, "else "+response.getMessage(), Toast.LENGTH_SHORT).show();
                    binding.loader.rlLoader.setVisibility(View.GONE);
                }
            }
        });
    }


    private void populate() {
adapter= new AdapterStudyModule(this,responsee.data.getModules());
binding.recycler.setAdapter(adapter);
    }
}