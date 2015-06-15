/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.IOandNIO;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author f.bertolino
 */
public class FileNavigationAndIO {

    public static void main(String[] args) {
        try {
            //////////////// FILE
            boolean newFile;
            File file = new File("fileWrite1.txt"); // it's only an object
            System.out.println(file.exists()); // look for a real file
            newFile = file.createNewFile(); // maybe create a file!
            System.out.println(newFile); // already there?
            System.out.println(file.exists()); // look again
            System.out.println("");

            //////////////// FILEREADER and FILEWRITER
            char[] in = new char[50]; // to store input
            int size;
            file = new File("fileWrite2.txt"); // just an object
            FileWriter fw = new FileWriter(file); // create an actual file & a FileWriter obj
            fw.write("howdy\nfolks\n"); // write characters to the file
            fw.flush(); // flush before closing
            fw.close(); // close file when done
            FileReader fr = new FileReader(file); // create a FileReader object
            size = fr.read(in); // read the whole file!
            System.out.println("size: " + size); // how many bytes read
            for (char c : in) // print the array
            {
                System.out.print(c);
            }
            fr.close(); // again, always close
            System.out.println("");

            //////////////// PRINTWRITER AND BUFFEREDREADER
            file = new File("fileWrite3.txt"); // create a File object
            fw = new FileWriter(file); // create a FileWriter that will send its output to a File
            PrintWriter pw = new PrintWriter(fw); // create a PrintWriter that will send its output to a Writer
            pw.println("howdy"); // write the data
            pw.println("folks");
            pw.flush();
            pw.close();
            fw.close();
            fr = new FileReader(file); // create a FileReader to get data from 'file'
            BufferedReader br = new BufferedReader(fr); // create a BufferReader to get its data from a Reader
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
            br.close();
            fr.close(); // again, always close
            System.out.println("");

            //////////////// DIRECTORIES
            File myDir = new File("mydir"); // create an object
            myDir.mkdir();
            File myFile = new File(myDir, "myFile.txt");
            myFile.createNewFile();
            pw = new PrintWriter(myFile);
            pw.println("new stuff");
            pw.flush();
            pw.close();
            File existingDir = new File("mydir"); // assign a dir
            System.out.println(existingDir.isDirectory());
            File existingDirFile = new File(existingDir, "myFile.txt"); // assign a file
            System.out.println(existingDirFile.isFile());
            System.out.println("");

            //////////////// DELETE, RENAMETO
            File delDir = new File("deldir"); // make a directory
            delDir.mkdir();
            File delFile1 = new File(delDir, "delFile1.txt"); // add file to directory
            delFile1.createNewFile();
            File delFile2 = new File(delDir, "delFile2.txt"); // add file to directory
            delFile2.createNewFile();
            delFile1.delete(); // delete a file
            System.out.println("delDir is " + delDir.delete()); // attempt to delete the directory fails
            File newName = new File(delDir, "newName.txt"); // a new object
            delFile2.renameTo(newName); // rename file
            File newDir = new File("newDir"); // rename directory
            delDir.renameTo(newDir);
            System.out.println("");

            //////////////// SEARCH
            String[] files;
            File search = new File("mydir");
            files = search.list(); // create the list
            for (String fn : files) // iterate through it
            {
                System.out.println("found " + fn);
            }
            System.out.println("");

            clean();

            //////////////// CONSOLE
            String name = "";
            Console c = System.console(); // #1: get a Console
            char[] pwd;
            if(c != null) {
            pwd = c.readPassword("%s", "pw: "); // #2: return a char[]
            for (char ch : pwd) {
                c.format("%c ", ch); // #3: format output
            }
            c.format("\n");
            while (true) {
                name = c.readLine("%s", "input?: "); // #4: return a String
                if(name.equals("quit"))
                    break;
                c.format("output: %s \n", name);
            }
            }else{
                System.out.println("Couldn't get a Console!");
            }
        } catch (IOException e) {
        }
    }

    private static void clean() {
        File toClean = new File("fileWrite1.txt");
        toClean.delete();
        toClean = new File("fileWrite2.txt");
        toClean.delete();
        toClean = new File("fileWrite3.txt");
        toClean.delete();
        File toCleanDir = new File("mydir");
        toClean = new File(toCleanDir, "myFile.txt");
        toClean.delete();
        toCleanDir.delete();
        toCleanDir = new File("newDir");
        toClean = new File(toCleanDir, "newName.txt");
        toClean.delete();
        toCleanDir.delete();
    }
}
