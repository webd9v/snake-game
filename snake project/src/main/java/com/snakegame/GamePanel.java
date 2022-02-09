package com.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//JPanel is a component to add to the JFrame
//if we wanted more than one player we should add a list of snakes
public class GamePanel extends JPanel implements ActionListener {
    private Snake snake;
    private List<Food> foodList;

    public GamePanel(){
        setPreferredSize(new Dimension(GameSettings.WIDTH,GameSettings.HEIGHT));
        snake=new Snake(Color.BLUE,GameSettings.SNAKE_SIZE,Direction.Right);
        foodList=new ArrayList<>();

        for(int i=0;i<GameSettings.FOOD_COUNT;i++){
            Food food=new Food();
            foodList.add(food);
        }
    }
    public void start(){
        Timer timer=new Timer(GameSettings.SPEED,this);
        timer.start();
    }
    public void setSnakeDirection(Direction direction){
        this.snake.setDirection(direction);
    }
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawSnake(graphics);

        drawFood(graphics,foodList.get(1));


    }
    private void drawSnake(Graphics graphics){
        graphics.setColor(this.snake.getColor());
        SnakePart[] snakeParts=this.snake.getSnakeParts();
        for(SnakePart snakePart:snakeParts){
            Location location=snakePart.getLocation();
            graphics.fillRect(location.getX(),location.getY(),GameSettings.SCALE,GameSettings.SCALE);

        }
    }
    private void drawFood(Graphics graphics,Food food){

            graphics.setColor(food.getColor());
            Location location=food.getLocation();
            Random random1=new Random();
            Integer random=random1.nextInt(2);
            if(random==0){
                graphics.fillRect(location.getX(),location.getY(),GameSettings.SCALE,GameSettings.SCALE);

            }else if(random==1){
                graphics.fillOval(location.getX(),location.getY(),GameSettings.SCALE,GameSettings.SCALE);

            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        checkForFood();
        validate();//clean up the panel so we can repaint
        repaint();
    }
    private void checkForFood(){
        for(Food food:foodList){
            Location snakeHeadLocation=snake.getHeadLocation();
            Location foodLocation=food.getLocation();
            if(foodLocation.equals(snakeHeadLocation)){
                foodList.remove(food);
                foodList.add(new Food());
                snake.eatFood();
                GameSettings.getInstance().addScore(food.getPoints());
                System.out.println("Your score is: "+GameSettings.getInstance().getScore());
                break;
            }
        }
    }
}
