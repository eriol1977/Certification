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
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f.bertolino
 */
public class FilesPathAndPaths {

    public static void main(String[] args) {
        try {
            //////////////// CREATE
            Path path = Paths.get("fileWrite1.txt"); // it's only an object
            System.out.println(Files.exists(path)); // look for a real file
            Files.createFile(path); // create a file!
            System.out.println(Files.exists(path)); // look again
            System.out.println("");

            //////////////// DIRECTORY
            Path path2 = Paths.get("java/source/directory");
            Path file = Paths.get("java/source/directory/Program.java");
            Files.createDirectories(path2); // create all levels of directories
            Files.createFile(file); // create file

            //////////////// COPY, MOVE, DELETE
            Path source = Paths.get("java/source/directory/Program.java"); // exists
            Path target = Paths.get("java/source/directory/Program2.java"); // doesn't yet exist
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING); // now two copies of the file
            Files.delete(target); // back to one copy
            Files.move(source, target); // still one copy

            //////////////// INFO
            path = Paths.get("C:\\Users\\f.bertolino\\Documents");
            System.out.println("getFileName: " + path.getFileName());
            System.out.println("getName(1): " + path.getName(1));
            System.out.println("getNameCount: " + path.getNameCount());
            System.out.println("getParent: " + path.getParent());
            System.out.println("getRoot: " + path.getRoot());
            System.out.println("subpath(0, 2): " + path.subpath(0, 2));
            System.out.println("toString: " + path.toString());
            System.out.println("");

            //////////////// ITERATION
            int spaces = 1;
            Path myPath = Paths.get("C:", "Users", "f.bertolino", "Documents");
            for (Path subPath : myPath) {
                System.out.format("%" + spaces + "s%s%n", "", subPath);
                spaces += 2;
            }
            System.out.println("");

            //////////////// NORMALIZE
            System.out.println(Paths.get("/a/./b/./c").normalize());
            System.out.println(Paths.get(".classpath").normalize());
            System.out.println(Paths.get("/a/b/c/..").normalize());
            System.out.println(Paths.get("../a/b/c").normalize());
            System.out.println("");

            //////////////// RESOLVE
            Path absolute = Paths.get("/home/java");
            Path relative = Paths.get("dir");
            file = Paths.get("Model.pdf");
            System.out.println("1: " + absolute.resolve(relative));
            System.out.println("2: " + absolute.resolve(file));
            System.out.println("3: " + relative.resolve(file));
            System.out.println("4: " + relative.resolve(absolute)); // BAD
            System.out.println("5: " + file.resolve(absolute)); // BAD
            System.out.println("6: " + file.resolve(relative)); // BAD
            System.out.println("");

            //////////////// RELATIVIZE
            Path absolute1 = Paths.get("/home/java");
            Path absolute2 = Paths.get("/usr/local");
            Path absolute3 = Paths.get("/home/java/temp/music.mp3");
            Path relative1 = Paths.get("temp");
            Path relative2 = Paths.get("temp/music.pdf");
            System.out.println("1: " + absolute1.relativize(absolute3));
            System.out.println("2: " + absolute3.relativize(absolute1));
            System.out.println("3: " + absolute1.relativize(absolute2));
            System.out.println("4: " + relative1.relativize(relative2));
            //System.out.println("5: " + absolute1.relativize(relative1));//BAD
            System.out.println("");

            clean();
        } catch (IOException ex) {
            Logger.getLogger(FilesPathAndPaths.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void clean() throws IOException {
        Files.deleteIfExists(Paths.get("fileWrite1.txt"));
        Files.deleteIfExists(Paths.get("java/source/directory/Program2.java"));
        Files.deleteIfExists(Paths.get("java/source/directory"));
        Files.deleteIfExists(Paths.get("java/source"));
        Files.deleteIfExists(Paths.get("java"));
    }
}
