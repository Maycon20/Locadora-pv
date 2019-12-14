/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Betty
 */
public class CategoriaDAO extends ExecuteSQL {
    
    public CategoriaDAO(Connection con) {
        super(con);
    }


 public String Inserir_Categoria(Categoria a) {
     try {
            String sql = "insert into categoria values(0,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            
            if (ps.executeUpdate()> 0) {
            
                return "Inserido com sucesso!";
            
            } else {
            
                return "Erro ao inserir!";
            
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }    

    public List<Categoria> ListarCategoria() {
        String sql = "select idcategoria,nome from categoria";
        List<Categoria> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
    
    public List<Categoria> Pesquisar_Nome_Categoria(String nome) {
        String sql = "select idcategoria,nome from categoria where nome like '%"+ nome +"%'";
        List<Categoria> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                
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
    
    public List<Categoria> Pesquisar_Cod_Categoria(int cod) {
        String sql = "select idcategoria,nome from categoria where idcategoria like '%"+ cod +"%'";
        List<Categoria> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                
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
