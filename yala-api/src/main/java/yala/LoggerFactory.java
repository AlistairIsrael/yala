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
        return Holder.BINDING.getLogger(name);
    }
}
