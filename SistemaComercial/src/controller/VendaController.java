package controller;

import java.util.Date;
import java.util.List;
import model.dao.VendaDAO;
import model.pojo.Cliente;
import model.pojo.ItemVenda;
import model.pojo.Venda;

public class VendaController {
    private VendaController(){}
    private static VendaController instance = null;
    public static VendaController getInstance(){
        if(instance==null){
            instance = new VendaController();
        }
        return instance;
    }
    
    public boolean createVenda(String nomeCliente, Date dataVenda,
            Double valorTotal, List<ItemVenda> itens){
        boolean r = true;
        Cliente c = ClienteController.getInstance().readClienteByNome(nomeCliente);
        Venda venda = new Venda();
        venda.setDataVenda(dataVenda);
        venda.setCliente(c);
        venda.setValorTotal(valorTotal);
        venda.setItens(itens);
        r = VendaDAO.getInstance().create(venda);
        return r;
    }
}
