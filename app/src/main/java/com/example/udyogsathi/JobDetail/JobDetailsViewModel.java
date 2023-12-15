package com.example.udyogsathi.JobDetail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.udyogsathi.Jobs.JobsRepository;
import com.example.udyogsathi.Jobs.JobsResponsee;
import com.example.udyogsathi.Model.User;

public class JobDetailsViewModel  extends AndroidViewModel {
    private JobDetailsRepository repository;
    private LiveData<JobDetailResponse> responseLiveData;

    public JobDetailsViewModel(@NonNull Application application) {
        super(application);
        repository = new JobDetailsRepository();
    }


    public LiveData<JobDetailResponse> getJobDetails(String auth, User user) {
        this.responseLiveData = repository.jobdetails(auth,user);
        return responseLiveData;
    }
}