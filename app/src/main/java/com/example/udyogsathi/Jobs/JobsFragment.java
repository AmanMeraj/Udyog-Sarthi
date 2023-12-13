package com.example.udyogsathi.Jobs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.udyogsathi.Adapter.AdapterJobs;
import com.example.udyogsathi.Adapter.AdapterNews;
import com.example.udyogsathi.Model.Jobs;
import com.example.udyogsathi.Model.News;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.FragmentJobsBinding;

import java.util.ArrayList;


public class JobsFragment extends Fragment {
FragmentJobsBinding binding;
AdapterJobs adapter;
ArrayList<Jobs> jobs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentJobsBinding.inflate(getLayoutInflater());
   View root=binding.getRoot();

        jobs= new ArrayList<>();
        for(int i=0;i<4;i++){
            Jobs obj1 = new Jobs(R.drawable.job_img,"Product manager","this role is for people with a sharp mind");
            jobs.add(obj1);
            Jobs obj2 = new Jobs(R.drawable.job_img,"Executive","this role is for handeling clients problem");
            jobs.add(obj2);
        }
        adapter= new AdapterJobs(requireActivity(),jobs);
        binding.recycler.setAdapter(adapter);

        return root;
    }
}