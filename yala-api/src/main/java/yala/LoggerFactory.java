/**
 * Created Mar 14, 2011
 */
package yala;

import yala.impl.LoggerFactoryBinding;

/**
 * A factory for obtaining {@link Logger}s.
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public class LoggerFactory {

    static class Holder {
        private static final LoggerFactoryBinding BINDING = new LoggerFactoryBinding();
    }

    /**
     * Utility classes should not have a public or default constructor.
     */
    private LoggerFactory() {
        // noop
    }

    /**
     * Obtain a logger implementation by name.
     *
     * @param name
     *        the logger name
     * @return the {@link Logger} implementation
     */
    public static Logger getLogger(final String name) {
        try {
            return Holder.BINDING.getLogger(name);
        } catch (final NoClassDefFoundError e) {
            System.err
                    .println("NoClassDefFoundError attempting to load binding! Make sure that yala-jdk14 is on the classpath!");
        }
        return new NopLogger();
    }

    /**
     * <p>
     * Obtain a logger implementation suitable for the given class. Equivalent to:
     * </p>
     * <code>
     *   LoggerFactory.getLogger(cl.getCanonicalName());
     * </code>
     *
     * @param cl
     *        the class
     * @return the {@link Logger} implementation
     */
    public static Logger getLogger(final Class<?> cl) {
        return getLogger(cl.getCanonicalName());
    }

    /**
     * Does nothing.
     *
     * @author Alistair A. Israel
     */
    private static final class NopLogger implements Logger {
        public void warning(final Throwable thrown, final String message, final Object... args) {
        }

        public void warning(final String message, final Object... args) {
        }

        public void trace(final Throwable thrown, final String message, final Object... args) {
        }

        public void trace(final String message, final Object... args) {
        }

        public boolean isWarningLoggable() {
            return false;
        }

        public boolean isTraceLoggable() {
            return false;
        }

        public boolean isInfoLoggable() {
            return false;
        }

        public boolean isErrorLoggable() {
            return false;
        }

        public boolean isDebugLoggable() {
            return false;
        }

        public void info(final Throwable thrown, final String message, final Object... args) {
        }

        public void info(final String message, final Object... args) {
        }

        public void error(final Throwable thrown, final String message, final Object... args) {
        }

        public void error(final String message, final Object... args) {
        }

        public void debug(final Throwable thrown, final String message, final Object... args) {
        }

        public void debug(final String message, final Object... args) {
        }
    }
}