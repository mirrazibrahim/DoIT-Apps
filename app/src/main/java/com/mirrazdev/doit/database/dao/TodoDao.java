package com.mirrazdev.doit.database.dao;

import com.mirrazdev.doit.database.entitas.Todo;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    List<Todo> getAll();

    @Query("INSERT INTO todo (aktifitas,keterangan) VALUES (:aktifitas,:keterangan)")
    void insertAll(String aktifitas, String keterangan);

    @Query("UPDATE todo SET aktifitas=:aktifitas, keterangan=:keterangan WHERE tid=:tid")
    void update(int tid, String aktifitas, String keterangan);

    @Query("SELECT * FROM todo WHERE tid=:tid")
    Todo get(int tid);

    @Delete
    void delete(Todo todo);
}
