package logger;

import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger logger;

    private Logger() {
        this.log("Стартуем прогу!");
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        System.out.printf("[%tc %d] %s\n", new Date(), num++, msg);
    }
}
