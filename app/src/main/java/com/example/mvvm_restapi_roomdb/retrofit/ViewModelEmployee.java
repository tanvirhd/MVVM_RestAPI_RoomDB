package com.example.mvvm_restapi_roomdb.retrofit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

public class ViewModelEmployee extends AndroidViewModel {
    public static RepositoryEmployee repositoryEmployee;

    public ViewModelEmployee(@NonNull Application application) {
        super(application);
        if(repositoryEmployee==null)
        { repositoryEmployee=new RepositoryEmployee(); }
    }

    public LiveData<List<Employee>> getAllEmployeeInfo(){
        return repositoryEmployee.getEmployee();
    }

}