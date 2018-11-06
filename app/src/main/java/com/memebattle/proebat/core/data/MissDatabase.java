package com.memebattle.proebat.core.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Miss.class}, version = 1)
public abstract class MissDatabase extends RoomDatabase {
    public abstract MissDAO missDAO();
}
