package com.example.udyogsathi.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.udyogsathi.Adapter.AdapterNews;
import com.example.udyogsathi.Model.News;
import com.example.udyogsathi.R;
import com.example.udyogsathi.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
FragmentHomeBinding binding;
ArrayList<News>news;
AdapterNews adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding=FragmentHomeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        news= new ArrayList<>();
        for(int i=0;i<4;i++){
         News obj1 = new News("Job Title","This the the description area where the description will be displayed","30 min ago",R.drawable.news_img);
         news.add(obj1);
         News obj2 = new News("Executive","This the the description area where the description will be displayed","30 min ago",R.drawable.news_img);
         news.add(obj2);
        }
        adapter= new AdapterNews(requireActivity(),news);
        binding.recycler.setAdapter(adapter);

        return root;
    }
}