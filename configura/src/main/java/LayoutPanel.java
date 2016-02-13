package main.java;

/**
 * Created by Jacob on 2/12/2016.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;


/**
 * populate with JLabels
 */
public class LayoutPanel extends JPanel
{
    private ImageIcon img;

    public LayoutPanel(){
        ImageHandler.loadImages();
        setBackground(Color.YELLOW);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setPreferredSize(new Dimension(10*52,10*52));
    }

    private void populateRoom(Board board){
        for(int h = 0; h < board.ROOM_HEIGHT; h++){
            for(int w = 0; w < board.ROOM_WIDTH; w++){
                SquareType s = board.getSquareType(h, w);
                if(s == SquareType.FLOOR){
                    img = ImageHandler.getFloor();
                    addLabel(img, h, w);
                } else if(s == SquareType.WALL){
                    img = ImageHandler.getWall();
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.WINDOWMAIN)){
                    Direction dir = board.getAttachments(h, w).getDirection();
                    printDir(dir);
                    img = ImageHandler.getWindow(dir);
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.DOORMAIN)){
                    Direction dir = board.getAttachments(h, w).getDirection();
                    img = ImageHandler.getDoor(dir);
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.BEDMAIN)){
                    Direction dir = board.getAttachments(h, w).getDirection();
                    img = ImageHandler.getBed(dir);
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.SOFAMAIN)){
                    Direction dir = board.getAttachments(h, w).getDirection();
                    img = ImageHandler.getCouch(dir);
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.DESKMAIN)){
                    Direction dir = board.getAttachments(h, w).getDirection();
                    img = ImageHandler.getDesk(dir);
                    addLabel(img, h, w);
                }
            }
        }
    }


    private void printDir(Direction dir){
        if(dir.equals(Direction.NORTH)){
            System.out.println("north");
        } else if(dir.equals(Direction.EAST)) {
            System.out.println("east");
        } else if(dir.equals(Direction.SOUTH)){
            System.out.println("south");
        } else if(dir.equals(Direction.WEST)) {
            System.out.println("west");
        }
    }

    /**
     *  renders the room according to the board
     */
    public void renderRoom(Board board){
        System.out.println("render room");
        FurnitureAI ai = new FurnitureAI();
        board = ai.decorateRoom(board);
        populateRoom(board);
        System.out.println("rendered");
    }


    private void addLabel(ImageIcon ii, int h, int w) {
        JLabel l = new JLabel();
        l.setIcon(ii);
        add(l);
    }
}
