package com.abrahamlay.movieapp.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormater {
    public static String changeDateFormat(String DateFormatInput,String DateInput,String DateFormatOutput){

        try {
            DateFormat inputFormat = new SimpleDateFormat(DateFormatInput);
            DateFormat outputFormat = new SimpleDateFormat(DateFormatOutput,Locale.ENGLISH);
            Date date;
                date = inputFormat.parse(DateInput);

            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
