package com.example.udyogsathi.Jobs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.udyogsathi.Adapter.AdapterJobs;
import com.example.udyogsathi.Model.Jobs;
import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.FragmentJobsBinding;

import java.util.ArrayList;

import utils.SharedPref;
import utils.Utility;


public class JobsFragment extends Fragment {
FragmentJobsBinding binding;
Utility utility= new Utility();
SharedPref pref= new SharedPref();
JobsResponsee responsee;
JobsViewModel viewModel;
AdapterJobs adapter;
ArrayList<Jobs> jobs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentJobsBinding.inflate(getLayoutInflater());
   View root=binding.getRoot();
   viewModel = new ViewModelProvider(this).get(JobsViewModel.class);

if(utility.isInternetConnected(requireActivity())){
    getJobs();

}


        return root;
    }

    private void getJobs() {
        binding.loader.rlLoader.setVisibility(View.VISIBLE);
        String auth=pref.getPrefString(requireActivity(),pref.user_token);
        String userId=pref.getPrefString(requireActivity(),pref.user_id);
        User user= new User();
        user.setUserId(userId);

        Log.d("TAG", "getLoggedIn: "+auth+" "+userId);
        viewModel.getJobs(auth,user).observe(requireActivity(), response -> {
            Log.d("TAG", "get_status: "+response);
            if (response != null) {
                Log.d("TAG", "res "+response.getStatus());
                binding.loader.rlLoader.setVisibility(View.GONE);
                if(response.getStatus()==200){
                    responsee = response;
                    binding.loader.rlLoader.setVisibility(View.GONE);
                    Log.e("TAG", "res "+response);

                    populate();
                }
                else {
                    Toast.makeText(requireActivity(), "else "+response.getMessage(), Toast.LENGTH_SHORT).show();
                    binding.loader.rlLoader.setVisibility(View.GONE);
                }
            }
        });
    }


    private void populate() {
        if(responsee.data.size()>0){
            adapter= new AdapterJobs(requireActivity(),responsee.data);
            binding.recycler.setAdapter(adapter);
        }
    }
}