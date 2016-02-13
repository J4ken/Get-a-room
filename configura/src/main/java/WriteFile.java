package main.java;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile
{
    private String path;
    private boolean appendToFile = false;

    public WriteFile(String path) {
	this.path = path;
    }
    public WriteFile( String path , boolean appendValue ) {

    this.path = path;
    appendToFile = appendValue;

    }

    public void writeToFile(String textLine) throws IOException {
	FileWriter write = new FileWriter(path , appendToFile);
	PrintWriter printLine = new PrintWriter(write);

	printLine.printf("%s" + "%n" , textLine);
	printLine.close();
    }
}
