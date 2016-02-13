package main.java;

import main.java.FurnitureFactory.Furniture;

/**
 * Created by Jacob on 2/12/2016.
 */
public class Board
{

    /**
     * Board width and height constants
     */
    final static int ROOM_HEIGHT = 52;
    final static int ROOM_WIDTH = 52;

    /**
     * Declare the type used to represent the game board.
     */
    private SquareType[][] squares;
    private Furniture[][] furnitures;

    /**
     * Constructor for Board-class.
     * @param height - board-height
     * @param width - board-width
     */
    public Board(int height, int width) {
	    this.squares = new SquareType[height][width];
        this.furnitures = new Furniture[height][width];

        /**
         * Sets the room_squares (52x52) to SquareType.FLOOR
         * and the frame to SquareType.WALL
         */
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(y == 0 || x == 0 || y == height - 1 || x == width - 1) {
                    squares[y][x] = SquareType.WALL;
                    furnitures[y][x] = null;
                } else {
                    squares[y][x] = SquareType.FLOOR;
                    furnitures[y][x] = null;
                }
            }
        }
    }

    public SquareType getSquareType(int h, int w) {
        return squares[h][w];
    }

    public void resetBoard(int height, int width) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || x == 0 || y == height - 1 || x == width - 1) {
                    squares[y][x] = SquareType.WALL;
                    furnitures[y][x] = null;
                } else {
                    squares[y][x] = SquareType.FLOOR;
                    furnitures[y][x] = null;
                }
            }
        }
    }
}
