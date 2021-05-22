package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ColorPrinter {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

    private final static String ESC = "\u001b[";
    private final static String RESET = "\u001B[0m";

    private String color;
    private int height;
    private int width;
    private int start;

    public ColorPrinter(String color, int height, int width, int start) {
        this.color = color;
        this.height = height;
        this.width = width;
        this.start = start;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }

    public void setCursorPosition(int y, int x) throws IOException {
        synchronized(bw) {
            bw.write(ESC + y + ";" + x + "f");
            bw.flush();
        }
    }

    public void printColor(long sleepTime) throws IOException, InterruptedException {
        int printedHeight = 0;
        int printedWidth = 0;
        setCursorPosition(start, 0);
        while(width > 0) {
            if(printedHeight < height) {
                setCursorPosition(start + printedHeight, printedWidth);
                printColor();
                ++ printedHeight;
                Thread.sleep(sleepTime);
            } else {
                setCursorPosition(start, ++ printedWidth);
                printedHeight = 0;
                -- this.width;
            }
        }
    }

    public void printColor() throws IOException {
        synchronized(bw) {
            bw.write(color + " " + RESET);
            bw.flush();
        }
    }
    
}
