/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author f.bertolino
 */
public class UsingLocale {

    public static void main(String[] args) {

        Locale locIT = new Locale("it", "IT"); // Italy
        Locale locPT = new Locale("pt"); // Portugal
        Locale locBR = new Locale("pt", "BR"); // Brazil
        Locale locIN = new Locale("hi", "IN"); // India
        Locale locJA = new Locale("ja"); // Japan
        Locale locDK = new Locale("da", "DK"); // Denmark
        Locale locUS = new Locale("us"); // USA

        System.out.println("######### DISPLAY COUNTRY ########");
        System.out.println("def " + locBR.getDisplayCountry());
        System.out.println("loc " + locBR.getDisplayCountry(locJA));
        System.out.println("def " + locDK.getDisplayLanguage());
        System.out.println("loc " + locDK.getDisplayLanguage(locDK));
        System.out.println("D>I " + locDK.getDisplayLanguage(locPT));
        System.out.println("");

        System.out.println("######### DATEFORMAT ########");
        Calendar c = Calendar.getInstance();
        c.set(2010, 11, 14); // December 14, 2010 (month is 0-based)
        Date d2 = c.getTime();
        DateFormat df = DateFormat.getInstance();
        System.out.println("Local " + df.format(d2));
        DateFormat dffull = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Local full " + dffull.format(d2));
        DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL, locIT);
        System.out.println("Italy " + dfIT.format(d2));
        DateFormat dfPT = DateFormat.getDateInstance(DateFormat.FULL, locPT);
        System.out.println("Portugal " + dfPT.format(d2));
        DateFormat dfBR = DateFormat.getDateInstance(DateFormat.FULL, locBR);
        System.out.println("Brazil " + dfBR.format(d2));
        DateFormat dfIN = DateFormat.getDateInstance(DateFormat.FULL, locIN);
        System.out.println("India " + dfIN.format(d2));
        DateFormat dfJA = DateFormat.getDateInstance(DateFormat.FULL, locJA);
        System.out.println("Japan " + dfJA.format(d2));
        System.out.println("");

        System.out.println("######### NUMBERFORMAT ########");
        float f1 = 123.45678f;
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getInstance();
        nfa[1] = NumberFormat.getInstance(locUS);
        nfa[2] = NumberFormat.getCurrencyInstance();
        nfa[3] = NumberFormat.getCurrencyInstance(locBR);
        for (NumberFormat nf : nfa) {
            System.out.println(nf.format(f1));
        }

        NumberFormat nf = NumberFormat.getInstance();
        System.out.print(nf.getMaximumFractionDigits() + " ");
        System.out.print(nf.format(f1) + " ");
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(f1) + " ");
        try {
            System.out.println(nf.parse("1234,567"));
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse("1234,567"));
        } catch (ParseException pe) {
            System.out.println("parse exc");
        }
        System.out.println("");

        System.out.println("######### DEFAULT LOCALE ########");
        // store locale so can put it back at end
        Locale initial = Locale.getDefault();
        System.out.println(initial);
        df = DateFormat.getInstance();
        System.out.println(df.format(d2));
        // set locale to Germany
        Locale.setDefault(Locale.GERMANY);
        System.out.println(Locale.getDefault());
        df = DateFormat.getInstance();
        System.out.println(df.format(d2));
        // put original locale back
        Locale.setDefault(initial);
        System.out.println(Locale.getDefault());
        df = DateFormat.getInstance();
        System.out.println(df.format(d2));
    }
}
