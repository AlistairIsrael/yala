/**
 * Created Mar 14, 2011
 */
package yala;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        assertEquals(now.toString()
                + " [FINE] yala.SimpleFormatterTest#testFormatSingleLine Message with parameter: 2012", formatted);
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

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream ps = new PrintStream(baos);

        ps.println(now.toString()
                + " [FINE] yala.SimpleFormatterTest#testFormatSingleLine Message with parameter: 2012");
        npe.printStackTrace(ps);
        ps.flush();
        ps.close();

        assertEquals(baos.toString(), formatted);
    }
}
