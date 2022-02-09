package com.snakegame;

public class SnakePart {
    private Location location;
    public SnakePart(Location location){
        this.location=location;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location){
       // if(Direction.getOppositeDirection())
        this.location=location;
    }
}
