/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc;

import certfication.jdbc.util.BookstoreManager;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author f.bertolino
 */
public class Query extends BookstoreManager {

    public static void main(String[] args) throws SQLException {
        new Query().go();
    }

    @Override
    public void doStuff() throws SQLException {
        String query = "SELECT * FROM Customer";
        out.println(query);
        printSeparator();
        ResultSet rs = query(query); // Execute Query
        while (rs.next()) { // Process Results
            out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%s\n", rs.getInt("CustomerID"), 
                    rs.getString("FirstName"), rs.getString("LastName"), 
                    rs.getString("EMail"), rs.getString("Phone"));
        }
        printSeparator();
        out.println("");
        
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        query = "SELECT Title, PubDate, UnitPrice from Book";
        out.println(query);
        printSeparator();
        rs = query(query); // Execute Query
        while (rs.next()) { // Process Results
            out.printf("%s\t\t%s\t\t%.2f\n", rs.getString("Title"), 
                    df.format(rs.getDate("PubDate")), rs.getFloat("UnitPrice"));
        }
        printSeparator();
        out.println("");
    }

    private void printSeparator() {
        out.println("-----------------------------------------------------------------------------------------------");
    }
}
