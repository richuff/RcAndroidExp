package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String getNow(){
        SimpleDateFormat dg =  new SimpleDateFormat("yyyy-MM-dd");
        return dg.format(new Date());
    }

    public static String getNowMonth(){
        SimpleDateFormat dg =  new SimpleDateFormat("yyyy-MM");
        return dg.format(new Date());
    }

    public static String getCalendarTime(Calendar calendar){
        SimpleDateFormat dg = new SimpleDateFormat("yyyy-MM-dd");
        return dg.format(calendar.getTime());
    }

    public static String getCalendarMonth(Calendar calendar){
        SimpleDateFormat dg = new SimpleDateFormat("yyyy-MM");
        return dg.format(calendar.getTime());
    }
}
