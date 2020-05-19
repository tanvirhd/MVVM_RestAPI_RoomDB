package com.example.mvvm_restapi_roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvm_restapi_roomdb.retrofit.Employee;
import com.example.mvvm_restapi_roomdb.retrofit.ViewModelEmployee;
import com.example.mvvm_restapi_roomdb.room.Note;
import com.example.mvvm_restapi_roomdb.room.NoteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    ViewModelEmployee viewModelEmployee;
    NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModelEmployee=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelEmployee.class);
        noteViewModel=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(NoteViewModel.class);

        viewModelEmployee.getAllEmployeeInfo().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                Log.d(TAG, "onChanged: Employee Mail: "+employees.get(1).getEmail());
            }
        });

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Log.d(TAG, "onChanged: Note Title:"+notes.get(0).getTitle());
            }
        });
    }
}

    /*Retrofit2 and RoomDB with MVVM
        and more. All in one application.*/
