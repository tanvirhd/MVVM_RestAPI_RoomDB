package com.example.mvvm_restapi_roomdb;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table1")
public class NoteTable1 {

    @PrimaryKey(autoGenerate = true)
    private String id;

    private String title;

    private String description;

    private int priority;

}