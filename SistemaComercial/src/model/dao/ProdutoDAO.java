package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.GerenciadorConexao;
import model.pojo.Produto;



public class ProdutoDAO {

    //Atributos
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    //Inicio Singleton
    private ProdutoDAO() {
    }
    private static ProdutoDAO instance = null;

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }
        return instance;
    }
    //Fim singleton

    public boolean create(Produto produto) {
        boolean resultado = true;

        String sql;
        try {
            sql = "INSERT INTO produto(id,nome,preco_compra,preco_venda,quantidade_estoque) "
                    + "VALUES(nextval('produto_id_sequence'),?,?,?,?)";

            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);

            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getPrecoCompra());
            stm.setDouble(3, produto.getPrecoVenda());
            stm.setInt(4, produto.getQuantidadeEstoque());
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

    public List<Produto> readAll() {
        List<Produto> listaProdutos = new ArrayList<>();
        String sql;
        try {
            sql = "SELECT * FROM produto";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setPrecoCompra(rs.getDouble("preco_compra"));
                p.setPrecoVenda(rs.getDouble("preco_venda"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                listaProdutos.add(p);
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
        return listaProdutos;
    }
    
    public boolean deleteById(Long id){
        boolean resultado = true;
        
        String sql;
        
        try {
            sql = "DELETE FROM produto WHERE id=?";
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
            sql = "DELETE FROM produto";
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
    
    public Produto readById(Long id){
        Produto p = null;
        String sql;
        try {
            sql = "SELECT * FROM produto WHERE id=?";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            stm.setLong(1, id);
            rs = stm.executeQuery();
            while(rs.next()){
                p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setPrecoCompra(rs.getDouble("preco_compra"));
                p.setPrecoVenda(rs.getDouble("preco_venda"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
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
        return p;
    }
    
   public boolean updateById(Produto p){
       boolean resultado = true;
       String sql;
       
       try {
           sql = "UPDATE produto SET nome=?, preco_compra=?,"
                   + "preco_venda=?, quantidade_estoque=? "
                   +"WHERE id=?";
           conn = GerenciadorConexao.getInstance().getConexao();
           stm = conn.prepareStatement(sql);
           stm.setString(1, p.getNome());
           stm.setDouble(2, p.getPrecoCompra());
           stm.setDouble(3, p.getPrecoVenda());
           stm.setInt(4, p.getQuantidadeEstoque());
           stm.setLong(5, p.getId());
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
   
    public Produto readByNome(String nome){
        Produto p = null;
        String sql;
        try {
            sql = "SELECT * FROM produto WHERE nome like ?";
            conn = GerenciadorConexao.getInstance().getConexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, nome);
            rs = stm.executeQuery();
            while(rs.next()){
                p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setPrecoCompra(rs.getDouble("preco_compra"));
                p.setPrecoVenda(rs.getDouble("preco_venda"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
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
        return p;
    }
   
}
