package com.yjl.spring.model;

import java.util.Date;

public class User2MovieRate extends User2MovieRateKey {
    private Double rating;

    private Date ratingTime;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Date getRatingTime() {
        return ratingTime;
    }

    public void setRatingTime(Date ratingTime) {
        this.ratingTime = ratingTime;
    }
}