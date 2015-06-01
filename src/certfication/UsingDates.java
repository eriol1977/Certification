/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author f.bertolino
 */
public class UsingDates {

    public static void main(String[] args) {
        System.out.println("######### DATE ########");
        Date d1 = new Date(1_000_000_000_000L); // a trillion!
        System.out.println("1st date: " + d1.toString());
        d1.setTime(d1.getTime() + 3_600_000); // 3_600_000 millis / hour
        System.out.println("new time: " + d1.toString());
        System.out.println("now:      " + new Date());
        System.out.println("millis:   " + new Date().getTime());
        System.out.println("");

        System.out.println("######### CALENDAR ########");
        Calendar c = Calendar.getInstance();
        c.setTime(d1); // #1
        if (Calendar.MONDAY == c.getFirstDayOfWeek()) // #2
        {
            System.out.println("Monday is the first day of the week");
        }
        System.out.println("trillionth milli day of week is "
                + c.get(Calendar.DAY_OF_WEEK)); // #3
        c.add(Calendar.MONTH, 1); // #4
        Date d2 = c.getTime(); // #5
        System.out.println("new date " + d2.toString());
        c.roll(Calendar.HOUR, 13);
        System.out.println("after rolling " + c.getTime().toString());
        System.out.println("");

        System.out.println("######### DATEFORMAT ########");
        DateFormat[] dfa = new DateFormat[6];
        dfa[0] = DateFormat.getInstance();
        dfa[1] = DateFormat.getDateInstance();
        dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
        dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
        for (DateFormat df : dfa) {
            System.out.println(df.format(d2));
        }

        try {
            DateFormat df = DateFormat.getDateInstance(
                    DateFormat.SHORT);
            String s = df.format(d2);
            Date d3 = df.parse(s);
            System.out.println("parsed = " + d3.toString());
        } catch (ParseException pe) {
            System.out.println("parse exc");
        }
    }
}
