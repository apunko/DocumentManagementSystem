package Services;

import java.security.MessageDigest;
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

    public static String getPasswordHash(String password) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return  sb.toString();
    }
}
