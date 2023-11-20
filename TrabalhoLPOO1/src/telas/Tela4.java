/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Automovel;
import classes.Motocicleta;
import classes.Van;
import classes.Veiculo;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.Main;
import transitions.TransitionsForm;

/**
 *
 * @author RAVEN
 */
public class Tela4 extends TransitionsForm {

    /**
     * Creates new form Form
     */
    public Tela4() {
        initComponents();
        fillTable(Main.getVeiculosLocados());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DevolverTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DevolverButton = new javax.swing.JButton();
        AtualizarDevolverButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 79, 79));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Devolver Veículos");

        DevolverTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome do Cliente", "Placa", "Marca", "Modelo", "Ano", "Data Locação", "Preço Diária", "Qtd. de Dias Locados", "Valor Locação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DevolverTable);

        jLabel2.setText("Veículos locados:");

        jLabel3.setText("Selecione o veículo que deseja devolver na tabela acima e clique no botão abaixo:");

        DevolverButton.setText("Devolver Veículo");
        DevolverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DevolverButtonActionPerformed(evt);
            }
        });

        AtualizarDevolverButton.setText("Atualizar Tabela");
        AtualizarDevolverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarDevolverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(AtualizarDevolverButton)
                                    .addGap(355, 355, 355))
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DevolverButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DevolverButton)
                    .addComponent(AtualizarDevolverButton))
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AtualizarDevolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarDevolverButtonActionPerformed
        this.fillTable(Main.getVeiculosLocados());
    }//GEN-LAST:event_AtualizarDevolverButtonActionPerformed

    private void DevolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolverButtonActionPerformed
        int selectedRow = DevolverTable.getSelectedRow();
        if (selectedRow != -1) {
            int resposta = JOptionPane.showConfirmDialog(Tela4.this,
                    "Tem certeza que deseja devolver este veículo?", "Confirmar devolução",
                    JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                String placa = (String) DevolverTable.getValueAt(selectedRow, 1);

                Veiculo veiculoParaDevolver = encontrarVeiculoPorPlaca(placa);

                veiculoParaDevolver.devolver();
                this.fillTable(Main.getVeiculosDisponiveis());

            }
        } else {
            JOptionPane.showMessageDialog(Tela4.this, "Selecione um veículo para devolver.",
                    "Nenhum veículo selecionado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DevolverButtonActionPerformed

    private Veiculo encontrarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : Main.getVeiculosLocados()) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
}

public void fillTable(Veiculo[] veiculos) {
    DefaultTableModel model = (DefaultTableModel) DevolverTable.getModel();
    model.setRowCount(0);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    if (veiculos != null) {

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        for (Veiculo veiculo : veiculos) {
            
            if (veiculo != null && veiculo.getLocacao() != null) {
                
                String modelo = "";
                double precoVenda = 0;

                if (veiculo instanceof Automovel) {
                    modelo = ((Automovel) veiculo).getModelo().toString();
                    precoVenda = veiculo.getValorParaVenda();
                } else if (veiculo instanceof Van) {
                    modelo = ((Van) veiculo).getModelo().toString();
                    precoVenda = veiculo.getValorParaVenda();
                } else if (veiculo instanceof Motocicleta) {
                    modelo = ((Motocicleta) veiculo).getModelo().toString();
                    precoVenda = veiculo.getValorParaVenda();
                }

                Object[] rowData = {
                    veiculo.getLocacao().getCliente().getName(),
                    veiculo.getPlaca(),
                    veiculo.getMarca().toString(),
                    modelo,
                    veiculo.getAno(),
                    dateFormat.format(veiculo.getLocacao().getData().getTime()),
                    currencyFormat.format(veiculo.getValorDiariaLocacao()),
                    veiculo.getLocacao().getDias(),
                    currencyFormat.format(precoVenda)
                };

                model.addRow(rowData);
            }
        }
    }
}

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarDevolverButton;
    private javax.swing.JButton DevolverButton;
    private javax.swing.JTable DevolverTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
