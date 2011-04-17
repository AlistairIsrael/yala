/**
 * Created Mar 14, 2011
 */
package yala;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.junit.Test;

/**
 * JUnit test for {@link SimpleFormatter}.
 *
 * @author Alistair A. Israel
 */
public final class SimpleFormatterTest {

    private final Date now = new Date();

    /**
     *
     */
    @Test
    public void testFormatSingleLine() {
        final LogRecord record = new LogRecord(Level.FINE, "Message with parameter: %04d");
        record.setMillis(now.getTime());
        record.setParameters(new Object[] { Integer.valueOf(2012) });
        record.setSourceClassName(SimpleFormatterTest.class.getName());
        record.setSourceMethodName("testFormatSingleLine");

        final String formatted = new SimpleFormatter().format(record);

        final String timestamp = new SimpleDateFormat(SimpleFormatter.DATE_PATTERN).format(now);
        final String expected = timestamp
                + " [FINE] yala.SimpleFormatterTest#testFormatSingleLine Message with parameter: 2012\n";
        assertEquals(expected, formatted);
    }

    @Test
    public void testFormatWithException() {
        final NullPointerException npe = new NullPointerException("NPE");

        final LogRecord record = new LogRecord(Level.FINE, "Message with parameter: %04d");
        record.setMillis(now.getTime());
        record.setParameters(new Object[] { Integer.valueOf(2012) });
        record.setSourceClassName(SimpleFormatterTest.class.getName());
        record.setSourceMethodName("testFormatSingleLine");
        record.setThrown(npe);

        final String formatted = new SimpleFormatter().format(record);

        final StringWriter sw = new StringWriter();
        final PrintWriter out = new PrintWriter(sw);

        final String timestamp = new SimpleDateFormat(SimpleFormatter.DATE_PATTERN).format(now);
        out.print(timestamp + " [FINE] yala.SimpleFormatterTest#testFormatSingleLine Message with parameter: 2012\n");
        npe.printStackTrace(out);

        assertEquals(sw.toString(), formatted);
    }
}
