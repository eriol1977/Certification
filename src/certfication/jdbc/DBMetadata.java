/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc;

import certfication.jdbc.util.BookstoreManager;
import static java.lang.System.out;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author f.bertolino
 */
public class DBMetadata extends BookstoreManager {

    public static void main(String[] args) throws SQLException {
        new DBMetadata().go();
    }

    @Override
    public void doStuff() throws SQLException {
        DatabaseMetaData dbmd = getConn().getMetaData();
        if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
            out.print("Supports TYPE_FORWARD_ONLY");
            if (dbmd.supportsResultSetConcurrency(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE)) {
                out.println(" and supports CONCUR_UPDATABLE");
            }
        }
        if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
            out.print("Supports TYPE_SCROLL_INSENSITIVE");
            if (dbmd.supportsResultSetConcurrency(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
                out.println(" and supports CONCUR_UPDATABLE");
            }
        }
        if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
            out.print("Supports TYPE_SCROLL_SENSITIVE");
            if (dbmd.supportsResultSetConcurrency(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
                out.println("Supports CONCUR_UPDATABLE");
            }
        }

        ResultSet rs = dbmd.getCatalogs();
        while (rs.next()) {
            out.print("Catalog Name: " + rs.getString("CATALOG_NAME") + " ");
        }
        
        rs = dbmd.getSchemas();
        while (rs.next()) {
            out.print("SCHEMA Name: " + rs.getString("SCHEMA_NAME") + " ");
        }

//        rs = dbmd.getColumns("PUBLIC", "%", "%", "%");
//        while (rs.next()) {
//            out.print("Table Name: " + rs.getString("TABLE_NAME") + " ");
//            out.print("Column_Name: " + rs.getString("COLUMN_NAME") + " ");
//            out.print("Type_Name: " + rs.getString("TYPE_NAME") + " ");
//            out.println("Column Size " + rs.getString("COLUMN_SIZE"));
//        }
    }

}
