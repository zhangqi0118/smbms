package com.smbms.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {
 public    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getStringDate(Date date) {
        Date date1=date;
        return formatter.format(date1);
    }
}

