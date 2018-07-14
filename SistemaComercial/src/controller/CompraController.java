package controller;

import java.util.Date;
import java.util.List;
import model.dao.CompraDAO;
import model.pojo.Compra;
import model.pojo.Fornecedor;
import model.pojo.ItemCompra;

public class CompraController {
    private CompraController(){}
    private static CompraController instance = null;
    public static CompraController getInstance(){
        if(instance==null){
            instance = new CompraController();
        }
        return instance;
    }
    
    public boolean createCompra(String nomeFornecedor, Date dataCompra,
            Double valorTotal, List<ItemCompra> itens){
        boolean r = true;
        Fornecedor f = FornecedorController.getInstance().readFornecedorByNome(nomeFornecedor);
        Compra compra = new Compra();
        compra.setDataCompra(dataCompra);
        compra.setFornecedor(f);
        compra.setValorTotal(valorTotal);
        compra.setItensCompra(itens);
        r = CompraDAO.getInstance().create(compra);
        return r;
    }
}
