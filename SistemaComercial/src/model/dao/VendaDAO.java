package model.dao;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.GerenciadorConexao;
import model.pojo.Venda;
import model.pojo.ItemVenda;
import model.pojo.Produto;

public class VendaDAO {
    private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;
    
    private VendaDAO(){}
    
    private static VendaDAO instance;
    
    public static VendaDAO getInstance(){
        if(instance==null){
            instance = new VendaDAO();
        }
        return instance;
    }
    
    public boolean create(Venda venda){
        boolean resultado = true;
        String sql;
        try {
            sql = "INSERT INTO venda(id,cli_id,data_venda,valor_total) "
                    + "VALUES(nextval('venda_id_sequence'),?,?,?)";
            conn = GerenciadorConexao.getInstance().getConexao();
            conn.setAutoCommit(false);
            stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setLong(1, venda.getCliente().getId());
            stm.setDate(2, new Date(venda.getDataVenda().getTime()));
            stm.setDouble(3, venda.getValorTotal());
            resultado = stm.execute();
            
            rs = stm.getGeneratedKeys();
            rs.next();
            Long idCompra = rs.getLong(1);
            
            for(ItemVenda iv: venda.getItens()){
                sql = "INSERT INTO item_venda(id,pro_id,ven_id,quantidade,valor_unitario) "
                        + "VALUES(nextval('item_venda_id_sequence'),?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setLong(1, iv.getProduto().getId());
                stm.setLong(2, idCompra);
                stm.setInt(3, iv.getQuantidade());
                stm.setDouble(4, iv.getValorUnitario());
                resultado = stm.execute();
            }//fim-for
            
            for(ItemVenda iv: venda.getItens()){
                Produto p = ProdutoDAO.getInstance().readById(iv.getProduto().getId());
                p.subQuantidadeEstoque(iv.getQuantidade());
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
}
