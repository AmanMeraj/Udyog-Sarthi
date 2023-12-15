package com.example.udyogsathi.JobDetail;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.udyogsathi.Jobs.JobsRepository;
import com.example.udyogsathi.Jobs.JobsResponsee;
import com.example.udyogsathi.Model.User;

import retrofit.ApiRequest;
import retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobDetailsRepository{
    private static final String TAG = JobDetailsRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public JobDetailsRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }


    public LiveData<JobDetailResponse> jobdetails(String auth, User user){
        final MutableLiveData<JobDetailResponse> data = new MutableLiveData<>();
        apiRequest.getJobDetails(auth,user)
                .enqueue(new Callback<JobDetailResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<JobDetailResponse> call, @NonNull Response<JobDetailResponse> response) {
                        Log.e(TAG, "onResponse :: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<JobDetailResponse> call, Throwable t) {
                        Log.d("TAG","OnFailure"+t.getMessage());
                        data.setValue(null);
                    }
                });

        return data;
    }
}