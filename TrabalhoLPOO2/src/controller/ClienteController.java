package controller;

import model.Cliente;
import telas.Tela1;
import model.dao.ClienteDaoSql; 

import java.util.List; 
import javax.swing.JOptionPane;

/**
 *
 * @author janai
 */

public class ClienteController {
    private Tela1 view; 
    private ClienteDaoSql clienteDAO;
    
    public ClienteController(Tela1 view, ClienteDaoSql clienteDAO){
        this.view = view;
        this.clienteDAO = clienteDAO;
        initController();
    }
    
    private void initController(){
        this.view.setControllerCliente(this);
        this.view.initView();
    }
   
    public void createCliente(){
        try{
            Cliente cliente = view.getForm();
            clienteDAO.insert(cliente);
            view.carregarClientes();
            view.apresentaInfo("Cliente criado");
        }catch(Exception ex){
            view.apresentaErro("Erro ao criar cliente");
        }
    }
/*     
    public void updateCliente(){
        try{
            Cliente cliente = view.getClienteUpdate();
            if(cliente == null){
                view.apresentaInfo("Selecione um cliente para atualizar");
                return;
            }
            clienteDAO.update(cliente);
            view.updateCliente(cliente);
        }catch(Exception ex){
            view.apresentaErro("Erro ao atualizar cliente");
        }
    }
    */
    public void showCliente(){
        try{
            List<Cliente> lista = this.clienteDAO.getAll();
            view.showListCliente(lista);
        }catch(Exception ex){
            ex.printStackTrace();
            view.apresentaErro("Erro ao mostrar cliente no showcliente");
        }
    }
    /*
    public void deleteCliente(){
        try{
            List<Cliente> listDelete = view.getClienteDelete();
            clienteDAO.delete(listDelete);
            view.deleteClienteView(listDelete);
        }catch(Exception ex){
            view.apresentaErro("Erro ao excluir o cliente");
        }
    }*/
}
    
