package com.snakegame;

import java.awt.*;
import java.util.Random;

public class Food {
    private Location location;
    private Color color;
    private Integer points;

    public Food(){
        this.location=Location.getRandomLocation();
        this.color=GameSettings.FOOD_COLOR;
        Random random=new Random();

        this.points=random.nextInt(GameSettings.MAX_FOOD_POINTS)+1;
    }

    public Location getLocation() {
        return location;
    }

    public Color getColor() {
        return color;
    }

    public Integer getPoints() {
        return points;
    }
}
