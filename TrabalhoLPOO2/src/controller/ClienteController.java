package controller;

import model.Cliente;
import telas.Tela1;
import model.dao.ClienteDaoSql; 
import java.sql.SQLException;

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
            view.limpaForm();
            view.apresentaInfo("Cliente criado");
        }catch(Exception ex){
            view.apresentaErro("Erro ao criar cliente");
        }
    }
    
    public void updateCliente(Cliente cliente){
        try{
            if(cliente == null){
                view.apresentaInfo("Selecione um cliente para atualizar");
                return;
            }
            clienteDAO.update(cliente);
            view.carregarClientes();
        }catch(Exception ex){
            view.apresentaErro("Erro ao atualizar cliente");
        }
    }
    
    public void showCliente(){
        try{
            List<Cliente> lista = this.clienteDAO.getAll();
            view.showListCliente(lista);
        }catch(Exception ex){
            ex.printStackTrace();
            view.apresentaErro("Erro ao mostrar cliente no showcliente");
        }
    }
    
    public void deleteCliente(int id){
        try{
            clienteDAO.delete(id);
            view.carregarClientes();
        }catch (SQLException ex) {
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente: O mesmo possui locações ativas", "Erro ao excluir cliente", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace(); 
        JOptionPane.showMessageDialog(null, "Erro inesperado ao excluir o cliente.", "Erro ao excluir cliente", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void searchClienteId(int id){
        try{
            Cliente cliente = clienteDAO.get(id);
            if(cliente == null){
                view.apresentaErro("cliente não encontrado");
                return;
            }
            view.deleteClienteView(cliente);
        }catch(Exception ex){
            view.apresentaErro("Erro ao buscar cliente "+ex.getMessage());
        }
    }
}