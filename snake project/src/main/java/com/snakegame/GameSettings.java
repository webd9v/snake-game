package com.snakegame;

import java.awt.*;

public class GameSettings {
    public final static Integer WIDTH=500;
    public final static Integer HEIGHT=500;
    public final static Integer FOOD_COUNT=10;
    public final static Color FOOD_COLOR=Color.RED;
    public final static Integer SNAKE_SIZE=10;
    public final static Integer SCALE=10;
    public final static Integer SPEED=150;
    public final static Integer SNAKE_START_X=20;
    public final static Integer SNAKE_START_Y=20;
    public final static Integer FOOD_ARC_ANGLE=60;
    public final static Direction DIRECTION=Direction.Right;
    public final static Integer MAX_FOOD_POINTS=10;
    //direction works here only if its single player
    private static GameSettings INSTANCE;
    private Integer score;
    private GameSettings(){
        score=0;
    }
    public static GameSettings getInstance(){
        if(INSTANCE==null){
            INSTANCE=new GameSettings();
            return INSTANCE;
        }
        else{
            return GameSettings.INSTANCE;
        }
    }

    public void addScore(Integer points){
        this.score+=points;
    }
    public Integer getScore(){
        return score;
    }
    public void resetScore(){
        this.score=0;
    }
}
