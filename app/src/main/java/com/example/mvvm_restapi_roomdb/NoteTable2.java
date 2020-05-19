package com.example.mvvm_restapi_roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = NoteTable1.class,
        parentColumns = "id",
        childColumns = "sub_id",
        onDelete = ForeignKey.CASCADE))
public class NoteTable2 {

    @PrimaryKey(autoGenerate = true)
    private String count;

    @ColumnInfo(name = "sub_id")
    private String id;

    private String status;

    private String price;
}
