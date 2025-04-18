package com.example.barcodescanncreate;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.concurrent.Executors;

@Dao
public interface ScanHistoryDao {
    @Insert
    void insert(ScanHistory history);

    @Query("SELECT * FROM scan_history ORDER BY timestamp DESC")
    LiveData<List<ScanHistory>> getAllHistory();

    @Delete
    void delete(ScanHistory history);
}