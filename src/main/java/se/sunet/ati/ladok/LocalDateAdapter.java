package se.sunet.ati.ladok;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * En adapter som konverterar mellan Java-datatypen <code>LocalDate</code> och
 * XML-datatypen <code>date</code>.
 *
 * @author Johan Nilsson
 * @author Dennis Lundberg
 * @since 2.52.4
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
  /**
   * Returnera värdet av en Java-datatyp som text för användning i XML.
   *
   * {@inheritDoc}
   */
  @Override
  public String marshal(final LocalDate value) throws Exception {
    if(value == null) {
      return null;
    }
    else {
      return value.toString();
    }
  }

  /**
   * Returnera en Java-datatyp som motsvarar angiven text från XML.
   *
   * {@inheritDoc}
   */
  @Override
  public LocalDate unmarshal(final String value) throws Exception {
    if(value == null) {
      return null;
    }
    else {
      return LocalDate.parse(value);
    }
  }
}
