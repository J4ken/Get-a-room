package main.java.FurnitureFactory;

import main.java.Direction;

/**
 * Created by lukas on 2016-02-12.
 */
public class Desk implements Furniture {
    private int width = 70;
    private int height = 150;
    private Direction direction = Direction.UNKNOWN;

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
