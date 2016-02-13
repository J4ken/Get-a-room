package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile
{
    private String[] readFurniture;
    private String path;
    private final int DOORWINDOWS=3;

    public ReadFile(String filePath) {
	path = filePath;
    }

    public String[] getReadFurniture() throws IOException, NotInBoardBoundsException {
		return OpenFile();
    }

    private String[] OpenFile() throws IOException, NotInBoardBoundsException {
	String furniture;
	readFurniture = new String[readLines()];
	FileReader fileChar = new FileReader(path);
	BufferedReader fileLine = new BufferedReader(fileChar);

	for (int i=0; i<readFurniture.length; i++) {
	    if(i<DOORWINDOWS) {
		readFurniture[i] = fileLine.readLine();
		String[] current = readFurniture[i].split("	");

		if(current.length > 1 ) {
		    String[] furniturePlace = current[1].split(",");
		    checkInput(furniturePlace);
		}


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
	file.close();
	return numberOfLines;
    }



private void checkInput(String[] furniturePlace) throws NotInBoardBoundsException {
    for ( String c: furniturePlace) {
	if(Integer.parseInt(c) < 0 || Integer.parseInt(c) > 500) {
	    throw new NotInBoardBoundsException("Furniture can't be placed outside 0 to 500");
	}
    }
}

}