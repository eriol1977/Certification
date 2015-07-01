/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author f.bertolino
 */
public abstract class DBManager {

    private Connection conn;

    public void connect(final String dbName) throws SQLException {
        String url = "jdbc:hsqldb:" + dbName;
        String user = "sa";
        String pwd = "";

        conn = DriverManager.getConnection(url, user, pwd); // Get Connection
    }

    public void shutdown() throws SQLException {
        final Statement st = conn.createStatement();
        // db writes out to files and performs clean shuts down
        // otherwise there will be an unclean shutdown
        // when program ends
        st.execute("SHUTDOWN");
        conn.close();    // if there are no other open connection
    }

    //use for SQL commands CREATE, DROP, INSERT and UPDATE
    public synchronized int update(final String expression) throws SQLException {
        try (final Statement st = conn.createStatement()) {
            return st.executeUpdate(expression);
        }
    }

    //use for SQL command SELECT
    public synchronized ResultSet query(final String expression) throws SQLException {
        final ResultSet rs;
        try (final Statement st = conn.createStatement()) {
            rs = st.executeQuery(expression);
        }
        return rs;
    }

    public synchronized ExecuteResult execute(final String expression) throws SQLException {
        ExecuteResult res;
        try (final Statement st = conn.createStatement()) {
            boolean status = st.execute(expression);
            if (status) {
                res = new ExecuteResult(st.getResultSet(), 0);
            } else {
                res = new ExecuteResult(null, st.getUpdateCount());
            }
        }
        return res;
    }

    public Connection getConn() {
        return conn;
    }
}
