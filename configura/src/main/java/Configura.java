package main.java;


import javax.swing.*;
import java.io.IOException;

/**
 * Created by Jacob on 2/12/2016.
 */
public class Configura
{
    public static void main(String[] args) throws IOException, NotInBoardBoundsException {
	System.out.println("wabadabadubdub");

	MainFrame frame = new MainFrame();
	frame.setUpFrame();
	frame.pack();
	frame.setVisible(true);
	ReadFile buildFurniture = new ReadFile("/home/sarsv839/Get-a-room/configura/src/main/resources/test_file.txt");

	/*for(String c : buildFurniture.getReadFurniture()){
	    System.out.println(c);
	}*/
	FurnitureInventory furniture = new FurnitureInventory();
	furniture.CreateFurniture(buildFurniture.getReadFurniture());
	furniture.getFurnitureList();
    }
}
