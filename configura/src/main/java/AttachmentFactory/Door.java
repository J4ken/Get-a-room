package main.java.AttachmentFactory;

import main.java.Direction;

/**
 * Created by lukas on 2016-02-12.
 */
public class Door implements  Attachment {

    private int width = 90;
    private int height = 10;
    private Direction direction = Direction.UNKNOWN;

    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;

    public Door(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;

        if (xStart == xEnd) {
            if (yStart < yEnd) {
                direction = Direction.WEST;
            } else {
                direction = Direction.EAST;
            }
        } else if (yStart == yEnd) {
            if (xStart < xEnd) {
                direction = Direction.NORTH;
            } else {
                direction = Direction.SOUTH;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getxStart() {
        return xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public int getxEnd() {
        return xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }
}
