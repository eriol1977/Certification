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
public class Report extends BookstoreManager {

    public static void main(String[] args) throws SQLException {
        new Report().go();
    }

    @Override
    public void doStuff() throws SQLException {
        String query = "SELECT * FROM Customer";
        ResultSet rs = query(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();
        String col, colData;
        for (int i = 1; i <= cols; i++) {
            col = leftJustify(rsmd.getColumnName(i), // Left justify column name padded with size spaces
                    rsmd.getColumnDisplaySize(i));
            out.print(col);
        }
        out.println(); // Print a linefeed
        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                if (rs.getObject(i) != null) {
                    colData = rs.getObject(i).toString(); // Get the data in the column as a String
                } else {
                    colData = "NULL"; // If the column is null use "NULL"
                }
                col = leftJustify(colData, rsmd.getColumnDisplaySize(i));
                out.print(col);
            }
            out.println();
        }
    }

    private String leftJustify(String s, int n) {
        if (s.length() <= n) {
            n++; // Add an extra space if the length of the String s is less than or equal to the length of the column n
        }
        return String.format("%1$-" + n + "s", s); // Pad to the right of the String by n spaces
    }

}
