package com.example.udyogsathi.Profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.Register.RegisterRepository;
import com.example.udyogsathi.Register.RegisterResponse;

public class ProfileViewModel extends AndroidViewModel {
    private ProfileRepository repository;
    private LiveData<ProfileResponse> responseLiveData;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        repository = new ProfileRepository();
    }


    public LiveData<ProfileResponse> getProfile(String auth,User user) {
        this.responseLiveData = repository.profile(auth,user);
        return responseLiveData;
    }
}