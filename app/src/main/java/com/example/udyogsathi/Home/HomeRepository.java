package com.example.udyogsathi.Home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.udyogsathi.Model.User;
import com.example.udyogsathi.OTP.OtpRepository;
import com.example.udyogsathi.OTP.OtpResponse;

import retrofit.ApiRequest;
import retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    private static final String TAG = HomeRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public HomeRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }


    public LiveData<HomeResponse> home(String auth){
        final MutableLiveData<HomeResponse> data = new MutableLiveData<>();
        apiRequest.getHome(auth)
                .enqueue(new Callback<HomeResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<HomeResponse> call, @NonNull Response<HomeResponse> response) {
                        Log.e(TAG, "onResponse :: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<HomeResponse> call, Throwable t) {
                        Log.d("TAG","OnFailure"+t.getMessage());
                        data.setValue(null);
                    }
                });

        return data;
    }
}