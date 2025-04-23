package com.example.barcodescanncreate.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ScanHistory.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ScanHistoryDao historyDao();
    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context ctx) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(),
                    AppDatabase.class, "qr_scanner_db").build();
        }
        return INSTANCE;
    }
}
