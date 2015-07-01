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
import java.sql.Statement;

/**
 *
 * @author f.bertolino
 */
public class Scrolling extends BookstoreManager {

    public static void main(String[] args) throws SQLException {
        new Scrolling().go();
    }

    @Override
    public void doStuff() throws SQLException {
        final Statement stmt = getConn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        final String query = "SELECT * FROM Book";
        final ResultSet rs = stmt.executeQuery(query); // Get a ResultSet

        if (rs.last()) { // Move the very last row
            int rowCount = rs.getRow(); // Get row number (the count)
            out.printf("Rows selected: %d\n", rowCount);
            rs.beforeFirst(); // Move to before the 1st row
        }
        
        out.printf("Initial row: %d\n", rs.getRow());
        
        rs.next();
        out.printf("After next(): %d\n", rs.getRow());
        
        rs.previous();
        out.printf("After previous(): %d\n", rs.getRow());
        
        assert !rs.absolute(8);
        assert rs.absolute(3);
        out.printf("After absolute(3): %d\n", rs.getRow());
        assert rs.absolute(-3);
        out.printf("After absolute(-3): %d\n", rs.getRow());
        
        assert rs.relative(2);
        out.printf("After relative(2): %d\n", rs.getRow());
        assert rs.relative(-3);
        out.printf("After relative(-3): %d\n", rs.getRow());
        
        out.printf("Is cursor positioned first? %b\n", rs.isFirst());
        out.printf("Is cursor positioned last? %b\n", rs.isLast());
        out.printf("Is cursor positioned before first? %b\n", rs.isBeforeFirst());
        out.printf("Is cursor positioned after last? %b\n", rs.isAfterLast());
    }
}
