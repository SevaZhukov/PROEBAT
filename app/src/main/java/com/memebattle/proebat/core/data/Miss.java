package com.memebattle.proebat.core.data;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Miss {

    public Miss(long date, long amountOfClasses, long amountOfMiss) {
        this.date = date;
        this.amountOfClasses = amountOfClasses;
        this.amountOfMiss = amountOfMiss;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;

    private long date;

    private long amountOfClasses;

    private long amountOfMiss;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getAmountOfClasses() {
        return amountOfClasses;
    }

    public void setAmountOfClasses(long amountOfClasses) {
        this.amountOfClasses = amountOfClasses;
    }

    public long getAmountOfMiss() {
        return amountOfMiss;
    }

    public void setAmountOfMiss(long amountOfMiss) {
        this.amountOfMiss = amountOfMiss;
    }
}
