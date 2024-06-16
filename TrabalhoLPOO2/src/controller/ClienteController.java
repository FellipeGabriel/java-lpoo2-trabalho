/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author janai
 */

import model.Cliente;
import telas.Tela1;
import dao.ClienteDaoSql;


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
            if(cliente==null){
                view.apresentaInfo("Selecione um cliente para atualizar");
                return;
            }
            clienteDAO.update(cliente);
            view.updateCliente(cliente);
        }catch(Exception ex){
            view.apresentaErro("Erro ao atualizar cliente");
        }
    }
    
    public void showCliente(){
        try{
            view.clearUpdateCliente();
            List<Cliente> lista= this.clienteDAO.getAll();
            view.showListCliente(lista);
        }catch(Exception ex){
            ex.printStackTrace();
            view.apresentaErro(erro);
        }
    }
    public void deleteCliente(){
        try{
            List<Cliente> listDelete = view.getClienteDelete();
            clienteDAO.delete(listDelete);
            view.deleteClienteView(listDelete);
        }catch(Exception ex){
            view.apresentaErro("Erro ao excluir o cliente");
        }
    }
}
