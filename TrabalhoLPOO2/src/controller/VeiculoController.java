package controller;

import model.dao.VeiculoDaoSql; // Alterei de model.dao.VeiculoDaoSql para dao.VeiculoDaoSql
import model.Veiculo;
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
            Veiculo veiculo = view.getVeiculoForm();
            veiculoDAO.insert(veiculo);
            view.insertVeiculoView(veiculo);
            view.apresentaInfo("Veiculo criado");
        }catch(Exception ex){
            view.apresentaErro("Erro ao criar o veiculo");
        }
        
    }
    
    public void updateVeiculo(){
        try{
            Veiculo veiculo = view.getVeiculoUpdate();
            int operation = view.getNumberOperation();
            if(veiculo==null){
                view.apresentaInfo("Selecione um veiculo");
                return;
            }
            switch(operation){
                case 3:
                    int id = veiculo.getId();
                    double dias = veiculo.getValorDiariaLocacao();
                    veiculo.locar(id, dias); // Adicionei a chamada do método locar
                    break;
                default:
                    return; // Adicionei o ponto e vírgula faltante
            }
            veiculoDAO.update(veiculo);
            view.updateVeiculo(veiculo);
        }catch(Exception ex){
            view.apresentaErro("Erro ao atualizar veiculo");
        }
    }
}
