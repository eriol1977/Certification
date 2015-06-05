/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author f.bertolino
 */
public class MyFileReader extends FileReader {

    public MyFileReader(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public void close() throws IOException {
        super.close();
        System.out.println("FileReader was closed");
    }
}
