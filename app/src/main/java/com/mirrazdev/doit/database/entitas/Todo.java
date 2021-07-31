package com.mirrazdev.doit.database.entitas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {
    @PrimaryKey
    public int tid;

    public String aktifitas;

    public String keterangan;
}
