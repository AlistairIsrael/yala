/**
 * Created Mar 14, 2011
 */
package yala;

/**
 * A simple logger abstraction.
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public interface Logger {

    /**
     * @return {@code true} if an error (or SEVERE) message would be logged by the underlying logging implementation
     */
    boolean isErrorLoggable();

    /**
     * Log an error (or SEVERE) message.
     *
     * @param message
     *        the error message
     * @param args
     *        the message parameters
     */
    void error(final String message, final Object... args);

    /**
     * Log an error (or SEVERE) message with an associated {@link Throwable} .
     *
     * @param thrown
     *        the associated {@link Throwable}
     * @param message
     *        the error message
     * @param args
     *        the message parameters
     */
    void error(final Throwable thrown, final String message, final Object... args);

    /**
     * @return {@code true} if a warning message would be logged by the underlying logging implementation
     */
    boolean isWarningLoggable();

    /**
     * Log a warning message.
     *
     * @param message
     *        the warning message
     * @param args
     *        the message parameters
     */
    void warning(final String message, final Object... args);

    /**
     * Log a warning message with an associated {@link Throwable}.
     *
     * @param thrown
     *        the associated {@link Throwable}
     * @param message
     *        the warning message
     * @param args
     *        the message parameters
     */
    void warning(final Throwable thrown, final String message, final Object... args);

    /**
     * @return {@code true} if an info message would be logged by the underlying logging implementation
     */
    boolean isInfoLoggable();

    /**
     * Log an info message.
     *
     * @param message
     *        the info message
     * @param args
     *        the message parameters
     */
    void info(final String message, final Object... args);

    /**
     * Log an info message with an associated {@link Throwable}.
     *
     * @param thrown
     *        the associated {@link Throwable}
     * @param message
     *        the info message
     * @param args
     *        the message parameters
     */
    void info(final Throwable thrown, final String message, final Object... args);

    /**
     * @return {@code true} if a debug message would be logged by the underlying logging implementation
     */
    boolean isDebugLoggable();

    /**
     * Log a debug message.
     *
     * @param message
     *        the debug message
     * @param args
     *        the message parameters
     */
    void debug(final String message, final Object... args);

    /**
     * Log a debug level message with an associated {@link Throwable}.
     *
     * @param thrown
     *        the associated {@link Throwable}
     * @param message
     *        the debug message
     * @param args
     *        the message parameters
     */
    void debug(final Throwable thrown, final String message, final Object... args);

    /**
     * @return {@code true} if a trace message would be logged by the underlying logging implementation
     */
    boolean isTraceLoggable();

    /**
     * Log a trace message.
     *
     * @param message
     *        the trace message
     * @param args
     *        the message parameters
     */
    void trace(final String message, final Object... args);

    /**
     * Log a trace level message with an associated {@link Throwable}.
     *
     * @param thrown
     *        the associated {@link Throwable}
     * @param message
     *        the trace message
     * @param args
     *        the message parameters
     */
    void trace(final Throwable thrown, final String message, final Object... args);
}
