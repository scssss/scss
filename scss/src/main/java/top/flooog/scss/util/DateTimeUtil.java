package top.flooog.scss.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static final String DATA_FORMAT = "yyyy-mm-dd HH:mm:ss";

    public static String getTime(){
        return getTime(new Date());
    }

    /**
     * 对日期格式化
     * @param date
     * @return
     */
    public static String getTime(Date date){
        return (new SimpleDateFormat(DATA_FORMAT)).format(date);
    }
}
