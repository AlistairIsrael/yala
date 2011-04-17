/**
 * Created Mar 14, 2011
 */
package yala.impl;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;

import yala.Logger;
import yala.SimpleFormatter;
import yala.jdk14.Jdk14Logger;

/**
 * @author Alistair A. Israel
 * @since 0.1
 */
public class LoggerFactoryBinding {

    static {
        final ConsoleHandler consoleHandler = getConsoleHandler();
        if (consoleHandler != null) {
            final Formatter formatter = consoleHandler.getFormatter();
            if (formatter instanceof java.util.logging.SimpleFormatter) {
                consoleHandler.setFormatter(new SimpleFormatter());
            }
        }
    }

    private static ConsoleHandler getConsoleHandler() {
        java.util.logging.Logger jul = java.util.logging.Logger
                .getLogger(LoggerFactoryBinding.class.getCanonicalName());
        while (jul != null) {
            for (final Handler handler : jul.getHandlers()) {
                if (handler instanceof ConsoleHandler) {
                    return (ConsoleHandler) handler;
                }
            }
            jul = jul.getParent();
        }
        return null;
    }

    /**
     * @param name
     *        the logger name
     * @return the Logger implementation
     */
    public final Logger getLogger(final String name) {
        return Jdk14Logger.forName(name);
    }
}
