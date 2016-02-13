package main.java;


import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jacob on 2/12/2016.
 */
public class Configura
{
    public static void main(String[] args){
	System.out.println("wabadabadubdub");
	MainFrame frame = new MainFrame();
	frame.setUpFrame();
	frame.pack();
	frame.setVisible(true);

	System.out.println("hej");
	ReadFile file = new ReadFile("configura\\src\\main\\resources\\test_file.txt");
	try {
	    String[] furniture = file.getReadFurniture();
	    for(int i=0; i<furniture.length; i++)
	    System.out.println(furniture[i]);
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (NotInBoardBoundsException e) {
		e.printStackTrace();
	}
		//Board board = new Board(10, 10);


    }
}
