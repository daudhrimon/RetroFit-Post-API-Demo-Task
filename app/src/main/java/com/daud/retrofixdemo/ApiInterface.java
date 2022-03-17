package com.daud.retrofixdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("entries")
    Call<ResponseMc> getData();
}
