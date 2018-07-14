package model.dao;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.GerenciadorConexao;
import model.pojo.Compra;
import model.pojo.ItemCompra;
import model.pojo.Produto;

public class CompraDAO {
    private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;
    
    private CompraDAO(){}
    
    private static CompraDAO instance;
    
    public static CompraDAO getInstance(){
        if(instance==null){
            instance = new CompraDAO();
        }
        return instance;
    }
    
    public boolean create(Compra compra){
        boolean resultado = true;
        String sql;
        try {
            sql = "INSERT INTO compra(id,for_id,data_compra,valor_total) "
                    + "VALUES(nextval('compra_id_sequence'),?,?,?)";
            conn = GerenciadorConexao.getInstance().getConexao();
            conn.setAutoCommit(false);
            stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setLong(1, compra.getFornecedor().getId());
            stm.setDate(2, new Date(compra.getDataCompra().getTime()));
            stm.setDouble(3, compra.getValorTotal());
            resultado = stm.execute();
            
            rs = stm.getGeneratedKeys();
            rs.next();
            Long idCompra = rs.getLong(1);
            
            for(ItemCompra ic: compra.getItensCompra()){
                sql = "INSERT INTO item_compra(id,pro_id,com_id,quantidade,preco_unitario) "
                        + "VALUES(nextval('item_compra_id_sequence'),?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setLong(1, ic.getProduto().getId());
                stm.setLong(2, idCompra);
                stm.setInt(3, ic.getQuantidade());
                stm.setDouble(4, ic.getPrecoUnitario());
                resultado = stm.execute();
            }//fim-for
            
            for(ItemCompra ic: compra.getItensCompra()){
                Produto p = ProdutoDAO.getInstance().readById(ic.getProduto().getId());
                p.addQuantidadeEstoque(ic.getQuantidade());
                sql = "UPDATE produto set quantidade_estoque=? WHERE id=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, p.getQuantidadeEstoque());
                stm.setLong(2, p.getId());
                resultado = stm.execute();
            }
            conn.commit();
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
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
    
    private void selectCompras(){
        
    }
    
    
}
