package com.example.database;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities ={Tavla.class} ,version = 1)
public abstract class Database extends RoomDatabase {
    private static Database instance;

    public abstract TavlaDao TavlaDao();

    public static synchronized Database getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(
                    context.getApplicationContext(),
                    Database.class,
                    "db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
