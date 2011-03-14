/**
 * Created Mar 14, 2011
 */
package yala.impl;

import java.util.concurrent.ConcurrentHashMap;

import yala.Logger;

/**
 * A SimpleLogger merely outputs all log messages to the console. It uses
 * {@link System#err} for warning and error level messages, and
 * {@link System#out} for everything else.
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public final class SimpleLogger implements Logger {

    private static final ConcurrentHashMap<String, SimpleLogger> CACHE =
            new ConcurrentHashMap<String, SimpleLogger>();

    private final String name;

    /**
     * @param name
     *        the logger name
     * @return the SimpleLogger
     */
    public static SimpleLogger forName(final String name) {
        if (CACHE.containsKey(name)) {
            return CACHE.get(name);
        }
        final SimpleLogger newLogger = new SimpleLogger(name);
        final SimpleLogger existing = CACHE.putIfAbsent(name, newLogger);
        if (existing != null) {
            return existing;
        }
        return newLogger;
    }

    /**
     * @param name
     *        the logger name
     */
    private SimpleLogger(final String name) {
        this.name = name;
    }

    /**
     * @param level
     *        the string 'level'
     * @param message
     *        the log message
     * @param args
     *        the log message parameters
     */
    private void err(final String level, final String message, final Object... args) {
        System.err.println(System.currentTimeMillis() + " [" + level + "] " + name + " "
                + String.format(message, args));
    }

    /**
     * @param level
     *        the string 'level'
     * @param message
     *        the log message
     * @param args
     *        the log message parameters
     */
    private void out(final String level, final String message, final Object... args) {
        System.out.println(System.currentTimeMillis() + " [" + level + "] " + name + " "
                + String.format(message, args));
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isErrorLoggable()
     */
    public boolean isErrorLoggable() {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#error(java.lang.String, java.lang.Object[])
     */
    public void error(final String message, final Object... args) {
        err("ERROR", message, args);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#error(java.lang.Throwable, java.lang.String,
     *      java.lang.Object[])
     */
    public void error(final Throwable thrown, final String message, final Object... args) {
        err("ERROR", message, args);
        thrown.printStackTrace(System.err);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isWarningLoggable()
     */
    public boolean isWarningLoggable() {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#warning(java.lang.String, java.lang.Object[])
     */
    public void warning(final String message, final Object... args) {
        err("WARNING", message, args);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#warning(java.lang.Throwable, java.lang.String,
     *      java.lang.Object[])
     */
    public void warning(final Throwable thrown, final String message, final Object... args) {
        err("WARNING", message, args);
        thrown.printStackTrace(System.err);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isInfoLoggable()
     */
    public boolean isInfoLoggable() {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#info(java.lang.String, java.lang.Object[])
     */
    public void info(final String message, final Object... args) {
        out("INFO", message, args);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#info(java.lang.Throwable, java.lang.String,
     *      java.lang.Object[])
     */
    public void info(final Throwable thrown, final String message, final Object... args) {
        out("INFO", message, args);
        thrown.printStackTrace(System.out);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isDebugLoggable()
     */
    public boolean isDebugLoggable() {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#debug(java.lang.String, java.lang.Object[])
     */
    public void debug(final String message, final Object... args) {
        out("DEBUG", message, args);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#debug(java.lang.Throwable, java.lang.String,
     *      java.lang.Object[])
     */
    public void debug(final Throwable thrown, final String message, final Object... args) {
        out("DEBUG", message, args);
        thrown.printStackTrace(System.out);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isTraceLoggable()
     */
    public boolean isTraceLoggable() {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#trace(java.lang.String, java.lang.Object[])
     */
    public void trace(final String message, final Object... args) {
        out("TRACE", message, args);
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#trace(java.lang.Throwable, java.lang.String,
     *      java.lang.Object[])
     */
    public void trace(final Throwable thrown, final String message, final Object... args) {
        out("TRAC", message, args);
        thrown.printStackTrace(System.out);
    }

}
