package model;

import java.util.EnumMap;
import java.util.Map;

public class RatingInfo {
    private Map<Rating, Integer> ratings;

    public RatingInfo() {
        ratings = new EnumMap<>(Rating.class);
        for (Rating rating : Rating.values()) {
            ratings.put(rating, 0);
        }
    }

    public void update(final Rating rating) {
        ratings.put(rating, ratings.get(rating) + 1);
    }

    public int getCount(final Rating rating) {
        return ratings.get(rating);
    }
}
