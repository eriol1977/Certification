/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc;

import certfication.jdbc.util.BookstoreManager;
import static java.lang.System.out;
import java.sql.SQLException;

/**
 *
 * @author f.bertolino
 */
public class Update extends BookstoreManager {

    public static void main(String[] args) throws SQLException {
        new Update().go();
    }

    @Override
    public void doStuff() throws SQLException {
        String q = "UPDATE Book SET UnitPrice=14.99 WHERE UnitPrice < 14.00 AND Format='Hardcover'";
        int numRows = update(q);
        out.printf("Updated rows: %d\n", numRows);
    }

}
