package controller;

import java.util.List;
import model.dao.ProdutoDAO;
import model.pojo.Produto;

public class ProdutoController {
    //Inicio singleton
    private ProdutoController(){}
    
    private static ProdutoController instance = null;
    
    public static ProdutoController getInstance(){
        if(instance==null){
            instance = new ProdutoController();
        }
        return instance;
    }
    //Fim singleton
    
    //Metodo para criar um produto
    public boolean createProduto(String nome, Double precoCompra,
            Double precoVenda,Integer quantidadeEstoque){
        boolean r = true;
        Produto p = new Produto();
        p.setNome(nome);
        p.setPrecoCompra(precoCompra);
        p.setPrecoVenda(precoVenda);
        p.setQuantidadeEstoque(quantidadeEstoque);
        
        r = ProdutoDAO.getInstance().create(p);
        
        return r;
    }
    //fim createProduto
    
    public List<Produto> readAllProdutos(){
        return ProdutoDAO.getInstance().readAll();
    }
    
    public boolean deleteProdutoById(Long id){
        return ProdutoDAO.getInstance().deleteById(id);
    }
    
    public boolean deleteAllProdutos(){
        return ProdutoDAO.getInstance().deleteAll();
    }
    
    public Produto readProdutoById(Long id){
        Produto produto = ProdutoDAO.getInstance().readById(id);
        return produto;
    }
    
    public boolean updateProdutoById(Long id, String nome,
            Double precoCompra,Double precoVenda,Integer quantidadeEstoque){
        boolean resultado = true;
        Produto p = new Produto();
        p.setId(id);
        p.setNome(nome);
        p.setPrecoVenda(precoVenda);
        p.setPrecoCompra(precoCompra);
        p.setQuantidadeEstoque(quantidadeEstoque);
        resultado = ProdutoDAO.getInstance().updateById(p);
        
        return resultado;
    }
    public Produto readProdutoByNome(String nome){
        return ProdutoDAO.getInstance().readByNome(nome);
    }    
}
