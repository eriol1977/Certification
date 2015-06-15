/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.IOandNIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;

/**
 *
 * @author f.bertolino
 */
public class FileVisitor {

    public static void main(String[] args) throws IOException {
        Files.walkFileTree( // kick off recursive check
                Paths.get("C:\\temp"), // starting point
                new SimpleFileVisitor<Path>() {

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println(file + " - created " + DateFormat.getDateTimeInstance().format(attrs.creationTime().toMillis()));
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        System.out.println("Visiting dir " + dir);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        System.out.println("End visiting dir " + dir);
                        return FileVisitResult.CONTINUE;
                    }

                });

        System.out.println("");
        
        Files.walkFileTree( // kick off recursive check
                Paths.get("C:\\Users\\f.bertolino\\Documents"), // starting point
                new SimpleFileVisitor<Path>() {

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                        System.out.println("Error reading file " + file);
                        return FileVisitResult.TERMINATE;
                    }

                });
    }
}
