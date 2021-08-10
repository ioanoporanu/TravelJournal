package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.recycler_view.Journey;
import com.example.myapplication.recycler_view.JourneyDataBase;

public class AddNewJourneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        EditText journeyName = findViewById(R.id.enterJourneyName);
        EditText destinationName = findViewById(R.id.enterDestinationName);
        EditText journeyPrice = findViewById(R.id.journeyPrice);
        Button saveButton = findViewById(R.id.saveButton);
        EditText imageId = findViewById(R.id.imageId);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewJourney("Journey: " + journeyName.getText().toString(),"Destination: " + destinationName.getText().toString(), "Price: " + journeyPrice.getText().toString() + "$", imageId.getText().toString());
            }
        });
    }

    private void saveNewJourney(String journeyName, String destinationName, String price, String image){
        int resID = getResources().getIdentifier(image , "drawable", getPackageName());
        JourneyDataBase db = JourneyDataBase.getInstance(this.getApplicationContext());
        Journey journey = new Journey(journeyName, destinationName, price, resID);
        db.journeyDao().insertJourney(journey);

        finish();
    }



}