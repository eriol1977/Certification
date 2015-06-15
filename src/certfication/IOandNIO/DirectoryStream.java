/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.IOandNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author f.bertolino
 */
public class DirectoryStream {

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("C:\\Users\\f.bertolino\\Documents");
        try (java.nio.file.DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) // use try with resources so we don't have close()
        {
            for (Path path : stream) // loop through the stream
            {
                System.out.println(path.getFileName());
            }
        }
        System.out.println("");

        try (java.nio.file.DirectoryStream<Path> stream = Files.newDirectoryStream(
                dir, "[vw]*")) { // "v" or "w" followed by anything
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        }
        System.out.println("");
    }
}
