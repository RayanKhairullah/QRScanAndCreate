package com.example.barcodescanncreate;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "scan_history")
public class ScanHistory {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String data;
    public long timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScanHistory that = (ScanHistory) o;
        return id == that.id &&
                timestamp == that.timestamp &&
                data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, timestamp);
    }
}

