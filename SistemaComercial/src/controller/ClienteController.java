package controller;

import java.util.Date;
import java.util.List;
import model.dao.ClienteDAO;
import model.pojo.Cliente;

public class ClienteController {
    //Inicio singleton
    private ClienteController(){}
    
    private static ClienteController instance = null;
    
    public static ClienteController getInstance(){
        if(instance==null){
            instance = new ClienteController();
        }
        return instance;
    }
    //Fim singleton

    public boolean createCliente(String nome, String cpf,
        String email, Date dataNascimento){
        boolean r = true;
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setEmail(email);
        c.setNascimento(dataNascimento);
        r = ClienteDAO.getInstance().create(c);
        return r;
    }
    
    public List<Cliente> readAllClientes(){
        return ClienteDAO.getInstance().readAll();
    }
    
    public boolean deleteClienteById(Long id){
        return ClienteDAO.getInstance().deleteById(id);
    }
    
    public boolean deleteAllClientes(){
        return ClienteDAO.getInstance().deleteAll();
    }
    public Cliente readClienteById(Long id){
        Cliente cliente = ClienteDAO.getInstance().readById(id);
        return cliente;
    }
    
    public boolean updateClienteById(Long id, String nome,
            String cpf, Date nascimento,String email){
        boolean resultado = true;
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        c.setCpf(cpf);
        c.setNascimento(nascimento);
        c.setEmail(email);
        resultado = ClienteDAO.getInstance().updateById(c);
        
        return resultado;
    }    
    
    public Cliente readClienteByNome(String nome){
        return ClienteDAO.getInstance().readByNome(nome);
    }    
}
