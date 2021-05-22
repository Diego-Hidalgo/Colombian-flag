package thread;

import java.io.IOException;
import model.ColorPrinter;

public class ColorPrinterThread extends Thread {

    private ColorPrinter colorPrinter;
    private long sleepTime;

    public ColorPrinterThread(ColorPrinter colorPrinter, long sleepTime) {
        this.colorPrinter = colorPrinter;
        this.sleepTime = sleepTime;
    }

    public void setColorPrinter(ColorPrinter colorPrinter) {
        this.colorPrinter = colorPrinter;
    }

    public ColorPrinter getColorPrinter() {
        return colorPrinter;
    }

    public void setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public long getSleepTime() {
        return sleepTime;
    }

    @Override
    public void run() {
        try {
            colorPrinter.printColor(sleepTime);
        } catch (IOException | InterruptedException ignored) {}
    }

}
