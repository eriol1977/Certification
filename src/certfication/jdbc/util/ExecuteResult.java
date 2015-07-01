/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.jdbc.util;

import java.sql.ResultSet;

/**
 *
 * @author f.bertolino
 */
public class ExecuteResult {

    private final ResultSet rs;

    private final int affectedRows;

    public ExecuteResult(ResultSet rs, int affectedRows) {
        this.rs = rs;
        this.affectedRows = affectedRows;
    }

    public ResultSet getRs() {
        return rs;
    }

    public int getAffectedRows() {
        return affectedRows;
    }
}
