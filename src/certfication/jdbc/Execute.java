/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc;

import certfication.jdbc.util.BookstoreManager;
import certfication.jdbc.util.ExecuteResult;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author f.bertolino
 */
public class Execute extends BookstoreManager {

    public static void main(String[] args) throws SQLException {
        new Execute().go();
    }

    @Override
    public void doStuff() throws SQLException {
        String q = "UPDATE Book SET UnitPrice=14.99 WHERE UnitPrice < 14.00 AND Format='Hardcover'";
        ExecuteResult result = execute(q);
        out.printf("Affected rows: %d\n", result.getAffectedRows());

        q = "SELECT Title FROM Book";
        result = execute(q);
        final ResultSet rs = result.getRs();
        while (rs.next()) {
            out.println(rs.getString(1));
        }
    }

}
