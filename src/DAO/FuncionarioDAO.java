/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Betty
 */
public class FuncionarioDAO extends ExecuteSQL {
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    
    
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        
        try { 
            String consulta = "Select login, senha from funcionario " +
            "where login = '" + login + "' and senha = '" + senha + "'";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Funcionario a = new Funcionario();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    finalResult = true;
                }
            }
            
        } catch (SQLException e) {
            e.getMessage();
        }
        return finalResult;
    }
    
     public String Inserir_Funcionario(Funcionario a) {
        try {
            String sql = "insert into funcionario values(0,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getLogin());
            ps.setString(3, a.getSenha());
            
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

