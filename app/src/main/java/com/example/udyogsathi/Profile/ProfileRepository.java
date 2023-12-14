package com.example.udyogsathi.Profile;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.Register.RegisterRepository;
import com.example.udyogsathi.Register.RegisterResponse;

import retrofit.ApiRequest;
import retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    private static final String TAG = ProfileRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public ProfileRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }


    public LiveData<ProfileResponse> profile(String auth,User user){
        final MutableLiveData<ProfileResponse> data = new MutableLiveData<>();
        apiRequest.getProfile(auth,user)
                .enqueue(new Callback<ProfileResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<ProfileResponse> call, @NonNull Response<ProfileResponse> response) {
                        Log.e(TAG, "onResponse :: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ProfileResponse> call, @NonNull Throwable t) {
                        Log.d("TAG","OnFailure"+t.getMessage());
                        data.setValue(null);
                    }
                });

        return data;
    }
}