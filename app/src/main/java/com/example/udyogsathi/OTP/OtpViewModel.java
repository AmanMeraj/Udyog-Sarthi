package com.example.udyogsathi.OTP;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.Register.RegisterRepository;
import com.example.udyogsathi.Register.RegisterResponse;

public class OtpViewModel extends AndroidViewModel {
    private OtpRepository repository;
    private LiveData<OtpResponse> responseLiveData;

    public OtpViewModel(@NonNull Application application) {
        super(application);
        repository = new OtpRepository();
    }


    public LiveData<OtpResponse> getRegister(User user) {
        this.responseLiveData = repository.otp(user);
        return responseLiveData;
    }
}

