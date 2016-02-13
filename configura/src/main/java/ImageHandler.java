package main.java;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.Random;
/**
 * Created by Jacob on 2/12/2016.
 */
public class ImageHandler
{
    private static BufferedImage floor;

    public static void loadImages() {
	Random rnd = new Random();

	switch (rnd.nextInt(1)) {
	    case (0):
		try {
		    floor = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Floor\\dark_wooden_floor.png"));
		} catch (IOException e) {
		    System.out.println(e);
		}
		break;
	    default:
		try {
		    floor = ImageIO.read(new File("configura\\src\\main\\resources\\Pictures\\Floor\\red_wooden_floor.png"));
		} catch (IOException e) {
		    System.out.println(e);
		}
	}

    }

    public static BufferedImage getFloor() {
	return floor;
    }
}
