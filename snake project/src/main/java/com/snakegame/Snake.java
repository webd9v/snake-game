package com.snakegame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Snake {
    private Direction direction;
    private Color color;
    private List<SnakePart> snakeParts;
    public Snake(Color color,Integer numberOfSnakeParts,Direction direction){
        this.color=color;
        snakeParts=new ArrayList<>();
        for(int i=0;i<numberOfSnakeParts;i++){
            //Create a new location
            //(0,0) (1,0) (2,0)
            Location location=new Location(GameSettings.SNAKE_START_X+(i*GameSettings.SCALE),GameSettings.SNAKE_START_Y);
            //Create a new snake part and initialize its location
            SnakePart snakePart=new SnakePart(location);
            //Add snake part to list
            snakeParts.add(snakePart);
            this.direction=direction;
        }
    }


    public SnakePart[] getSnakeParts(){
        SnakePart[] snakeParts=new SnakePart[this.snakeParts.size()];
        this.snakeParts.toArray(snakeParts);
        return snakeParts;
    }

    public Color getColor() {
        return color;
    }
    public void move(){
        Location location=snakeParts.get(snakeParts.size()-1).getLocation();
        SnakePart sp=snakeParts.remove(0);

        Integer x=location.getX();
        Integer y=location.getY();
        switch (direction){
            case Up -> {
                if(y==0){
                    y=GameSettings.HEIGHT-5*GameSettings.SCALE;
                }else{
                    y-=GameSettings.SCALE;
                }
                break;
            }
            case Down -> {
                if(y==GameSettings.HEIGHT-4*GameSettings.SCALE){
                    y=0;
                }else {
                    y += GameSettings.SCALE;
                }
                break;
            }
            case Left -> {
                if(x==0){
                    x=GameSettings.WIDTH-GameSettings.SCALE;
                }else{
                    x-=GameSettings.SCALE;
                }

                break;
            }
            case Right -> {
                if(x==GameSettings.WIDTH-GameSettings.SCALE){
                    x=0;
                }else{
                    x+=GameSettings.SCALE;
                }
                break;
            }
        }
        location=sp.getLocation();
        location.setX(x);
        location.setY(y);
        snakeParts.add(sp);
    }
    public void setDirection(Direction direction){
        if(!this.direction.isOppositeDirection(direction) && !this.direction.equals(direction)){
            this.direction=direction;

        }
    }
    public Location getHeadLocation(){
        SnakePart snakePart=snakeParts.get(snakeParts.size()-1);
        return snakePart.getLocation();
    }
    public void eatFood(){
        Location location=snakeParts.get(0).getLocation();
        SnakePart snakePart=new SnakePart(location.clone());
        snakeParts.add(0,snakePart);
    }
}
