/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Betty
 */
public class ClassificacaoDAO extends ExecuteSQL {
  
    public ClassificacaoDAO(Connection con) {
        super(con);
    }
  
    
     public String Inserir_Classificacao(Classificacao a) {
         try {
            String sql = "insert into classificacao values(0,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            
            if (ps.executeUpdate() > 0) {
         
                return "Inserido com sucesso!";
            
            } else {
                return "Erro ao inserir!";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
        }
         
    }
}