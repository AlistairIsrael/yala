/**
 * Created Mar 14, 2011
 */
package yala;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Our version of {@link java.util.logging.Formatter}.
 *
 * @author Alistair A. Israel
 */
public class SimpleFormatter extends Formatter {

    /**
     * {@inheritDoc}
     *
     * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
     */
    @Override
    public String format(final LogRecord record) {
        final String msg;
        if (record.getParameters() != null && record.getParameters().length > 0) {
            msg = String.format(record.getMessage(), record.getParameters());
        } else {
            msg = record.getMessage();
        }
        final String line = String.format("%s [%s] %s#%s %s", new Date(record.getMillis()).toString(),
                record.getLevel(), record.getSourceClassName(), record.getSourceMethodName(), msg);
        if (record.getThrown() == null) {
            return line;
        }

        // Need to incorporate the exception stack trace
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream ps = new PrintStream(baos);
        ps.println(line);
        record.getThrown().printStackTrace(ps);
        ps.flush();
        return baos.toString();
    }

}
