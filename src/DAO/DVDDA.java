/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Betty
 */
public class DVDDA extends ExecuteSQL {
    
    public DVDDA(Connection con) {
        super(con);
    }
    
    public String Inserir_DVD(DVD a) {
        try {
            
            String sql = "insert into dvd values(0,?,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}
