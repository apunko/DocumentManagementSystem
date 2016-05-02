package Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsService {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static DateFormat getDateFormat(){
        return dateFormat;
    }

    public static String formatDate(Date date){
        if (date == null) return null;
        return getDateFormat().format(date);
    }
}
