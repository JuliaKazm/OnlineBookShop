package jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String marshal(Date date) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.format(date);
        }
    }

    @Override
    public Date unmarshal(String string) throws Exception {
        synchronized (dateFormat) {
            return (Date) dateFormat.parse(string);
        }
    }
}