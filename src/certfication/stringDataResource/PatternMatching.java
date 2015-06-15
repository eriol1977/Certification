/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.stringDataResource;

import certfication.util.U;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author f.bertolino
 */
public class PatternMatching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final PatternMatching pm = new PatternMatching();
        pm.match("Simplest case", "abaaaba", "ab");
        pm.match("A regex search runs from left to right, and once a source's character has been used in a match, it cannot be reused", "abababa", "aba");
        pm.match("Search for numeric digits","a12c3e456f", "\\d");
        pm.match("Search for anything but numeric digits","a12c3e456f", "\\D");
        pm.match("Search for whitespace chars","a 1 56 _Z", "\\s");
        pm.match("Search for anything but whitespace chars (e.g. space, \\t, \\n, \\f, \\r)","a 1 56 _Z", "\\S");
        pm.match("Search for word chars (letters (a–z and A–Z), digits, or the '_' [underscore])","a#1 56@_Z", "\\w");
        pm.match("Search for anything but word chars","a#1 56@_Z", "\\W");
        pm.match("Search for word boundary - NOT WORKING!","w2w w$ &#w2", "\\b");
        pm.match("Search for anything but word boundary - NOT WORKING!","w2w w$ &#w2", "\\B");
        pm.match("Search for a,b or c","abcghtydcaa", "[abc]");
        pm.match("Search for letters from a to d","abcghtydcaa", "[a-d]");
        pm.match("Search for the first three letters, both cases","cafeBABE", "[a-cA-C]");
        pm.match("Search for one or more numeric digit in a row (quantifier '+')","a12c3e456f", "\\d+");
        pm.match("Search for zero or more occurrences of a (quantifier '*')","abaacaaad", "a*");
        pm.match("Search for zero or one occurrence of a (quantifier '?')","abaacaaad", "a?");
        pm.match("Search for anything but 'a' (quantifier '^')","abaacaaad", "[^a]");
        pm.match("Search for 'proj1' + zero or more characters that aren't a comma.","proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java", "proj1([^,])*");
        pm.match("Search for a + anything + c (predefined dot)","ac abc a caxc", "a.c");
        pm.match("Find strings ending with xx: greedy quantifier (*)","yyxxxyxx", ".*xx");
        pm.match("Find strings ending with xx: reluctant quantifier (*?)","yyxxxyxx", ".*?xx");
    }

    private void match(final String header, final String text, final String patternToMatch) {
        U.h(header);
        final Pattern pattern = Pattern.compile(patternToMatch);
        final Matcher matcher = pattern.matcher(text);
        final char[] result = new char[text.length()];
        final String[] indexes = new String[text.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ' ';
            indexes[i] = " ";
        }
        System.out.println(" pattern: " + matcher.pattern());
        System.out.println(" source: " + text);
        int start;
        String group;
        while (matcher.find()) {
            start = matcher.start();
            group = matcher.group();
            if (start < indexes.length) {
                indexes[start] = "" + start;
            }
            for (int i = start, j = 0; i < start + group.length(); i++, j++) {
                result[i] = group.charAt(j);
            }
        }
        System.out.print(" result: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println("");
        System.out.print(" index:  ");
        for (String index : indexes) {
            System.out.print(index);
        }
        System.out.println("");
        U.e();
    }

}
