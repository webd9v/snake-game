package com.snakegame;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Check if snake head is equal to the food object
// IF they are equal then remove the food from the food list
// Add a snake part to the snake
// Increment score
// Create new Food object to the food list

// GAME SETTING
// Add get score function to GameSettings ** THIS SHOULD NOT BE STATIC
// Add a function to increment the score by the food points the snake ate
// Display the score using SOUT every time the snake eats a food object
// add static default max points for the food object
// Every time a new food is created randomize the points based on the max points in the game settings
// ADD DEFAULT FOOD COLOR

// FOOD
// Fix the location
// Update randomizing points instead of passing in points in constructor
// Apply default food color from setting and remove from constructor


public class Main extends JFrame implements KeyListener {
    //JFrame is a UI
    private GamePanel gamePanel;

    public Main(){
        gamePanel=new GamePanel();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//closes when u hit the x icon on the window
        setTitle("Snake Game");
        getContentPane().setLayout(new BorderLayout());
        setPreferredSize(new Dimension(GameSettings.WIDTH,GameSettings.HEIGHT));
        getContentPane().add(gamePanel,BorderLayout.CENTER);

        pack();
    }

    public static void main(String[] args){
        //new Main().start();
        EventQueue.invokeLater(()-> {
            Main main = new Main();
            main.setVisible(true);
            main.start();
        });
    }
    public void start(){
//      Snake snake = new Snake(Color.RED,3,Direction.Right);
        addKeyListener(this);//function on jframe it takes an Object of type
                                //KeyListener and since main implements it now
                                //"this" is an KeyListener
        gamePanel.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_DOWN->{
                gamePanel.setSnakeDirection(Direction.Down);
                break;
            }
            case KeyEvent.VK_LEFT->{
                gamePanel.setSnakeDirection(Direction.Left);
                break;
            }
            case KeyEvent.VK_UP->{
                gamePanel.setSnakeDirection(Direction.Up);
                break;
            }
            case KeyEvent.VK_RIGHT->{
                gamePanel.setSnakeDirection(Direction.Right);
                break;}


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
