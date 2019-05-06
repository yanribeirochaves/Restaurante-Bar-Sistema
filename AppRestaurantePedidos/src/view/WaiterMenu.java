package view;

import controller.ControllerWaiterMenu;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 * @author yanri
 */
public class WaiterMenu extends javax.swing.JFrame {

    /**
     * Creates new form MenuGarçom
     */
    private final ControllerWaiterMenu controller;
    
    public WaiterMenu() {
        initComponents();
        controller = new ControllerWaiterMenu(this);
        controller.updateAvailableTableComboBox();
        controller.updateOccupiedTableComboBox();
        controller.updateTablesTbl();
        controller.updateOrderTbl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusOrderFilterRadioButtonGroup = new javax.swing.ButtonGroup();
        tabPanelWaiter = new javax.swing.JTabbedPane();
        panelStartedTable = new javax.swing.JPanel();
        btnReadyTableToUse = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblKey = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        comboBoxAvailableTable = new javax.swing.JComboBox<>();
        lblTableNumber = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnHelp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        panelOrder = new javax.swing.JPanel();
        lblTextInfo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        radioPendingOrder = new javax.swing.JRadioButton();
        radioDeliveredOrder = new javax.swing.JRadioButton();
        radioAllOrder = new javax.swing.JRadioButton();
        comboBoxOccupiedTable = new javax.swing.JComboBox<>();
        lblTextFilter = new javax.swing.JLabel();
        btnServeOrder = new javax.swing.JButton();
        btnCancelOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblObservationText = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservation = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(550, 200));

        btnReadyTableToUse.setText("Liberar mesa");
        btnReadyTableToUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadyTableToUseActionPerformed(evt);
            }
        });

        lblUsername.setText("Username:");

        lblKey.setText("Senha:");

        comboBoxAvailableTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma mesa" }));
        comboBoxAvailableTable.setMaximumSize(new java.awt.Dimension(28, 20));

        lblTableNumber.setText("N° mesa:");

        btnHelp.setText("?");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MESA", "STATUS DA MESA", "STATUS DE PEDIDO"
            }
        ));
        jScrollPane1.setViewportView(tblTable);

        javax.swing.GroupLayout panelStartedTableLayout = new javax.swing.GroupLayout(panelStartedTable);
        panelStartedTable.setLayout(panelStartedTableLayout);
        panelStartedTableLayout.setHorizontalGroup(
            panelStartedTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStartedTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStartedTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addGroup(panelStartedTableLayout.createSequentialGroup()
                        .addGroup(panelStartedTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelStartedTableLayout.createSequentialGroup()
                                .addComponent(lblTableNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxAvailableTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelStartedTableLayout.createSequentialGroup()
                                .addComponent(lblUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername)))
                        .addGap(18, 18, 18)
                        .addComponent(lblKey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelStartedTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReadyTableToUse, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(txtKey))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStartedTableLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnHelp))
        );
        panelStartedTableLayout.setVerticalGroup(
            panelStartedTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStartedTableLayout.createSequentialGroup()
                .addComponent(btnHelp)
                .addGap(9, 9, 9)
                .addGroup(panelStartedTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername)
                    .addComponent(lblKey)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelStartedTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxAvailableTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTableNumber)
                    .addComponent(btnReadyTableToUse))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        tabPanelWaiter.addTab("Liberar mesa para cliente", panelStartedTable);

        lblTextInfo.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        lblTextInfo.setText("Tabela de pedidos");

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MESA", "PEDIDO", "QUANT.", "OBS.", "STATUS"
            }
        ));
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrder);

        statusOrderFilterRadioButtonGroup.add(radioPendingOrder);
        radioPendingOrder.setSelected(true);
        radioPendingOrder.setText("Pedidos na fila");
        radioPendingOrder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioPendingOrderStateChanged(evt);
            }
        });
        radioPendingOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioPendingOrderMouseClicked(evt);
            }
        });

        statusOrderFilterRadioButtonGroup.add(radioDeliveredOrder);
        radioDeliveredOrder.setText("Pedidos entregues");
        radioDeliveredOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioDeliveredOrderMouseClicked(evt);
            }
        });
        radioDeliveredOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDeliveredOrderActionPerformed(evt);
            }
        });

        statusOrderFilterRadioButtonGroup.add(radioAllOrder);
        radioAllOrder.setText("Todos");
        radioAllOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioAllOrderMouseClicked(evt);
            }
        });
        radioAllOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAllOrderActionPerformed(evt);
            }
        });

        comboBoxOccupiedTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma mesa" }));
        comboBoxOccupiedTable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxOccupiedTableItemStateChanged(evt);
            }
        });

        lblTextFilter.setText("Filtrar por número da mesa:");

        btnServeOrder.setText("Entregar pedido");
        btnServeOrder.setEnabled(false);

        btnCancelOrder.setText("Cancelar pedido");
        btnCancelOrder.setEnabled(false);

        jLabel1.setText("Filtrar por status dos pedidos:");

        lblObservationText.setText("Observação do pedido:");

        txtObservation.setEditable(false);
        txtObservation.setColumns(20);
        txtObservation.setRows(5);
        jScrollPane3.setViewportView(txtObservation);

        javax.swing.GroupLayout panelOrderLayout = new javax.swing.GroupLayout(panelOrder);
        panelOrder.setLayout(panelOrderLayout);
        panelOrderLayout.setHorizontalGroup(
            panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOrderLayout.createSequentialGroup()
                        .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTextInfo)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6)
                        .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelOrderLayout.createSequentialGroup()
                                .addComponent(radioPendingOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioDeliveredOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioAllOrder)
                                .addGap(156, 156, 156))
                            .addGroup(panelOrderLayout.createSequentialGroup()
                                .addComponent(lblTextFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxOccupiedTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelOrderLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOrderLayout.createSequentialGroup()
                        .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelOrderLayout.createSequentialGroup()
                                .addComponent(lblObservationText)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(166, 166, 166))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnServeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
        );
        panelOrderLayout.setVerticalGroup(
            panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextInfo)
                    .addComponent(comboBoxOccupiedTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTextFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPendingOrder)
                    .addComponent(radioDeliveredOrder)
                    .addComponent(radioAllOrder)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblObservationText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnServeOrder)
                    .addComponent(btnCancelOrder))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabPanelWaiter.addTab("Pedidos dos clientes", panelOrder);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanelWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanelWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        controller.helpUseScreenTables();
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnReadyTableToUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadyTableToUseActionPerformed
        controller.readyTableToUse();
    }//GEN-LAST:event_btnReadyTableToUseActionPerformed

    private void radioDeliveredOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDeliveredOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDeliveredOrderActionPerformed

    private void radioAllOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAllOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAllOrderActionPerformed

    private void radioPendingOrderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioPendingOrderStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPendingOrderStateChanged

    private void radioPendingOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioPendingOrderMouseClicked
        controller.updateOrderTbl();
    }//GEN-LAST:event_radioPendingOrderMouseClicked

    private void radioDeliveredOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioDeliveredOrderMouseClicked
        controller.updateOrderTbl();
    }//GEN-LAST:event_radioDeliveredOrderMouseClicked

    private void radioAllOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioAllOrderMouseClicked
        controller.updateOrderTbl();
    }//GEN-LAST:event_radioAllOrderMouseClicked

    private void comboBoxOccupiedTableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxOccupiedTableItemStateChanged
        controller.updateOrderTbl();
    }//GEN-LAST:event_comboBoxOccupiedTableItemStateChanged

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        controller.selectItemTableOrder();
    }//GEN-LAST:event_tblOrderMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WaiterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaiterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaiterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaiterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WaiterMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnReadyTableToUse;
    private javax.swing.JButton btnServeOrder;
    private javax.swing.JComboBox<String> comboBoxAvailableTable;
    private javax.swing.JComboBox<String> comboBoxOccupiedTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblKey;
    private javax.swing.JLabel lblObservationText;
    private javax.swing.JLabel lblTableNumber;
    private javax.swing.JLabel lblTextFilter;
    private javax.swing.JLabel lblTextInfo;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelOrder;
    private javax.swing.JPanel panelStartedTable;
    private javax.swing.JRadioButton radioAllOrder;
    private javax.swing.JRadioButton radioDeliveredOrder;
    private javax.swing.JRadioButton radioPendingOrder;
    private javax.swing.ButtonGroup statusOrderFilterRadioButtonGroup;
    private javax.swing.JTabbedPane tabPanelWaiter;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextArea txtObservation;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    //getter e setter dos componentes da view, para chamar no controlador
    public JComboBox<String> getComboBoxAvailableTable() {
        return comboBoxAvailableTable;
    }

    public javax.swing.JTextField getTxtKey() {
        return txtKey;
    }

    public javax.swing.JTextField getTxtUsername() {
        return txtUsername;
    }

    public JTable getTblTable() {
        return tblTable;
    }
    
    public JTable getTblOrder() {
        return tblOrder;
    }

    public JComboBox<String> getComboBoxOccupiedTable() {
        return comboBoxOccupiedTable;
    }


    public javax.swing.JRadioButton getRadioDeliveredOrder() {
        return radioDeliveredOrder;
    }

    public javax.swing.JRadioButton getRadioPendingOrder() {
        return radioPendingOrder;
    }

    public javax.swing.JRadioButton getRadioAllOrder() {
        return radioAllOrder;
    }

    public JTextArea getTxtObservation() {
        return txtObservation;
    }

    public JButton getBtnServeOrder() {
        return btnServeOrder;
    }

    public JButton getBtnCancelOrder() {
        return btnCancelOrder;
    }    
}
