package com.example.udyogsathi.Login;

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

public class LoginRepository {
    private static final String TAG = LoginRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public LoginRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }


    public LiveData<LoginResponse> login(User user){
        final MutableLiveData<LoginResponse> data = new MutableLiveData<>();
        apiRequest.getLogin(user)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                        Log.e(TAG, "onResponse :: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.d("TAG","OnFailure"+t.getMessage());
                        data.setValue(null);
                    }
                });

        return data;
    }
}