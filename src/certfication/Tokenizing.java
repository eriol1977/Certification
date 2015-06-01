/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author f.bertolino
 */
public class Tokenizing {

    public static void main(String[] args) {
        final Tokenizing t = new Tokenizing();
        t.tokenize("Tokenize by ','", "ab,cd5b,6x,z4", ",");
        t.tokenize("Tokenize by ','", "ab,cd5b,6x,z4", "\\d");
    }

    private void tokenize(final String header, final String text, final String delimiter) {
        U.h(header);
        System.out.println("Text: '" + text + "'");
        System.out.println("Delimiter: '" + delimiter + "'");
        tokenizeWithSplit(text, delimiter);
        tokenizeWithScanner(text, delimiter);
        tokenizeWithStringTokenizer(text, delimiter);
        U.e();
    }

    private void tokenizeWithSplit(final String text, final String delimiter) {

        final String[] tokens = text.split(delimiter);
        System.out.print("Tokens (Split):   ");
        for (final String s : tokens) {
            System.out.print(">" + s + "<       ");
        }
        System.out.println("(Count: " + tokens.length + ")");
    }

    private void tokenizeWithScanner(final String text, final String delimiter) {
        final Scanner scanner = new Scanner(text);
        scanner.useDelimiter(delimiter);
        int count = 0;
        System.out.print("Tokens (Scanner): ");
        while (scanner.hasNext()) {
            System.out.print(">" + scanner.next() + "<       ");
            count++;
        }
        System.out.println("(Count: " + count + ")");
    }

    private void tokenizeWithStringTokenizer(final String text, final String delimiter) {
        final StringTokenizer st = new StringTokenizer(text, delimiter);
        System.out.print("Tokens (StrTok):  ");
        int count = st.countTokens();
        while (st.hasMoreTokens()) {
            System.out.print(">" + st.nextToken() + "<       ");
        }
        System.out.println("(Count: " + count + ")");
    }
}
