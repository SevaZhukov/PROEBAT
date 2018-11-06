package com.memebattle.proebat.core.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MissDAO {

    @Insert
    void createMiss(final Miss miss);

    @Query("SELECT SUM(amountOfMiss) FROM miss")
        //Проебы за все время
    long getSumOfMiss();

    @Query("SELECT SUM(amountOfMiss) FROM miss WHERE date >= :beginDate and date <= :endDate")
        //Проебы за период
    long getSumOfMiss(long beginDate, long endDate);

    @Query("DELETE FROM miss")
        //Удалить все
    void dropDatabase();

}