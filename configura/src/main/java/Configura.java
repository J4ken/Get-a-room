package main.java;


import javax.swing.*;

/**
 * Created by Jacob on 2/12/2016.
 */
public class Configura
{
    public static void main(String[] args){
	System.out.println("wabadabadubdub");
	ImageHandler.loadImages();
	MainFrame frame = new MainFrame();
	frame.setUpFrame();
  	frame.createMenuBar();
	frame.pack();
	frame.setVisible(true);
    }
}
