package Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UtilsService {

    private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    public static DateFormat getDateFormat(){
        return dateFormat;
    }
}
