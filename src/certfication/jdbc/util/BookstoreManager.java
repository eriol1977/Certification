/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc.util;

import java.sql.SQLException;

/**
 *
 * @author f.bertolino
 */
public abstract class BookstoreManager extends DBManager {

    public void go() throws SQLException {
        createBookstore();
        doStuff();
        shutdown();
    }

    public abstract void doStuff() throws SQLException;

    private void createBookstore() throws SQLException {
        connect("bookstore");
        dropTables();
        createCustomerTable();
        createAuthorTable();
        createBookTable();
        createBookByAuthorTable();
    }

    private void createCustomerTable() throws SQLException {
        update("CREATE TABLE Customer ( CustomerID INTEGER IDENTITY, FirstName VARCHAR(30), LastName VARCHAR(30), EMail VARCHAR(30), Phone VARCHAR(30))");
        update("INSERT INTO Customer(FirstName,LastName,EMail,Phone) VALUES('John','Smith','john.smith@verizon.net','555-340-1230')");
        update("INSERT INTO Customer(FirstName,LastName,EMail,Phone) VALUES('Mary','Johnson','mary.john@comcast.net','555-123-4567')");
        update("INSERT INTO Customer(FirstName,LastName,EMail,Phone) VALUES('Bob','Collins','bob.collins@yahoo.com','555-012-3456')");
        update("INSERT INTO Customer(FirstName,LastName,EMail,Phone) VALUES('Rebecca','Mayer','rebecca.mayer@gmail.com','555-205-8212')");
    }

    private void createAuthorTable() throws SQLException {
        update("CREATE TABLE Author ( AuthorID INTEGER IDENTITY, FirstName VARCHAR(30), LastName VARCHAR(30))");
        update("INSERT INTO Author(FirstName,LastName) VALUES('Rick','Riordan')");
        update("INSERT INTO Author(FirstName,LastName) VALUES('Nancy','Farmer')");
        update("INSERT INTO Author(FirstName,LastName) VALUES('Ally','Condie')");
        update("INSERT INTO Author(FirstName,LastName) VALUES('Cressida','Cowell')");
    }

    private void createBookTable() throws SQLException {
        update("CREATE TABLE Book ( ISBN VARCHAR(20) , Title VARCHAR(40), PubDate VARCHAR(30), Format VARCHAR(30), UnitPrice FLOAT, PRIMARY KEY (ISBN))");
        update("INSERT INTO Book(ISBN,Title,PubDate,Format,UnitPrice) VALUES('142311339X','The Lost Hero                     ','2010-10-12','Hardcover',10.95)");
        update("INSERT INTO Book(ISBN,Title,PubDate,Format,UnitPrice) VALUES('0689852223','The House of the Scorpion         ','2002-01-01','Hardcover',16.95)");
        update("INSERT INTO Book(ISBN,Title,PubDate,Format,UnitPrice) VALUES('0525423656','Crossed (Matched Trilogy, Book 2) ','2011-11-01','Paperback',12.95)");
        update("INSERT INTO Book(ISBN,Title,PubDate,Format,UnitPrice) VALUES('1423153627','The Kane Chronicles Survival Guide','2012-03-01','Paperback',13.95)");
    }

    private void createBookByAuthorTable() throws SQLException {
        update("CREATE TABLE Books_by_Author ( AuthorID INTEGER, ISBN VARCHAR(20))");
        update("ALTER TABLE Books_by_Author ADD FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID)");
        update("ALTER TABLE Books_by_Author ADD FOREIGN KEY (ISBN) REFERENCES Book(ISBN)");
        update("INSERT INTO Books_by_Author(AuthorID,ISBN) VALUES(0,'142311339X')");
        update("INSERT INTO Books_by_Author(AuthorID,ISBN) VALUES(1,'0689852223')");
        update("INSERT INTO Books_by_Author(AuthorID,ISBN) VALUES(2,'0525423656')");
        update("INSERT INTO Books_by_Author(AuthorID,ISBN) VALUES(3,'1423153627')");
    }

    private void dropTables() throws SQLException {
        update("DROP TABLE Books_by_Author IF EXISTS");
        update("DROP TABLE Book IF EXISTS");
        update("DROP TABLE Author IF EXISTS");
        update("DROP TABLE Customer IF EXISTS");
    }

}
