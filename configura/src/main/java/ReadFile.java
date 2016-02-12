package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadFile
{
    private String[] readFurniture;
    private String path;
    private final int DOORWINDOWS=3;

    public ReadFile(String filePath) {
	path = filePath;
    }

    public String[] OpenFile() throws IOException {
	String furniture;
	readFurniture = new String[readLines()];
	FileReader fileChar = new FileReader(path);
	BufferedReader fileLine = new BufferedReader(fileChar);

	for (int i=0; i<readFurniture.length; i++) {
	    if(i<DOORWINDOWS) {
		readFurniture[i] = fileLine.readLine();
	    }
	    else {
		furniture = fileLine.readLine();
		String[] current = furniture.split("	");
		readFurniture[i] = current[0];
	    }
	}
	fileLine.close();
	fileChar.close();
	return readFurniture;
    }

    private int readLines() throws IOException {
	FileReader file = new FileReader(path);
	BufferedReader fileLine = new BufferedReader(file);

	String line;
	int numberOfLines = 0;

	while ((line = fileLine.readLine()) != null) {
	    numberOfLines++;
	}
	fileLine.close();
	fileChar.close();
	return numberOfLines;
    }

}
