/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            
            String sql = "insert into dvd values(0,?,?,?,?)";
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
    public String Excluir_DVD(DVD a){
        String sql = "delete from dvd where idfilme = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod_filme());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<DVD> ListarDVD() {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao from dvd";
        List<DVD> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                
                    Lista.add(a);
                }
                
                return Lista;
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<DVD> Pesquisar_Cod_filme(int cod) {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao from dvd where idfilme="+ cod +"";
        List<DVD> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                
                    Lista.add(a);
                }
                
                return Lista;
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<DVD> Pesquisa_Cod_Dvd(int cod) {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao from dvd where iddvd = "+ cod +"";
        List<DVD> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                
                    Lista.add(a);
                }
                
                return Lista;
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            return null;
        }
    }
}
