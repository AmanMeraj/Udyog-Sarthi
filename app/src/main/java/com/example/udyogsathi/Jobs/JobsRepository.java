package com.example.udyogsathi.Jobs;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.udyogsathi.Login.LoginRepository;
import com.example.udyogsathi.Login.LoginResponse;
import com.example.udyogsathi.Model.User;

import retrofit.ApiRequest;
import retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobsRepository {
    private static final String TAG = JobsRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public JobsRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }


    public LiveData<JobsResponsee> jobs(String auth,User user){
        final MutableLiveData<JobsResponsee> data = new MutableLiveData<>();
        apiRequest.getJobs(auth,user)
                .enqueue(new Callback<JobsResponsee>() {
                    @Override
                    public void onResponse(@NonNull Call<JobsResponsee> call, @NonNull Response<JobsResponsee> response) {
                        Log.e(TAG, "onResponse :: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<JobsResponsee> call, Throwable t) {
                        Log.d("TAG","OnFailure"+t.getMessage());
                        data.setValue(null);
                    }
                });

        return data;
    }
}