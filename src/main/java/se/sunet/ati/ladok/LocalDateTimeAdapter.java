package se.sunet.ati.ladok;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * En adapter som konverterar mellan Java-datatypen <code>LocalDateTime</code>
 * och XML-datatypen <code>dateTime</code>.
 *
 * @author Johan Nilsson
 * @author Dennis Lundberg
 * @since 2.52.4
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
  /**
   * Returnera värdet av en Java-datatyp som text för användning i XML.
   *
   * {@inheritDoc}
   */
  @Override
  public String marshal(final LocalDateTime value) throws Exception {
    if(value == null) {
      return null;
    }
    else {
      return value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
  }

  /**
   * Returnera en Java-datatyp som motsvarar angiven text från XML.
   *
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime unmarshal(final String value) throws Exception {
    if(value == null) {
      return null;
    }
    else {
      return LocalDateTime.parse(value);
    }
  }
}
