package com.example.udyogsathi.Jobs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udyogsathi.Login.LoginRepository;
import com.example.udyogsathi.Login.LoginResponse;
import com.example.udyogsathi.Model.User;

public class JobsViewModel extends AndroidViewModel {
    private JobsRepository repository;
    private LiveData<JobsResponsee> responseLiveData;

    public JobsViewModel(@NonNull Application application) {
        super(application);
        repository = new JobsRepository();
    }


    public LiveData<JobsResponsee> getJobs(String auth,User user) {
        this.responseLiveData = repository.jobs(auth,user);
        return responseLiveData;
    }
}