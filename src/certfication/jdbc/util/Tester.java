/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author f.bertolino
 */
public class Tester extends BookstoreManager {

    @Override
    public void doStuff() throws SQLException {
        final ResultSet selectAllCustomers = query("SELECT * FROM Customer");
        selectAllCustomers.next();
        System.out.println(selectAllCustomers.getString("FirstName"));

        final ResultSet selectAllAuthors = query("SELECT * FROM Author");
        selectAllAuthors.next();
        System.out.println(selectAllAuthors.getString("FirstName"));

        final ResultSet selectAllBooks = query("SELECT * FROM Book");
        selectAllBooks.next();
        System.out.println(selectAllBooks.getString("Title"));

        final ResultSet selectAllBooksByAuthor = query("SELECT * FROM Books_by_Author");
        selectAllBooksByAuthor.next();
        System.out.println(selectAllBooksByAuthor.getString("ISBN"));
    }

    public static void main(String[] args) throws SQLException {
        new Tester().go();
    }
}
