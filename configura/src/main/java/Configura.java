package main.java;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jacob on 2/12/2016.
 */
public class Configura
{
    public static void main(String[] args){
	System.out.println("hej");
	ReadFile file = new ReadFile("/home/sarsv839/Get-a-room/configura/src/main/resources/test_file.txt");
	try {
	    String[] furniture = file.OpenFile();
	    for(int i=0; i<furniture.length; i++)
	    System.out.println(furniture[i]);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	//Board board = new Board(10, 10);


    }

}
