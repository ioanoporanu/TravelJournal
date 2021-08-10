package com.example.myapplication.recycler_view;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface JourneyDao {

    @Query("SELECT * FROM journey")
    List<Journey> getJourneys();

    @Insert
    void insertJourney(Journey journey);

    @Delete
    void deleteJourney(Journey journey);
}
