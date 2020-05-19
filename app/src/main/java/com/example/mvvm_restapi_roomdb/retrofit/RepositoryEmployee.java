package com.example.mvvm_restapi_roomdb.retrofit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepositoryEmployee {
    private ApiInterface apiRequest;

    public RepositoryEmployee() {
        apiRequest= ApiClient.getApiInterface();
    }

    public LiveData<List<Employee>> getEmployee(){
        final MutableLiveData<List<Employee>> response=new MutableLiveData<>();
        apiRequest.getAllEmployee()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Employee>>() {
                    @Override
                    public void accept(List<Employee> employees) throws Exception {
                        response.postValue(employees!=null?employees:null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("RepositryEmloyee", "accept: "+throwable.getMessage());
                    }
                } );

        return response;
    }

}
