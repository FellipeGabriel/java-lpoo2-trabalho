/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.VeiculoDaoSql;
import telas.Tela2;

/**
 *
 * @author janai
 */
public class VeiculoController {
    private Tela2 view;
    private VeiculoDaoSql veiculoDAO;
    
    public VeiculoController(Tela2 view, VeiculoDaoSql veiculoDAO){
        this.view = view;
        this.veiculoDAO = veiculoDAO;
        initController();
    }
    
    public void initController(){
        this.view.setControllerVeiculo(this);
        this.view.initView();
    }
    
    public void createVeiculo(){
        try{
            Veiculo veiculo = view.getVeiucloForm();
            veiculoDAO.insert(veiculo);
            view.insertVeiculoView(veiculo);
            view.apresentaInfo("Veiculo criado");
        }catch(Exception ex){
            view.apresentaErro("Erro ao criar o veiculo");
        }
    }
    
}
