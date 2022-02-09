package com.snakegame;

public enum Direction {
    Up,Down,Left,Right;
    public Boolean isOppositeDirection(Direction direction){
        return this==getOppositeDirection(direction);
    }
    public static Direction getOppositeDirection(Direction direction){
        Direction oppositeDirection;
        switch (direction){
            case Up -> {
                oppositeDirection=Direction.Down;
                break;
            }
            case Down -> {
                oppositeDirection=Direction.Up;

                break;
            }
            case Left -> {
                oppositeDirection=Direction.Right;

                break;
            }
            case Right -> {
                oppositeDirection=Direction.Left;

                break;
            }
            default -> {
                oppositeDirection=direction.Right;
            }
        }
        return oppositeDirection;

    }
}
