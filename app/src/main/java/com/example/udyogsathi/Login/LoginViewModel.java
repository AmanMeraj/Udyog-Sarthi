package com.example.udyogsathi.Login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.Register.RegisterRepository;
import com.example.udyogsathi.Register.RegisterResponse;

public class LoginViewModel extends AndroidViewModel {
    private LoginRepository repository;
    private LiveData<LoginResponse> responseLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = new LoginRepository();
    }


    public LiveData<LoginResponse> getLogin(User user) {
        this.responseLiveData = repository.login(user);
        return responseLiveData;
    }
}