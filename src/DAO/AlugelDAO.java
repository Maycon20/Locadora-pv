/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Betty
 */
public class AlugelDAO extends ExecuteSQL {
    
    public AlugelDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Aluguel(Aluguel a) {
        try {
            String sql = "insert into aluguel values(0,?,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCoddvd());
            ps.setDouble(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getData_aluguel());
            ps.setString(5, a.getData_devolucao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }  
    
    public String Atualizar_Situacao(int cod, String situacao) {
        String sql = "update dvd set situacao = '"+ situacao +"' where iddvd = "+ cod +" ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso!";
            } else {
                return "Erro ao Atualizar!";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Aluguel> ListarAluguel() {
        String sql = "select * from aluguel";
        List<Aluguel> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                
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
    
    public List<Aluguel> Pesquisa_Cod_Aluguel(int cod) {
        String sql = "select * from aluguel where idaluguel = "+ cod +"";
        List<Aluguel> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                
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
    
    public List<Aluguel> Pesquisa_Cod_Cliente(int cod) {
        String sql = "select * from aluguel where idcliente = "+ cod +"";
        List<Aluguel> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                
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
    public List<Aluguel> Pesquisa_Cod_DVD(int cod) {
        String sql = "select * from aluguel where iddvd = "+ cod +"";
        List<Aluguel> Lista = new ArrayList<>();
           
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                
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
    
    public String Excluir_Aluguel(Aluguel a){
        String sql = "delete from aluguel where idaluguel = ?";
       
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());

            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String Atualiza_Situacao(Aluguel a){
        String sql = "update dvd set situacao='Disponivel' WHERE iddvd = ?";
        
        try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1, a.getCoddvd());
           
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao Atualizar";
            }
           
        } catch (SQLException e) {
            return e.getMessage(); 
        }
   } 
}
