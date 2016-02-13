package main.java.FurnitureFactory;

import main.java.Direction;

/**
 * Created by lukas on 2016-02-12.
 */
public interface Furniture {
    void setDirection(Direction direction);
    Direction getDirection();

    int getWidth();
    int getHeight();


}
