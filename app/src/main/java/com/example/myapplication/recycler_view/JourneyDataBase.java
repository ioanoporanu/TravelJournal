package com.example.myapplication.recycler_view;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Journey.class}, version = 1)
public abstract class JourneyDataBase extends RoomDatabase {
    public abstract JourneyDao journeyDao();

    private static JourneyDataBase instance;
    public static JourneyDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), JourneyDataBase.class, "Journey Name")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }
}
