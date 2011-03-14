/**
 * Created Mar 14, 2011
 */
package yala.impl;

import yala.Logger;
import yala.jdk14.Jdk14Logger;

/**
 * @author Alistair A. Israel
 * @since 0.1
 */
public class LoggerFactoryBinding {

    /**
     * @param name
     *        the logger name
     * @return the Logger implementation
     */
    public final Logger getLogger(final String name) {
        return Jdk14Logger.forName(name);
    }
}
