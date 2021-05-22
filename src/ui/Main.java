package ui;

import model.ColorPrinter;
import thread.ColorPrinterThread;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private final static String ESC = "\u001b[";

    private static final String YELLOW = "\u001B[43m";
    private static final String BLUE = "\u001B[44m";
    private static final String RED = "\u001B[41m";

    public static void main(String[] args) throws IOException, InterruptedException {

        ColorPrinterThread yellowThread = new ColorPrinterThread(new ColorPrinter(YELLOW, 7, 45, 1), 15);
        ColorPrinterThread blueThread = new ColorPrinterThread(new ColorPrinter(BLUE, 4, 45, 8), 35);
        ColorPrinterThread redThread = new ColorPrinterThread(new ColorPrinter(RED, 3, 45, 12), 55);

        yellowThread.start();
        blueThread.start();
        redThread.start();

        yellowThread.join();
        blueThread.join();
        redThread.join();
        
        bw.write(ESC + 16 + ";" + 0 + "f");
        bw.flush();
        bw.close();
        
    }
    
}
