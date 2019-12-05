package jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");

    @Override
    public String marshal(Date date) {
        return dateFormat.format(date);
    }

    @Override
    public Date unmarshal(String string) throws ParseException {
        return dateFormat.parse(string);
    }

}
