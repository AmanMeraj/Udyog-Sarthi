package com.example.udyogsathi.Register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udyogsathi.Model.User;

public class RegisterViewModel extends AndroidViewModel {
    private RegisterRepository repository;
    private LiveData<RegisterResponse> responseLiveData;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        repository = new RegisterRepository();
    }


    public LiveData<RegisterResponse> getRegister(User user) {
        this.responseLiveData = repository.register(user);
        return responseLiveData;
    }
}

