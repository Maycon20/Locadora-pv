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
public class FilmeDAO extends ExecuteSQL {
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a){
        try{
            String sql = "insert into filme values(0,?,?,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificacao());
            ps.setString(6, a.getCapa());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir!";
            }
            
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public List<Filme> ListarComboFilme(){
        String sql = "select titulo from filme order by titulo";
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme a = new Filme();
                    a.setTitulo(rs.getString(1));
                    lista.add(a);
                }
                
                return lista;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Filme> ConsultaCodigoFilme(String nome) {
        String sql = "select idfilme from filme where titulo = '"+ nome +"'";
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                
                return lista;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Excluir_Filme(Filme a){
        String sql = "delete from filme where idfilme = ? and titulo = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getTitulo());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Filme> ListarFilme(){
        String sql = "SELECT *"+
                " FROM filme fil INNER JOIN categoria cat ON (fil.idcategoria = cat.idcategoria) "
                + "INNER JOIN classificacao clas ON (fil.idclassificacao = clas.idclassificacao)"; 
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setNomeClassificacao(rs.getString(11));
                    a.setNome_categoria(rs.getString(9));
                    
                    lista.add(a);
                }
                
                return lista;
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            return null; 
        }
    }
    
    public List<Filme> Pesquisar_Nome_Filme(String nome){
        String sql = "SELECT *"+
                " FROM filme fil INNER JOIN categoria cat ON (fil.idcategoria = cat.idcategoria AND titulo LIKE '%"+nome+"%') "
                + "INNER JOIN classificacao clas ON (fil.idclassificacao = clas.idclassificacao) "; 
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setNomeClassificacao(rs.getString(11));
                    a.setNome_categoria(rs.getString(9));
                    
                    lista.add(a);
                }
                
                return lista;
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            return null; 
        }
    }
    
    public List<Filme> Pesquisar_Cod_Filme(int cod){
        String sql = "SELECT *"+
                " FROM filme fil INNER JOIN categoria cat ON (fil.idcategoria = cat.idcategoria AND idfilme ="+ cod +") "
                + "INNER JOIN classificacao clas ON (fil.idclassificacao = clas.idclassificacao) "; 
        List<Filme> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = (PreparedStatement) getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            if (rs != null) {
                while (rs.next()) {                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setNomeClassificacao(rs.getString(11));
                    a.setNome_categoria(rs.getString(9));
                    
                    lista.add(a);
                }
                
                return lista;
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            return null; 
        }
    }
}
