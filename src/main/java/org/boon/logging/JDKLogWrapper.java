package org.boon.logging;

import java.util.logging.Level;

import static org.boon.Boon.sputs;

public class JDKLogWrapper implements Logger {
    private final java.util.logging.Logger logger;

    JDKLogWrapper(final String name) {
        logger = java.util.logging.Logger.getLogger(name);
    }

    @Override
    public boolean infoOn() {
        return logger.isLoggable(Level.INFO);
    }

    @Override
    public boolean debugOn() {
        return logger.isLoggable(Level.FINE);
    }

    @Override
    public boolean traceOn() {
        return logger.isLoggable(Level.FINEST);
    }


    @Override
    public void fatal(Object... messages) {
        logger.log(Level.SEVERE, sputs(messages));
    }

    @Override
    public void fatal(Throwable t, Object... messages) {

        logger.log(Level.SEVERE, sputs(messages), t);
    }

    @Override
    public void error(Object... messages) {

        logger.log(Level.SEVERE, sputs(messages));

    }

    @Override
    public void error(Throwable t, Object... messages) {

        logger.log(Level.SEVERE, sputs(messages), t);
    }

    @Override
    public void warn(Object... messages) {


        logger.log(Level.WARNING, sputs(messages));

    }

    @Override
    public void warn(Throwable t, Object... messages) {

        logger.log(Level.WARNING, sputs(messages), t);

    }

    @Override
    public void info(Object... messages) {


        logger.log(Level.INFO, sputs(messages));
    }

    @Override
    public void info(Throwable t, Object... messages) {

        logger.log(Level.INFO, sputs(messages), t);

    }


    @Override
    public void config(Object... messages) {


        logger.log(Level.CONFIG, sputs(messages));
    }

    @Override
    public void config(Throwable t, Object... messages) {

        logger.log(Level.CONFIG, sputs(messages), t);

    }

    @Override
    public void debug(Object... messages) {

        logger.log(Level.FINE, sputs(messages));

    }

    @Override
    public void debug(Throwable t, Object... messages) {

        logger.log(Level.FINE, sputs(messages), t);

    }

    @Override
    public void trace(Object... messages) {

        logger.log(Level.FINEST, sputs(messages));

    }

    @Override
    public void trace(Throwable t, Object... messages) {

        logger.log(Level.FINEST, sputs(messages), t);

    }


    public LogLevel level() {
        Level level = logger.getLevel();
        if (level == Level.FINE) {
            return LogLevel.DEBUG;
        } else if (level == Level.FINEST) {
            return LogLevel.TRACE;
        } else if (level == Level.CONFIG) {
            return LogLevel.CONFIG;
        }  else if (level == Level.INFO) {
            return LogLevel.INFO;
        } else if (level == Level.WARNING) {
            return LogLevel.WARN;
        } else if (level == Level.SEVERE) {
            return LogLevel.FATAL;
        }
        return LogLevel.ERROR;
    }

    public void level(LogLevel level) {
        switch (level) {
            case DEBUG:
                logger.setLevel( Level.FINE );
                break;

            case TRACE:
                logger.setLevel( Level.FINEST );
                break;

            case CONFIG:
                logger.setLevel( Level.CONFIG );
                break;

            case INFO:
                logger.setLevel( Level.INFO );
                break;

            case WARN:
                logger.setLevel( Level.WARNING );
                break;


            case ERROR:
                logger.setLevel( Level.SEVERE );
                break;

            case FATAL:
                logger.setLevel( Level.SEVERE );
                break;

        }
    }


    public void turnOff() {
        logger.setLevel(Level.OFF);
    }
}
