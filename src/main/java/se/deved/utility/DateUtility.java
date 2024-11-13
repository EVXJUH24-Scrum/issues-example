package se.deved.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
    public static Date parseString(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date = formatter.parse(s);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

}
