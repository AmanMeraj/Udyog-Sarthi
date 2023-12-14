package com.example.udyogsathi.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.udyogsathi.Adapter.AdapterNews;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import utils.SharedPref;
import utils.Utility;

public class HomeFragment extends Fragment {
FragmentHomeBinding binding;
Utility utility = new Utility();
HomeResponse responsee;
HomeViewModel viewModel;
public SharedPref pref = new SharedPref();
AdapterNews adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding=FragmentHomeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        viewModel= new ViewModelProvider(this).get(HomeViewModel.class);

if(utility.isInternetConnected(requireActivity())){
    getNews();
}
        return root;
    }

    private void getNews() {
        binding.loader.rlLoader.setVisibility(View.VISIBLE);
        String auth=pref.getPrefString(requireActivity(),pref.user_token);
        Log.d("TAG", "getLoggedIn: "+auth);
        viewModel.getHome(auth).observe(requireActivity(), response -> {
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
                    // Log.e("TAG", "res "+response.getStatus());
                    Toast.makeText(requireActivity(), "else "+response.getStatus(), Toast.LENGTH_SHORT).show();
                    binding.loader.rlLoader.setVisibility(View.GONE);
                }
            }
        });
    }

    private void populate() {
        if(responsee.data.size()>0){
            adapter = new AdapterNews(requireActivity(),responsee.data);
            binding.recycler.setAdapter(adapter);
        }else {
            Toast.makeText(requireActivity(), "No New News", Toast.LENGTH_SHORT).show();
        }

    }
}