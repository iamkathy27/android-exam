package com.coding.exam.directory.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author katherine.sobejano on 10/21/2021.
 */
public class ActivityUtils {

    public static String formatDateFromDateString(String birthday) throws ParseException {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_OLD_FORMAT);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf1 = new SimpleDateFormat(Constant.DATE_NEW_FORMAT);

        Date date;
        String finalDate = birthday;
        try {
            date = sdf.parse(birthday);
            finalDate = sdf1.format(date);
        } catch (ParseException e) {
            Log.e("Exception ", e.getLocalizedMessage());
            e.printStackTrace();
        }

        return finalDate;
    }

    public static int getAge(String dobString){

        Date date = null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_NEW_FORMAT);
        try {
            date = sdf.parse(dobString);
        } catch (ParseException e) {
            Log.e("Exception ", e.getLocalizedMessage());
            e.printStackTrace();
        }

        if(date == null) return 0;

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.setTime(date);

        int year = dob.get(Calendar.YEAR);
        int month = dob.get(Calendar.MONTH);
        int day = dob.get(Calendar.DAY_OF_MONTH);

        dob.set(year, month+1, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        return age;
    }
}
