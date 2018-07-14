package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.GerenciadorConexao;
import model.pojo.Fornecedor;

public class FornecedorDAO {

    //Atributos
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    //Inicio Singleton
    private FornecedorDAO() {
    }
    private static FornecedorDAO instance = null;

    public static FornecedorDAO getInstance() {
        if (instance == null) {
            instance = new FornecedorDAO();
        }
        return instance;
    }
    //Fim singleton

    public boolean create(Fornecedor fornecedor) {
        boolean resultado = true;

        String sql;
        try {
            sql = "INSERT INTO fornecedor(id,nome,cnpj,telefone,email,"
                    + "inscricao_estadual) "
                    + "VALUES(nextval('fornecedor_id_sequence'),?,?,?,?,?)";

            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);

            stm.setString(1, fornecedor.getNome());
            stm.setString(2, fornecedor.getCnpj());
            stm.setString(3, fornecedor.getTelefone());
            stm.setString(4, fornecedor.getEmail());
            stm.setString(5, fornecedor.getInscricaoEstadual());

            resultado = stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
        return resultado;
    }//fim-create

    public List<Fornecedor> readAll() {
        List<Fornecedor> listaFornecedores = new ArrayList<>();
        String sql;
        try {
            sql = "SELECT * FROM fornecedor";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setInscricaoEstadual(rs.getString("inscricao_estadual"));
                listaFornecedores.add(f);
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
        return listaFornecedores;
    }
    
    public boolean deleteById(Long id){
        boolean resultado = true;
        String sql;
        try {
            sql = "DELETE FROM fornecedor WHERE id=?";
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
            sql = "DELETE FROM fornecedor";
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
    
    public Fornecedor readById(Long id){
        Fornecedor f = null;
        String sql;
        try {
            sql = "SELECT * FROM fornecedor WHERE id=?";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            stm.setLong(1, id);
            rs = stm.executeQuery();
            
            while(rs.next()){
                f = new Fornecedor();
                f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setInscricaoEstadual(rs.getString("inscricao_estadual"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
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
        return f;
    }
    
   public boolean updateById(Fornecedor f){
       boolean resultado = true;
       String sql;
       
       try {
           sql = "UPDATE fornecedor SET nome=?, cnpj=?,"
                   + "inscricao_estadual=?, email=?,"
                   + "telefone=? WHERE id=?";
           conn = GerenciadorConexao.getInstance().getConexao();
           stm = conn.prepareStatement(sql);
           stm.setString(1, f.getNome());
           stm.setString(2, f.getCnpj());
           stm.setString(3, f.getInscricaoEstadual());
           stm.setString(4, f.getEmail());
           stm.setString(5, f.getTelefone());
           stm.setLong(6, f.getId());
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
    public Fornecedor readByNome(String nome){
        Fornecedor f = null;
        String sql;
        try {
            sql = "SELECT * FROM fornecedor WHERE nome like ?";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, nome);
            rs = stm.executeQuery();
            while(rs.next()){
                f = new Fornecedor();
                f.setId(rs.getLong("id"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setInscricaoEstadual(rs.getString("inscricao_estadual"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
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
        return f;
    }   
}
