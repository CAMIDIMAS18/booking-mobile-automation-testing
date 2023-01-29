package co.com.booking.interactions;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Pause {

    private Pause() {
    }

    public static void waitForSeconds(int seconds) {

        Logger logger = Logger.getLogger(Pause.class.getName());

        try {
            Thread.sleep(seconds * 1_000L);

        } catch (InterruptedException e) {
            e.printStackTrace();
            LogRecord logRecord = new LogRecord(Level.INFO, "Interrupted!" + e.getMessage());
            logger.log(logRecord);
            Thread.currentThread().interrupt();
        }
    }
}
