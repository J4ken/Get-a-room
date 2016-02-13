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
    private static ImageIcon img_bed;

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
	try {
	    tmp_img = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Bed\\bed.png"));
	    img_bed = new ImageIcon(tmp_img);
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

    public static ImageIcon getBed() {
	return img_bed;
    }
}

//
//
//	Random rnd = new Random();
//
//	switch (rnd.nextInt(1)) {
//	    case (0):
//		try {
//		    floor = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Floor\\dark_wooden_floor.png)"));
//		} catch (IOException e) {
//		    System.out.println(e);
//		}
//		break;
//	    default:
//		try {
//		    floor = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Floor\\dark_wooden_floor.png"));
//		} catch (IOException e) {
//		    System.out.println(e);
//		}
//	}
