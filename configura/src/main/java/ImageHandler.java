package main.java;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by Jacob on 2/12/2016.
 */
public class ImageHandler
{
    private static BufferedImage tmp_img;

    private static ImageIcon img_floor;
    private static ImageIcon img_wall;
    private static ImageIcon img_bed_N, img_bed_E, img_bed_S, img_bed_W;
    private static ImageIcon img_window_N, img_window_E, img_window_S, img_window_W;
    private static ImageIcon img_door_N, img_door_E, img_door_S, img_door_W;
    private static ImageIcon img_couch_N, img_couch_E, img_couch_S, img_couch_W;
    private static ImageIcon img_desk_N, img_desk_E, img_desk_S, img_desk_W;
    private static ImageIcon img_carpet_N, img_carpet_E, img_carpet_S, img_carpet_W;
    private static ImageIcon img_shelf_N, img_shelf_E, img_shelf_S, img_shelf_W;


    public static void loadImages() {

	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Floor\\wooden_floor.png"));
	    img_floor = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Wall\\black_wall.png"));
	    img_wall = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	/**
	 * BED
	 */
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Bed\\bed_N.png"));
	    img_bed_N = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Bed\\bed_E.png"));
	    img_bed_E = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Bed\\bed_S.png"));
	    img_bed_S = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Bed\\bed_W.png"));
	    img_bed_W = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}

	/**
	 * WINDOW
	 */
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Window\\window_N.png"));
	    img_window_N = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Window\\window_E.png"));
	    img_window_E = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Window\\window_S.png"));
	    img_window_S = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Window\\window_W.png"));
	    img_window_W = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	/**
	 * DOOR
	 */
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Door\\door_N.png"));
	    img_door_N = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Door\\door_E.png"));
	    img_door_E = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Door\\door_S.png"));
	    img_door_S = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Door\\door_W.png"));
	    img_door_W = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	/**
	 * SOFA
	 */
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Couch\\couch_N.png"));
	    img_couch_N = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Couch\\couch_E.png"));
	    img_couch_E = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Couch\\couch_S.png"));
	    img_couch_S = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Couch\\couch_W.png"));
	    img_couch_W = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}

	/**
	 * DESK
	 */
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Desk\\desk_N.png"));
	    img_desk_N = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Desk\\desk_E.png"));
	    img_desk_E = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Desk\\desk_S.png"));
	    img_desk_S = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Desk\\desk_W.png"));
	    img_desk_W = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	/**
	 * CARPET
	 */
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Carpet\\desk_N.png"));
	    img_carpet_N = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Carpet\\desk_E.png"));
	    img_carpet_E = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Carpet\\desk_N.png"));
	    img_carpet_S = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Carpet\\desk_E.png"));
	    img_carpet_W = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	/**
	 * BOOKSHELF
	 */
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Shelf\\Shelf_N.png"));
	    img_shelf_N = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Shelf\\Shelf_E.png"));
	    img_shelf_E = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Shelf\\Shelf_N.png"));
	    img_shelf_S = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Shelf\\Shelf_E.png"));
	    img_shelf_W = new ImageIcon(tmp_img);
	} catch (IOException e) {
	    System.out.println(e);
	}
    }







    public static ImageIcon getFloor() {
	return img_floor;
    }

    public static ImageIcon getWall() {
	return img_wall;
    }

    public static ImageIcon getBed(Direction dir) {
	if(dir.equals(Direction.NORTH)){
	    return img_bed_N;
	} else if(dir.equals(Direction.EAST)){
	    return img_bed_E;
	} else if(dir.equals(Direction.SOUTH)){
	    return img_bed_S;
	} else if(dir.equals(Direction.WEST)){
	    return img_bed_W;
	} else {
	    return null;
	}
    }

    public static ImageIcon getWindow(Direction dir) {
	if(dir.equals(Direction.NORTH)){
	    return img_window_N;
	} else if(dir.equals(Direction.EAST)){
	    return img_window_E;
	} else if(dir.equals(Direction.SOUTH)){
	    return img_window_S;
	} else if(dir.equals(Direction.WEST)){
	    return img_window_W;
	} else {
	    System.out.println("Window NULL");
	    return null;
	}
    }

    public static ImageIcon getDoor(Direction dir) {
    	if(dir.equals(Direction.NORTH)){
    	    return img_door_N;
    	} else if(dir.equals(Direction.EAST)){
    	    return img_door_E;
    	} else if(dir.equals(Direction.SOUTH)){
    	    return img_door_S;
    	} else if(dir.equals(Direction.WEST)){
    	    return img_door_W;
    	} else {
	    System.out.println("Door NULL");
    	    return null;
    	}
    }

    public static ImageIcon getCouch(Direction dir) {
	if(dir.equals(Direction.NORTH)){
	    return img_couch_N;
	} else if(dir.equals(Direction.EAST)){
	    return img_couch_E;
	} else if(dir.equals(Direction.SOUTH)){
	    return img_couch_S;
	} else if(dir.equals(Direction.WEST)){
	    return img_couch_W;
	} else {
    	System.out.println("couch NULL");
	    return null;
	}
    }

    public static ImageIcon getDesk(Direction dir) {
	if(dir.equals(Direction.NORTH)){
	    return img_desk_N;
	} else if(dir.equals(Direction.EAST)){
	    return img_desk_E;
	} else if(dir.equals(Direction.SOUTH)){
	    return img_desk_S;
	} else if(dir.equals(Direction.WEST)){
	    return img_desk_W;
	} else {
    	System.out.println("couch NULL");
	    return null;
	}
    }

    public static ImageIcon getCarpet(Direction dir) {
	if(dir.equals(Direction.NORTH)){
	    return img_carpet_N;
	} else if(dir.equals(Direction.EAST)){
	    return img_carpet_E;
	} else if(dir.equals(Direction.SOUTH)){
	    return img_carpet_S;
	} else if(dir.equals(Direction.WEST)){
	    return img_carpet_W;
	} else {
    	System.out.println("capet NULL");
	    return null;
	}
    }

    public static ImageIcon getShelf(Direction dir) {
	if(dir.equals(Direction.NORTH)){
	    return img_shelf_N;
	} else if(dir.equals(Direction.EAST)){
	    return img_shelf_E;
	} else if(dir.equals(Direction.SOUTH)){
	    return img_shelf_S;
	} else if(dir.equals(Direction.WEST)){
	    return img_shelf_W;
	} else {
    	System.out.println("capet NULL");
	    return null;
	}
    }
}

