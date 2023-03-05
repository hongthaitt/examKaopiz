package test01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funtion {
    public static boolean isValidDate(String d) {
        String regex = "^[0-9]{4}(1[0-2]|0[1-9])" + "(3[01]|[12][0-9]|0[1-9])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence) d);
        return matcher.matches();
    }
    public static void countDate(String startDate, String endDate) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date1 = myFormat.parse(startDate);
            Date date2 = myFormat.parse(endDate);
            long diff;
            if (date1.compareTo(date2) < 0) {
                diff = date2.getTime() - date1.getTime();
            } else {
                diff = date1.getTime() - date2.getTime();
            }
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static Date addMonths(String dateAsString, int nbMonths) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd") ;
        Date date = sdf.parse(dateAsString) ;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, nbMonths + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date dateAfterAMonth = cal.getTime() ;
        System.out.println("Result: " +sdf.format(dateAfterAMonth));
        return dateAfterAMonth ;
    }

}
