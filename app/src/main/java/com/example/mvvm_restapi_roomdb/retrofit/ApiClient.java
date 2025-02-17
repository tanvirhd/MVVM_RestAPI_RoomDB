package com.example.mvvm_restapi_roomdb.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;
    //private static final String baseURL="https://restuarant.techtrixbd.com/api/";
    private static final String baseURL="https://12032020.000webhostapp.com/employee_details/";
    private static ApiInterface apiInterface;

    public static synchronized ApiInterface getApiInterface(){
        if(retrofit==null){
            retrofit=new retrofit2.Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            apiInterface=retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }

}
