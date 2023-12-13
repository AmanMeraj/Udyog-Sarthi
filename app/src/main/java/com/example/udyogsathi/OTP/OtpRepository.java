package com.example.udyogsathi.OTP;

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

public class OtpRepository {
    private static final String TAG = OtpRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public OtpRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }


    public LiveData<OtpResponse> otp(User user){
        final MutableLiveData<OtpResponse> data = new MutableLiveData<>();
        apiRequest.getOtp(user)
                .enqueue(new Callback<OtpResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<OtpResponse> call, @NonNull Response<OtpResponse> response) {
                        Log.e(TAG, "onResponse :: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<OtpResponse> call, Throwable t) {
                        Log.d("TAG","OnFailure"+t.getMessage());
                        data.setValue(null);
                    }
                });

        return data;
    }
}