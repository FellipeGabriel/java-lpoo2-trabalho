package controller;

import model.dao.VeiculoDaoSql; // Alterei de model.dao.VeiculoDaoSql para dao.VeiculoDaoSql
import model.Veiculo;
import telas.Tela2;

import telas.Tela4;//
import classes.VeiculoC;
import main.Main;

/**
 *
 * @author janai
 */
public class VeiculoController {
    private Tela2 view;
    private VeiculoDaoSql veiculoDAO;
    private Tela4 view4;//Novo
    
    public VeiculoController(Tela2 view, VeiculoDaoSql veiculoDAO){
        this.view = view;
        this.veiculoDAO = veiculoDAO;
        initController();
    }

    public VeiculoController(Tela4 view4){
        //Novo
        this.view4 = view4;
        initControllerTela4();
    }

    public void initController(){
        this.view.setControllerVeiculo(this);
        this.view.initView();
    }
    
    public void initControllerTela4() {
        //Novo
        this.view4.setControllerVeiculo(this);
        this.view4.initView();
    }
    
    public void createVeiculo(){
        try{ //escreve de forma para capturar o erro ou veicul criado/ajanaina
            Veiculo veiculo = view.getVeiculoForm();
            veiculoDAO.insert(veiculo);
            //view.insertVeiculoView(veiculo);
            view.apresentaInfo("Veiculo criado");
            //chama funçãona tela2 limpa coisa
        }catch(Exception ex){
            view.apresentaErro("Erro ao criar o veiculo");
        }
    }
    // Métodos para Tela4
    public void atualizarTabela() {
        view4.fillTable(Main.getVeiculosLocados());
    }

    public void devolverVeiculo(String placa) {
        VeiculoC veiculoParaDevolver = encontrarVeiculoPorPlaca(placa);
        if (veiculoParaDevolver != null) {
            veiculoParaDevolver.devolver();
            atualizarTabela(); // Atualiza a tabela após a devolução
        } else {
            view.apresentaErro("Veículo não encontrado.");
        }
    }

    private VeiculoC encontrarVeiculoPorPlaca(String placa) {
        for (VeiculoC veiculo : Main.getVeiculosLocados()) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    /*public void updateVeiculo(){
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
    }*/
    /*public void showVeiculo(){
        try{
            List<Veiculo> lista = this.veiculoDAO.getAll();
            view.showListVeiculo(lista);
        }catch(Exception ex){
            ex.printStackTrace();
            view.apresentaErro("Erro ao mostrar cliente no showcliente");
        }
    }*/
}
