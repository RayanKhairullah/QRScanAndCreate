package com.example.barcodescanncreate;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executors;

public class HistoryRepository {
    private final ScanHistoryDao dao;
    public HistoryRepository(Context ctx) {
        dao = AppDatabase.getInstance(ctx).historyDao();
    }
    public void insert(ScanHistory history) {
        Executors.newSingleThreadExecutor().execute(() -> dao.insert(history));
    }
    public LiveData<List<ScanHistory>> getAll() {
        return dao.getAllHistory();
    }
    public void delete(ScanHistory history) {
        Executors.newSingleThreadExecutor().execute(() -> dao.delete(history));
    }
}

