package com.example.barcodescanncreate.history;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.barcodescanncreate.data.ScanHistory;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
    private final HistoryRepository repo;
    public LiveData<List<ScanHistory>> allHistory;
    public HistoryViewModel(Application app) {
        super(app);
        repo = new HistoryRepository(app);
        allHistory = repo.getAll();
    }
    public void insert(ScanHistory h) { repo.insert(h); }
    public void delete(ScanHistory h) {
        repo.delete(h);
    }
}

