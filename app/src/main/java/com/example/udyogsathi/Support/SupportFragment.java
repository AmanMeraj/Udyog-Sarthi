package com.example.udyogsathi.Support;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.udyogsathi.Adapter.AdapterHelp;
import com.example.udyogsathi.Model.Help;
import com.example.udyogsathi.databinding.FragmentSupportBinding;

import java.util.ArrayList;

public class SupportFragment extends Fragment {
    FragmentSupportBinding binding;
    ArrayList<Help>helps;
    AdapterHelp adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding=FragmentSupportBinding.inflate(getLayoutInflater());
      View root=binding.getRoot();
        helps= new ArrayList<>();
        for(int i=0;i<4;i++){
            Help obj1 = new Help("Job Title","This the the description area where the description will be displayed","Closed");
            helps.add(obj1);
            Help obj2 = new Help("Executive","This the the description area where the description will be displayed","Pending");
            helps.add(obj2);
        }
        adapter= new AdapterHelp(requireActivity(),helps);
        binding.recycler.setAdapter(adapter);

        return root;
    }
}