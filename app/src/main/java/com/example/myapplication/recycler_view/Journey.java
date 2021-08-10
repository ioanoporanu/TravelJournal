package com.example.myapplication.recycler_view;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public
class Journey {
    private String journeyName;
    private String destination;
    private String price;
    private int image;
    @PrimaryKey(autoGenerate = true)
    public int id;

    @Ignore
    public Journey(String journeyName, String destination, String price) {
        this.journeyName = journeyName;
        this.destination = destination;
        this.price = price;
    }

    public Journey(String journeyName, String destination, String price, int image) {
        this.journeyName = journeyName;
        this.destination = destination;
        this.price = price;
        this.image = image;
    }

    public String getJourneyName() {
        return journeyName;
    }

    public void setJourneyName(String journeyName) {
        this.journeyName = journeyName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = "Price: " + price + "$";
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}