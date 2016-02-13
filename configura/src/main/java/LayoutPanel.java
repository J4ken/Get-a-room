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


    public LayoutPanel(){
        ImageHandler.loadImages();
        floor = new ImageIcon(ImageHandler.getFloor());
        setBackground(Color.BLACK);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setPreferredSize(new Dimension(11*52,11*52));
    }

    private void populatePanel(){

    }

    /**
     *  renders the room according to the board
     */
    public void renderRoom(Board board){
        System.out.println("renderRom");
        for(int h = 0; h < board.ROOM_HEIGHT; h++){
            for(int w = 0; w < board.ROOM_WIDTH; w++){
                SquareType s = board.getSquareType(h, w);
                if(s == SquareType.FLOOR){
                    addFloor(floor, h, w);
                }
            }
        }
    }

    public void addFloor(ImageIcon img, int h, int w) {
        JLabel l = new JLabel();
        l.setIcon(img);
        add(l);
    }
}
