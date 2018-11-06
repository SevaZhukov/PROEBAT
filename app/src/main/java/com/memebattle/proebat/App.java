package com.memebattle.proebat;

import android.app.Application;

import com.memebattle.proebat.core.data.MissDatabase;

import androidx.room.Room;

public class App extends Application {

    public static App instance;

    private MissDatabase missDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        missDatabase = Room.databaseBuilder(this,
                MissDatabase.class, "database").build();
    }

    public static App getInstance() {
        return instance;
    }

    public MissDatabase getMissDatabase() {
        return missDatabase;
    }
}
