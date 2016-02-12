package main.java;

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

    public Board(int height, int width) {
	    this.squares = new SquareType[height][width];

        /**
         * Sets the room_squares (52x52) to SquareType.EMPTY
         * and the frame to SquareType.WALL
         */
    }
}
