package main.java;


import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Created by Jacob on 2/12/2016.
 */
public class ImageHandler
{
    private static BufferedImage floor;

    public static void loadImages(){
	try {
	    floor =  ImageIO.read(new File("main/rescources/Pictures/Floor/dark_wooden_floor.png"));
	} catch (IOException e) {
	    System.out.println("dark_wooden_floor.png did not load");
	}
    }

    public static BufferedImage getFloor() {
	return floor;
    }
}
