/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc;

import certfication.jdbc.util.BookstoreManager;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author f.bertolino
 */
public class Metadata extends BookstoreManager {

    public static void main(String[] args) throws SQLException {
        new Metadata().go();
    }

    @Override
    public void doStuff() throws SQLException {
        String query = "SELECT AuthorID FROM Author";
        ResultSet rs = query(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        rs.next();
        int colCount = rsmd.getColumnCount(); // How many columns in this ResultSet?
        out.println("Column Count: " + colCount);
        for (int i = 1; i <= colCount; i++) {
            out.println("Table Name: " + rsmd.getTableName(i));
            out.println("Column Name: " + rsmd.getColumnName(i));
            out.println("Column Size: " + rsmd.getColumnDisplaySize(i));
        }
    }

}
