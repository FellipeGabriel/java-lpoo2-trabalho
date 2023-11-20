
package telas;

import classes.Veiculo;
import classes.Automovel;
import classes.Motocicleta;
import classes.Van;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import java.text.NumberFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.Main;
import transitions.TransitionsForm;

/**
 *
 * @author RAVEN
 */
public class Tela5 extends TransitionsForm {
private String[] marca,  categoria;
    /**
     * Creates new form Form
     */
    public Tela5() {
        initComponents();
        optionsComboBoxes();
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

        radioButtons = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        marcaSelect = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        categoriaSelect = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        automovelRB1 = new javax.swing.JRadioButton();
        motocicletaRB2 = new javax.swing.JRadioButton();
        vanRB3 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCarSale = new javax.swing.JTable();
        bSale = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 79, 79));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vender Veículos");

        marcaSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        marcaSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaSelectActionPerformed(evt);
            }
        });

        jLabel6.setText("Marca:");

        categoriaSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoriaSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaSelectActionPerformed(evt);
            }
        });

        jLabel7.setText("Categoria:");

        jLabel3.setText("Tipo:");

        radioButtons.add(automovelRB1);
        automovelRB1.setText("Automóvel");
        automovelRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automovelRB1ActionPerformed(evt);
            }
        });

        radioButtons.add(motocicletaRB2);
        motocicletaRB2.setText("Motocicleta");
        motocicletaRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motocicletaRB2ActionPerformed(evt);
            }
        });

        radioButtons.add(vanRB3);
        vanRB3.setText("Van");
        vanRB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vanRB3ActionPerformed(evt);
            }
        });

        tableCarSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Placa", "Marca", "Modelo", "Ano", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCarSale);

        bSale.setText("Vender");

        bUpdate.setText("Atualizar");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(automovelRB1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(motocicletaRB2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vanRB3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(categoriaSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(marcaSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(bSale)
                        .addGap(66, 66, 66)
                        .addComponent(bUpdate)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(automovelRB1)
                    .addComponent(motocicletaRB2)
                    .addComponent(vanRB3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(marcaSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSale)
                    .addComponent(bUpdate))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void marcaSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaSelectActionPerformed
        // MARCA
    }//GEN-LAST:event_marcaSelectActionPerformed

    private void categoriaSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaSelectActionPerformed

    }//GEN-LAST:event_categoriaSelectActionPerformed

    private void automovelRB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automovelRB1ActionPerformed

    }//GEN-LAST:event_automovelRB1ActionPerformed

    private void motocicletaRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motocicletaRB2ActionPerformed

    }//GEN-LAST:event_motocicletaRB2ActionPerformed

    private void vanRB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanRB3ActionPerformed

    }//GEN-LAST:event_vanRB3ActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        //Verifica se pelo menos um está preenchido
        if (!automovelRB1.isSelected() && !motocicletaRB2.isSelected() && !vanRB3.isSelected() && marcaSelect.getSelectedItem()=="Selecionar" && categoriaSelect.getSelectedItem()=="Selecionar") {
            JOptionPane.showMessageDialog(this,"Pelo menos um dos campos de ve ser preenchido" , "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Veiculo[] veiculos = Main.veiculos;
        Veiculo[] veiculosFiltrados = null;
        
        String marcaSelecionada = marcaSelect.getSelectedItem().toString();
        String categoriaSelecionada = categoriaSelect.getSelectedItem().toString();
        
        if (veiculos != null && veiculos.length > 0) {
            for (Veiculo veiculo : veiculos) {
                if (veiculo != null && veiculo.getEstado().equals(Estado.DISPONÍVEL) || veiculo.getEstado().equals(Estado.NOVO)) {
                    if (automovelRB1.isSelected() && veiculo instanceof Automovel) {
                        if (marcaSelecionada.equals("Selecionar") && categoriaSelecionada.equals("Selecionar")) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (marcaSelecionada.equals("Selecionar") && veiculo.getCategoria().toString().equals(categoriaSelecionada)) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (veiculo.getMarca().toString().equals(marcaSelecionada) && categoriaSelecionada.equals("Selecionar")) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (veiculo.getMarca().toString().equals(marcaSelecionada) && veiculo.getCategoria().toString().equals(categoriaSelecionada)) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        }
                    } else if (motocicletaRB2.isSelected() && veiculo instanceof Motocicleta) {
                        if (marcaSelecionada.equals("Selecionar") && categoriaSelecionada.equals("Selecionar")) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (marcaSelecionada.equals("Selecionar") && veiculo.getCategoria().toString().equals(categoriaSelecionada)) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (veiculo.getMarca().toString().equals(marcaSelecionada) && categoriaSelecionada.equals("Selecionar")) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (veiculo.getMarca().toString().equals(marcaSelecionada) && veiculo.getCategoria().toString().equals(categoriaSelecionada)) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        }
                    } else if (vanRB3.isSelected() && veiculo instanceof Van) {
                        if (marcaSelecionada.equals("Selecionar") && categoriaSelecionada.equals("Selecionar")) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (marcaSelecionada.equals("Selecionar") && veiculo.getCategoria().toString().equals(categoriaSelecionada)) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (veiculo.getMarca().toString().equals(marcaSelecionada) && categoriaSelecionada.equals("Selecionar")) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        } else if (veiculo.getMarca().toString().equals(marcaSelecionada) && veiculo.getCategoria().toString().equals(categoriaSelecionada)) {
                            if (veiculosFiltrados == null) {
                                veiculosFiltrados = new Veiculo[1];
                                veiculosFiltrados[0] = veiculo;
                            } else {
                                Veiculo[] newVeiculosFiltrados = veiculosFiltrados;
                                veiculosFiltrados = new Veiculo[veiculosFiltrados.length + 1];
                                for (int i = 0; i < newVeiculosFiltrados.length; i++) {
                                    veiculosFiltrados[i] = newVeiculosFiltrados[i];
                                }
                                veiculosFiltrados[veiculosFiltrados.length - 1] = veiculo;
                            }
                        }
                    }
                }
            }
            if (veiculosFiltrados != null) {
                JOptionPane.showMessageDialog(this, "Veículo(s) encontrado(s)!",
                        "Ação Valida", JOptionPane.INFORMATION_MESSAGE);
                fillTable(veiculosFiltrados);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum veículo encontrado.",
                        "Ação Valida", JOptionPane.INFORMATION_MESSAGE);
            }
        }                                
        fillTable(veiculosFiltrados);
    }//GEN-LAST:event_bUpdateActionPerformed
    
    public void fillTable(Veiculo[] veiculos) {
    DefaultTableModel model = (DefaultTableModel) tableCarSale.getModel();
    model.setRowCount(0);

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
                    veiculo.getPlaca(),
                    veiculo.getMarca().toString(),
                    modelo,
                    veiculo.getAno(),
                    currencyFormat.format(precoVenda)
                };

                model.addRow(rowData);
            }
        }
    }
}
    private void optionsComboBoxes() {
     // Limpa os treco tudo
    marcaSelect.removeAllItems();
    categoriaSelect.removeAllItems();
    
    // Opção "Neutra"
    marcaSelect.addItem("Selecionar");
    categoriaSelect.addItem("Selecionar");
    
    // Obtendo os valores dos enums
    Marca[] marcasDisponiveis = Marca.values();
    Categoria[] categoriasDisponiveis = Categoria.values();
    
    // Iterando e preenchendo o ComboBox marcaSelect
    for (Marca marca : marcasDisponiveis) {
        marcaSelect.addItem(marca.toString());
    }

    // Iterando e preenchendo o ComboBox categoriaSelect
    for (Categoria categoria : categoriasDisponiveis) {
        categoriaSelect.addItem(categoria.toString());
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton automovelRB1;
    private javax.swing.JButton bSale;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> categoriaSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> marcaSelect;
    private javax.swing.JRadioButton motocicletaRB2;
    private javax.swing.ButtonGroup radioButtons;
    private javax.swing.JTable tableCarSale;
    private javax.swing.JRadioButton vanRB3;
    // End of variables declaration//GEN-END:variables
}