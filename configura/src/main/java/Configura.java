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
    public static void main(String[] args) throws IOException, NotInBoardBoundsException {
	System.out.println("wabadabadubdub");

	MainFrame frame = new MainFrame();
	frame.setUpFrame();
	frame.pack();
	frame.setVisible(true);

	System.out.println("hej");

		//Board board = new Board(10, 10);
/*

	ReadFile buildFurniture = new ReadFile("/home/sarsv839/Get-a-room/configura/src/main/resources/test_file.txt");
	FurnitureInventory furniture = new FurnitureInventory();
	furniture.CreateFurniture(buildFurniture.getReadFurniture());
	furniture.getFurnitureList();
	*/
		/*
	ReadFile read = new ReadFile("/home/sarsv839/Get-a-room/configura/src/main/resources/test_file.txt");
	read.getReadFurniture();
	Board board = new Board(500,500);
	LayoutPanel ngt = new LayoutPanel();
	ngt.generateOutput(board);
	*/
    }
}
