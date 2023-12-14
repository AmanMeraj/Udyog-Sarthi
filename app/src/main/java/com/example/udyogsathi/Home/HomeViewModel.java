package com.example.udyogsathi.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.Register.RegisterRepository;
import com.example.udyogsathi.Register.RegisterResponse;

public class HomeViewModel extends AndroidViewModel {
    private HomeRepository repository;
    private LiveData<HomeResponse> responseLiveData;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new HomeRepository();
    }


    public LiveData<HomeResponse> getHome(String auth) {
        this.responseLiveData = repository.home(auth);
        return responseLiveData;
    }
}