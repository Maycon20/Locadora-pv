/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author Betty
 */
public class ExecuteSQL {
    private Connection con;
    
    public ExecuteSQL(Connection con){
        setCon(con);
    }
    
    public Connection getcon(){
        return con;
    }

    private void setCon(Connection con) {
        this.con = con;
    }    
}
