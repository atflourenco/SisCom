/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.GerenciadorConexao;
import model.pojo.Cliente;

/**
 *
 * @author Anderson
 */
public class ClienteDAO {
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    private ClienteDAO(){}
    private static ClienteDAO instance = null;
    
    public static ClienteDAO getInstance(){
        if(instance==null){
            instance = new ClienteDAO();
        }
        return instance;
    }
   
    public boolean create(Cliente cliente){
        boolean resultado = true;
        String sql;
        try {
            sql = "INSERT INTO cliente(id,nome,cpf,email,data_nascimento) "
                    + "VALUES(nextval('cliente_id_sequence'),?,?,?,?)";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCpf());
            stm.setString(3, cliente.getEmail());
            stm.setDate(4, new Date(cliente.getNascimento().getTime()));
            resultado = stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(stm!=null){
                    stm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
    
    public List<Cliente> readAll() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql;
        try {
            sql = "SELECT * FROM cliente";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setNascimento(rs.getDate("data_nascimento"));
                listaClientes.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaClientes;
    }    
    
    public boolean deleteById(Long id){
        boolean resultado = true;
        
        String sql;
        
        try {
            sql = "DELETE FROM cliente WHERE id=?";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            stm.setLong(1, id);
            resultado = stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(stm!=null){
                    stm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }    
    public boolean deleteAll(){
        boolean resultado = true;
        String sql;
        try {
            sql = "delete from cliente";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            resultado = stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(stm!=null){
                    stm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
    public Cliente readById(Long id){
        Cliente c = null;
        String sql;
        try {
            sql = "SELECT * FROM cliente WHERE id=?";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            stm.setLong(1, id);
            rs = stm.executeQuery();
            
            while(rs.next()){
                c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setNascimento(rs.getDate("data_nascimento"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs!=null){
                    rs.close();
                }
                if(stm!=null){
                    stm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
    }
    
   public boolean updateById(Cliente c){
       boolean resultado = true;
       String sql;
       
       try {
           sql = "UPDATE cliente SET nome=?, cpf=?,"
                   + "data_nascimento=?, email=?"
                   + " WHERE id=?";
           conn = GerenciadorConexao.getInstance().getConexao();
           stm = conn.prepareStatement(sql);
           stm.setString(1, c.getNome());
           stm.setString(2, c.getCpf());
           stm.setDate(3, new Date(c.getNascimento().getTime()));
           stm.setString(4, c.getEmail());
           stm.setLong(5, c.getId());
           resultado = stm.execute();
       } catch (Exception e) {
           e.printStackTrace();
       }finally{
           try {
               if(stm!=null){
                   stm.close();
               }
               if(conn!=null){
                   conn.close();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       return resultado;   
   }
    public Cliente readByNome(String nome){
        Cliente c = null;
        String sql;
        try {
            sql = "SELECT * FROM cliente WHERE nome like ?";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, nome);
            rs = stm.executeQuery();
            while(rs.next()){
                c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setNascimento(rs.getDate("data_nascimento"));
                c.setEmail(rs.getString("email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs!=null){
                    rs.close();
                }
                if(stm!=null){
                    stm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
    }   
}
