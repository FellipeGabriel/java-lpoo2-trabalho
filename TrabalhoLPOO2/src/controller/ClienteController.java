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
/*    
    public void createCliente(){
        try{
            Cliente cliente = view.getClienteForm();
            clienteDAO.insert(cliente);
            view.insertClienteView(cliente);
            view.apresentaInfo("Cliente criado");
        }catch(Exception ex){
            view.apresentaErro("Erro ao criar cliente");
        }
    }
    
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
            System.out.println("Entrei no show: "+lista.size());
            // Imprime os clientes recuperados do banco de dados
        for (Cliente cliente : lista) {
            System.out.println("Cliente ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Sobrenome: " + cliente.getSobrenome());
            System.out.println("RG: " + cliente.getRg());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("-------------------------");
        }
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
