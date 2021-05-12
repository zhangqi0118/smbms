package com.smbms.converter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.expression.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    SimpleDateFormat sdf_01 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf_02 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date convert(String source) {
        Date date = null;
        if(source==null||"".equals(source.trim())){
            return null;
        }
        try {
            if(source.length()==10){
                date = sdf_01.parse(source);
            }else if(source.length()==19){
                date = sdf_02.parse(source);
            }
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
//
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    Date date = new Date();
//
//    @Override
//    public Date convert(String source) {
//        try {
//            date = sdf.parse(source);
//        } catch (ParseException | java.text.ParseException e) {
//            e.printStackTrace();
//        }
//        return date;
//    }

}
