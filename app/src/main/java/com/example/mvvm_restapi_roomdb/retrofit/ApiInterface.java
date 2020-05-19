package com.example.mvvm_restapi_roomdb.retrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("get_data.php/")
    Observable<List<Employee>> getAllEmployee();
}
