package com.example.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tavla")
public class Tavla {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String s;

    private Integer n;

    private String per;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }
}
