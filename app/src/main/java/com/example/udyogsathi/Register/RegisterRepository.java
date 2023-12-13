package com.example.udyogsathi.Register;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.udyogsathi.Model.User;

import retrofit.ApiRequest;
import retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterRepository{
        private static final String TAG = RegisterRepository.class.getSimpleName();
        private final ApiRequest apiRequest;

        public RegisterRepository() {
                apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
        }


        public LiveData<RegisterResponse> register(User user){
                final MutableLiveData<RegisterResponse> data = new MutableLiveData<>();
                apiRequest.getRegistered(user)
                        .enqueue(new Callback<RegisterResponse>() {
                                @Override
                                public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                                        Log.e(TAG, "onResponse :: " + response);
                                        if (response.body() != null) {
                                                data.setValue(response.body());
                                        }
                                }
                                @Override
                                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                                        Log.d("TAG","OnFailure"+t.getMessage());
                                        data.setValue(null);
                                }
                        });

                return data;
        }
}