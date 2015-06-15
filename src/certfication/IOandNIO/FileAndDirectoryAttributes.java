/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.IOandNIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f.bertolino
 */
public class FileAndDirectoryAttributes {

    public static void main(String[] args) {
        try {
            //////////////// LAST MODIFIED
            Date januaryFirst = new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime(); // old way
            File file = new File("c:/temp/file");
            file.createNewFile(); // create the file
            file.setLastModified(januaryFirst.getTime()); // set time
            System.out.println(file.lastModified()); // get time
            file.delete();
            System.out.println("");
            Path path = Paths.get("c:/temp/file2");
            Files.createFile(path); // create another file
            FileTime fileTime = FileTime.fromMillis(januaryFirst.getTime()); // convert to the new FileTime object
            Files.setLastModifiedTime(path, fileTime); // set time
            System.out.println(Files.getLastModifiedTime(path)); // get time
            System.out.println("");

            //////////////// ATTRIBUTES
            System.out.println(Files.isExecutable(path));
            System.out.println(Files.isReadable(path));
            System.out.println(Files.isWritable(path));
            System.out.println("");

            //////////////// READING BASIC ATTRIBUTES
            BasicFileAttributes basic = Files.readAttributes(path, // assume a valid path
                    BasicFileAttributes.class);
            System.out.println("create: " + basic.creationTime());
            System.out.println("access: " + basic.lastAccessTime());
            System.out.println("modify: " + basic.lastModifiedTime());
            System.out.println("directory: " + basic.isDirectory());
            System.out.println("");

            //////////////// WRITING BASIC ATTRIBUTES
            FileTime lastUpdated = basic.lastModifiedTime(); // get current
            FileTime created = basic.creationTime(); // values
            FileTime now = FileTime.fromMillis(System.currentTimeMillis());
            BasicFileAttributeView basicView = Files.getFileAttributeView(
                    path, BasicFileAttributeView.class); // "view" this time
            basicView.setTimes(lastUpdated, now, created); // set all three
            System.out.println("");

            //////////////// DOS ATTRIBUTES
            Path path2 = Paths.get("C:\\Users\\f.bertolino\\Documents\\NetBeansProjects\\Certfication\\pippo.txt");
            Files.createFile(path2); // create file
            Files.setAttribute(path2, "dos:hidden", true); // set attribute
            Files.setAttribute(path2, "dos:readonly", true); // another one
            DosFileAttributes dos = Files.readAttributes(path2,
                    DosFileAttributes.class); // dos attributes
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());
            Files.setAttribute(path2, "dos:hidden", false);
            Files.setAttribute(path2, "dos:readonly", false);
            dos = Files.readAttributes(path2,
                    DosFileAttributes.class); // get attributes again
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());
            Files.delete(path2);
            System.out.println("");

            Files.delete(path); // delete the file
        } catch (IOException ex) {
            Logger.getLogger(FileAndDirectoryAttributes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
