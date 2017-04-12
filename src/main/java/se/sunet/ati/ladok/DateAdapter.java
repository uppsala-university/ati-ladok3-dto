package se.sunet.ati.ladok;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.DatatypeConverter;

/**
 * A class that is used by JAXB when it converts an XML date into a Java type.
 * This implementation converts to a <code>java.util.Date</code>.
 * <p>
 * Read more here:
 * <a href="https://jaxb.java.net/guide/Using_different_datatypes.html">https://jaxb.java.net/guide/Using_different_datatypes.html</a>
 *
 * @author Dennis Lundberg
 */
public class DateAdapter {
  public static Date parseDate(final String date) {
    return DatatypeConverter.parseDate(date).getTime();
  }
  public static String printDate(final Date date) {
    Calendar cal = new GregorianCalendar();
    cal.setTime(date);
    return DatatypeConverter.printDate(cal);
  }
}
