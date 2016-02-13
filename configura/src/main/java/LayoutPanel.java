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
    private ImageIcon floor;
    private ImageIcon wall;
    private ImageIcon bed;

    public LayoutPanel(){
        ImageHandler.loadImages();
        getImages();
        setBackground(Color.BLACK);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setPreferredSize(new Dimension(10*52,10*52));
    }

    private void renderFloor(Board board){
        board.resetBoard(board.ROOM_HEIGHT, board.ROOM_WIDTH);
        for(int h = 0; h < board.ROOM_HEIGHT; h++){
            for(int w = 0; w < board.ROOM_WIDTH; w++){
                SquareType s = board.getSquareType(h, w);
                if(s == SquareType.FLOOR){
                    addLabel(floor, h, w);
                } else if(s == SquareType.WALL){
                    addLabel(wall, h, w);
                }
            }
        }
    }

    private void renderAttachments(Board board){
        for(int h = 0; h < board.ROOM_HEIGHT; h++){
            for(int w = 0; w < board.ROOM_WIDTH; w++){
                SquareType s = board.getSquareType(h, w);
                if(s == SquareType.WINDOWMAIN){
                    Direction dir = board.getAttachments(w, h).getDirection();
                    
                }



            }
        }
    }

    /**
     *  renders the room according to the board
     */
    public void renderRoom(Board board){
        System.out.println("renderRom");
        renderFloor(board);
        renderAttachments(board);
    }

    private void getImages(){
        floor = ImageHandler.getFloor();
        wall = ImageHandler.getWall();
        bed = ImageHandler.getBed();
    }

    private void addAttachLabel(ImageIcon ii, int h, int w){
    }

    private void addLabel(ImageIcon ii, int h, int w) {
        JLabel l = new JLabel();
        l.setIcon(ii);
        add(l);
    }
}
