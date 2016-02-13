package main.java;

/**
 * Created by Jacob on 2/12/2016.
 */

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.awt.image.BufferedImage;
import java.util.List;


/**
 * populate with JLabels
 */
public class LayoutPanel extends JPanel
{
    private ImageIcon img;
    private ImageIcon ii;

    public LayoutPanel(){
        ImageHandler.loadImages();
        setBackground(Color.YELLOW);
        setLayout(null);
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
                    img = ImageHandler.getWindow(dir);
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.DOORMAIN)){
                    Direction dir = board.getAttachments(h, w).getDirection();
                    img = ImageHandler.getDoor(dir);
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.BEDMAIN)){
                    Direction dir = board.getFurniture(h, w).getDirection();
                    printDir(dir);
                    img = ImageHandler.getBed(dir);
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.SOFAMAIN)){
                    Direction dir = board.getFurniture(h, w).getDirection();
                    img = ImageHandler.getCouch(dir);
                    addLabel(img, h, w);
                } else if(board.getSquareType(h, w).equals(SquareType.DESKMAIN)){
                    Direction dir = board.getFurniture(h, w).getDirection();
                    img = ImageHandler.getDesk(dir);
                    addLabel(img, h, w);
                }else if(board.getSquareType(h, w).equals(SquareType.MATMAIN)){
                    Direction dir = board.getFurniture(h, w).getDirection();
                    img = ImageHandler.getCarpet(dir);
                    addLabel(img, h, w);
                }else if(board.getSquareType(h, w).equals(SquareType.BOOKSHELF)){
                    Direction dir = board.getFurniture(h, w).getDirection();
                    img = ImageHandler.getShelf(dir);
                    addLabel(img, h, w);
                } else if (board.getSquareType(h, w).equals(SquareType.WALLTVMAIN)) {
                    Direction dir = board.getFurniture(h, w).getDirection();
                    img = ImageHandler.getTV(dir);
                    addLabel(img, h, w);
                } else {
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
    public void renderRoom(Board board) throws IOException, NotInBoardBoundsException {
        System.out.println("render room");
        FurnitureAI ai = new FurnitureAI();
        board = ai.decorateRoom(board);
        populateRoom(board);
        System.out.println("rendered");
    }

    public List<String> generateOutput(Board board) throws IOException {
        WriteFile write = new WriteFile("/home/sarsv839/Get-a-room/configura/src/main/resources/test_file_output.txt", true);
        List<String> output = new ArrayList<>();
        StringBuilder furnitureSpot = new StringBuilder();
        for(int h = 0; h < board.ROOM_HEIGHT; h++){
            for(int w = 0; w < board.ROOM_WIDTH; w++) {

                if (board.getSquareType(h, w).equals(SquareType.WINDOWMAIN)) {
                    Direction dir = board.getAttachments(h, w).getDirection();
                    furnitureSpot.append("Fönster\t" + h + w);

                } else if (board.getSquareType(h, w).equals(SquareType.DOORMAIN)) {
                    Direction dir = board.getAttachments(h, w).getDirection();
                    furnitureSpot.append("Dörr\t" + h +"," + w+",");
                } else if (board.getSquareType(h, w).equals(SquareType.BEDMAIN)) {
                    Direction dir = board.getFurniture(h, w).getDirection();
                    furnitureSpot.append("Säng\t" + h +"," + w+",");
                } else if (board.getSquareType(h, w).equals(SquareType.SOFAMAIN)) {
                    Direction dir = board.getFurniture(h, w).getDirection();
                    furnitureSpot.append("Soffa\t" +  h +"," + w+",");
                } else if (board.getSquareType(h, w).equals(SquareType.DESKMAIN)) {
                    Direction dir = board.getFurniture(h, w).getDirection();
                    furnitureSpot.append("Skrivbord\t" + h +"," + w+",");
                } else if (board.getSquareType(h, w).equals(SquareType.WALLTVMAIN)) {
                    Direction dir = board.getFurniture(h, w).getDirection();
                    furnitureSpot.append("Skrivbord\t" + h +"," + w+",");
                } else {
                }
                output.add(furnitureSpot.toString());
            }
        }
        for(String c: output) {
            write.writeToFile(c);
        }
        return output;
    }

    private void addLabel(ImageIcon ii, int h, int w) {
//        this.ii = ii;
        JLabel l = new JLabel();
        l.setIcon(ii);
        l.setLocation(w*10,h*10);
        l.setSize(ii.getIconWidth(),ii.getIconHeight());
        add(l);
    }
}
