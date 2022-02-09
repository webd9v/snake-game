package com.snakegame;

import java.util.Random;

public class Location {
    private Integer x;
    private Integer y;

    public Location(Integer x,Integer y){
        this.x=x;
        this.y=y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }
    public static Location getRandomLocation(){
        Random random=new Random();
        Integer x = random.nextInt(GameSettings.WIDTH/GameSettings.SCALE)*GameSettings.SCALE;
        Integer y = random.nextInt(GameSettings.HEIGHT/GameSettings.SCALE)*GameSettings.SCALE;
        //that means the x and y will be from 0 to 999
        return new Location(x,y);
    }
    public Boolean equals(Location location){
        return x.equals(location.getX()) && y.equals(location.getY());
    }
    public  Location clone(){
        return new Location(x,y);
    }
}
