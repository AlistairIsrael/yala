/**
 *
 */
package yala.log4j;

import yala.Logger;

/**
 * @author Alistair A. Israel
 */
public class Log4jLogger implements Logger {

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isErrorLoggable()
     */
    public boolean isErrorLoggable() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#error(java.lang.String, java.lang.Object[])
     */
    public void error(final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#error(java.lang.Throwable, java.lang.String, java.lang.Object[])
     */
    public void error(final Throwable thrown, final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isWarningLoggable()
     */
    public boolean isWarningLoggable() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#warning(java.lang.String, java.lang.Object[])
     */
    public void warning(final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#warning(java.lang.Throwable, java.lang.String, java.lang.Object[])
     */
    public void warning(final Throwable thrown, final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isInfoLoggable()
     */
    public boolean isInfoLoggable() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#info(java.lang.String, java.lang.Object[])
     */
    public void info(final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#info(java.lang.Throwable, java.lang.String, java.lang.Object[])
     */
    public void info(final Throwable thrown, final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isDebugLoggable()
     */
    public boolean isDebugLoggable() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#debug(java.lang.String, java.lang.Object[])
     */
    public void debug(final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#debug(java.lang.Throwable, java.lang.String, java.lang.Object[])
     */
    public void debug(final Throwable thrown, final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#isTraceLoggable()
     */
    public boolean isTraceLoggable() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#trace(java.lang.String, java.lang.Object[])
     */
    public void trace(final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see yala.Logger#trace(java.lang.Throwable, java.lang.String, java.lang.Object[])
     */
    public void trace(final Throwable thrown, final String message, final Object... args) {
        // TODO Auto-generated method stub

    }

    /**
     * @param name
     *        the Logger name
     * @return Log4jLogger
     */
    public static Log4jLogger forName(final String name) {
        // TODO Auto-generated method stub
        return null;
    }

}
