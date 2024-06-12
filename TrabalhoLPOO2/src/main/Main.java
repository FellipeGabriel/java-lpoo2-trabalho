package main;

import classes.Veiculo;
import telas.Tela1;
import telas.Tela2;
import telas.Tela3;
import telas.Tela4;
import telas.Tela5;
import componentesMain.EventNavigationBar;
import componentesMain.NavigationBackgroundColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import classes.Cliente;

public class Main extends javax.swing.JFrame {

    public static Veiculo[] veiculos;
    
    public Main() {
        initComponents();
        getContentPane().setBackground(new Color(240, 240, 240));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icones/item1.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icones/item2.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icones/item3.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icones/item4.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icones/item5.png")));
        navigationBar1.addEvent(new EventNavigationBar() {
            @Override
            public void beforeSelected(int index) {
                if (index == 0) {
                    panelTransaction1.display(new Tela1(), navigationBar1.getAnimator());
                } else if (index == 1) {
                    panelTransaction1.display(new Tela2(), navigationBar1.getAnimator());
                } else if (index == 2) {
                    panelTransaction1.display(new Tela3(), navigationBar1.getAnimator());
                } else if (index == 3) {
                    panelTransaction1.display(new Tela4(), navigationBar1.getAnimator());
                } else if (index == 4) {
                    panelTransaction1.display(new Tela5(), navigationBar1.getAnimator());
                }
            }

            @Override
            public void afterSelected(int index) {

            }
        });
        NavigationBackgroundColor nb = new NavigationBackgroundColor();
        nb.apply(getContentPane());
        nb.addColor(0, new Color(153, 153, 255));
        nb.addColor(1, new Color(153, 225, 255));
        nb.addColor(2, new Color(255, 153, 218));
        nb.addColor(3, new Color(126, 209, 132));
        nb.addColor(4, new Color(226, 222, 131));
        navigationBar1.setnavigationBackgroundColor(nb);
    }
    
    public static void addVeiculo(Veiculo veiculo) {
        if (veiculos == null) {
            veiculos = new Veiculo[1];
            veiculos[0] = veiculo;
        } else {
            Veiculo[] newVeiculos = new Veiculo[veiculos.length + 1];
            for (int i = 0; i < veiculos.length; i++) {
                newVeiculos[i] = veiculos[i];
            }
            newVeiculos[veiculos.length] = veiculo;
            veiculos = newVeiculos;
        }
    }

    public static Veiculo[] getVeiculosDisponiveis() {
        if (veiculos != null) {
            Veiculo[] veiculosDisponiveis = new Veiculo[veiculos.length];
            int index = 0;
            for (Veiculo veiculo : veiculos) {
                String estado = veiculo.getEstado().toString();
                if (estado.equals("DISPONÍVEL") || estado.equals("NOVO")) {
                    veiculosDisponiveis[index] = veiculo;
                    index++;
                }
            }
            for (int i = 0; i < veiculosDisponiveis.length; i++) {
                if (veiculosDisponiveis[i] == null) {
                    Veiculo[] newVeiculosDisponiveis = new Veiculo[i];
                    for (int j = 0; j < i; j++) {
                        newVeiculosDisponiveis[j] = veiculosDisponiveis[j];
                    }
                    veiculosDisponiveis = newVeiculosDisponiveis;
                    break;
                }
            }
            return veiculosDisponiveis;
        }
        return null;
    }
    
    public static Veiculo[] getVeiculosLocados() {
        if (veiculos != null) {
            Veiculo[] veiculosLocados = new Veiculo[veiculos.length];
            int index = 0;
            for (Veiculo veiculo : veiculos) {
                String estado = veiculo.getEstado().toString();
                if (estado.equals("LOCADO")) {
                    veiculosLocados[index] = veiculo;
                    index++;
                }
            }
            for (int i = 0; i < veiculosLocados.length; i++) {
                if (veiculosLocados[i] == null) {
                    Veiculo[] newVeiculosLocados = new Veiculo[i];
                    for (int j = 0; j < i; j++) {
                        newVeiculosLocados[j] = veiculosLocados[j];
                    }
                    veiculosLocados = newVeiculosLocados;
                    break;
                }
            }
            return veiculosLocados;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigationBar1 = new componentesMain.NavigationBar();
        panelTransaction1 = new transitions.PanelTransitions();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout navigationBar1Layout = new javax.swing.GroupLayout(navigationBar1);
        navigationBar1.setLayout(navigationBar1Layout);
        navigationBar1Layout.setHorizontalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        navigationBar1Layout.setVerticalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTransaction1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
            .addComponent(navigationBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelTransaction1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(navigationBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        navigationBar1.initSelectedIndex(2);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentesMain.NavigationBar navigationBar1;
    private transitions.PanelTransitions panelTransaction1;
    // End of variables declaration//GEN-END:variables
}
