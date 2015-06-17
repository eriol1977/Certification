/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.IOandNIO;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 *
 * @author f.bertolino
 */
public class PathMatcherSearch {

    public static void main(String[] args) throws IOException {

        Path path1 = Paths.get("/home/One.txt");
        Path path2 = Paths.get("One.txt");
        matches(path1, "glob:*.txt");
        matches(path2, "glob:*.txt");
        System.out.println("");

        Path path = Paths.get("/com/java/One.java");
        matches(path, "glob:*.java"); // false
        matches(path, "glob:**/*.java"); // true
        matches(path, "glob:*"); // false
        matches(path, "glob:**"); // true
        System.out.println("");

        path1 = Paths.get("One.java");
        path2 = Paths.get("One.ja^a");
        matches(path1, "glob:*.????"); // true
        matches(path1, "glob:*.???"); // false
        matches(path2, "glob:*.????"); // true
        matches(path2, "glob:*.???"); // false
        System.out.println("");

        path1 = Paths.get("Bert-book");
        path2 = Paths.get("Kathy-horse");
        matches(path1, "glob:{Bert*,Kathy*}"); // true
        matches(path2, "glob:{Bert,Kathy}*"); // true
        matches(path1, "glob:{Bert,Kathy}"); // false
        System.out.println("");

        //path1 = Paths.get("0*b/test/1");
        //path2 = Paths.get("9\\*b/test/1");
        Path path3 = Paths.get("01b/test/1");
        //Path path4 = Paths.get("0*b/1");
        String glob = "glob:[0-9]\\*{A*,b}/**/1";
        //matches(path1, glob); // true
        //matches(path2, glob); // false
        matches(path3, glob); // false
        //matches(path4, glob); // false
        System.out.println("");
    }

    public static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(matcher.matches(path));
    }
}
