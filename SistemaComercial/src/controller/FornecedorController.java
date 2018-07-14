package controller;

import java.util.List;
import model.dao.FornecedorDAO;
import model.pojo.Fornecedor;

public class FornecedorController {
    //Inicio singleton
    private FornecedorController(){}
    
    private static FornecedorController instance = null;
    
    public static FornecedorController getInstance(){
        if(instance==null){
            instance = new FornecedorController();
        }
        return instance;
    }
    //Fim singleton
    
    //Metodo para criar um fornecedor
    public boolean createFornecedor(String nome, String cnpj,
            String telefone,String email, String inscricaoEstadual){
        boolean r = true;
        
        Fornecedor f = new Fornecedor();
        
        f.setNome(nome);
        f.setCnpj(cnpj);
        f.setTelefone(telefone);
        f.setEmail(email);
        f.setInscricaoEstadual(inscricaoEstadual);
        
        r = FornecedorDAO.getInstance().create(f);
        
        return r;
    }
    //fim createFornecedor
    
    public List<Fornecedor> readAllFornecedores(){
        return FornecedorDAO.getInstance().readAll();
    }
    
    public boolean deleteFornecedorById(Long id){
        return FornecedorDAO.getInstance().deleteById(id);
    }
    
    public boolean deleteAllFornecedores(){
        return FornecedorDAO.getInstance().deleteAll();
    }
    
    public Fornecedor readFornecedorById(Long id){
        Fornecedor fornecedor = FornecedorDAO.getInstance().readById(id);
        return fornecedor;
    }
    
    public boolean updateFornecedorById(Long id, String nome,
            String cnpj,String inscEstadual,String email,
            String telefone){
        boolean resultado = true;
        Fornecedor f = new Fornecedor();
        f.setId(id);
        f.setNome(nome);
        f.setCnpj(cnpj);
        f.setInscricaoEstadual(inscEstadual);
        f.setEmail(email);
        f.setTelefone(telefone);
        
        resultado = FornecedorDAO.getInstance().updateById(f);
        
        return resultado;
    }
    
    public Fornecedor readFornecedorByNome(String nome){
        return FornecedorDAO.getInstance().readByNome(nome);
    }
    
}
