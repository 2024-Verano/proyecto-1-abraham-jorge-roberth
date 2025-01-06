/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.tiendaciclismo;

/**
 *
 * @author jorge
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class VentanaCliente extends javax.swing.JFrame {
    
    private RegistroCliente registroCliente;
    
    /**
     * Creates new form VentanaCliente
     */
    public VentanaCliente() {
        initComponents();
        registroCliente = new RegistroCliente();
        cargarProvincias();
    }

    private void cargarProvincias() {
        for (String provincia : Cliente.PROVINCIAS_CANTONES_DISTRITOS.keySet()) {
            cbxProvincia.addItem(provincia);
        }
    }

    private void cargarCantones() {
        cbxCanton.removeAllItems();
        cbxDistrito.removeAllItems();

        Object provinciaSeleccionada = cbxProvincia.getSelectedItem();
        if (provinciaSeleccionada != null) {
            for (String canton : Cliente.PROVINCIAS_CANTONES_DISTRITOS.get(provinciaSeleccionada.toString()).keySet()) {
                cbxCanton.addItem(canton);
            }
        }
    }

    private void cargarDistritos() {
        cbxDistrito.removeAllItems();
        Object provinciaSeleccionada = cbxProvincia.getSelectedItem();
        Object cantonSeleccionado = cbxCanton.getSelectedItem();
        if (provinciaSeleccionada != null && cantonSeleccionado != null) {
            for (String distrito : Cliente.PROVINCIAS_CANTONES_DISTRITOS.get(provinciaSeleccionada.toString()).get(cantonSeleccionado.toString())) {
                cbxDistrito.addItem(distrito);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btnModificar = new javax.swing.JButton();
                btnBuscarCliente = new javax.swing.JButton();
                btnAgregarCliente = new javax.swing.JButton();
                btnEliminarCliente = new javax.swing.JButton();
                jLabel9 = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                txtCodigo = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                txtApellidos = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                txtTelefono = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                txtCorreo = new javax.swing.JTextField();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                txtFechaNacimiento = new javax.swing.JTextField();
                txtNombre = new javax.swing.JTextField();
                Limpiar = new javax.swing.JButton();
                cbxProvincia = new javax.swing.JComboBox<>();
                cbxCanton = new javax.swing.JComboBox<>();
                cbxDistrito = new javax.swing.JComboBox<>();
                jLabel10 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                btnModificar.setText("Modificar");
                btnModificar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnModificarActionPerformed(evt);
                        }
                });

                btnBuscarCliente.setText("Buscar");
                btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBuscarClienteActionPerformed(evt);
                        }
                });

                btnAgregarCliente.setText("Agregar");
                btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAgregarClienteActionPerformed(evt);
                        }
                });

                btnEliminarCliente.setText("Eliminar");
                btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEliminarClienteActionPerformed(evt);
                        }
                });

                jLabel9.setText("Fecha de Nacimiento (AAAA-MM-DD)");

                jLabel1.setText("Código");

                txtCodigo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtCodigoActionPerformed(evt);
                        }
                });

                jLabel2.setText("Apellidos");

                txtApellidos.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtApellidosActionPerformed(evt);
                        }
                });

                jLabel3.setText("Nombre");

                txtTelefono.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtTelefonoActionPerformed(evt);
                        }
                });

                jLabel4.setText("Telefono");

                txtCorreo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtCorreoActionPerformed(evt);
                        }
                });

                jLabel5.setText("Email");

                jLabel6.setText("Provincia");

                jLabel7.setText("Cantón");

                jLabel8.setText("Distrito");

                txtFechaNacimiento.setToolTipText("");
                txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtFechaNacimientoActionPerformed(evt);
                        }
                });

                txtNombre.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtNombreActionPerformed(evt);
                        }
                });

                Limpiar.setText("Limpiar");
                Limpiar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                LimpiarActionPerformed(evt);
                        }
                });

                cbxProvincia.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cbxProvinciaActionPerformed(evt);
                        }
                });

                cbxCanton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cbxCantonActionPerformed(evt);
                        }
                });

                jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel10.setText("Menú Clientes");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGap(190, 190, 190))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(cbxDistrito, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(cbxCanton, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(cbxProvincia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, Short.MAX_VALUE)))))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addGap(220, 220, 220))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnEliminarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnAgregarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(Limpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnAgregarCliente)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(41, 41, 41)
                                                                .addComponent(btnBuscarCliente)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEliminarCliente)))
                                                .addGap(21, 21, 21)
                                                .addComponent(btnModificar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Limpiar))
                                .addContainerGap(39, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            long codigo = Long.parseLong(txtCodigo.getText());
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String telefono = txtTelefono.getText();
            String correo = txtCorreo.getText();
            String provincia = cbxProvincia.getSelectedItem().toString();
            String canton = cbxCanton.getSelectedItem().toString();
            String distrito = cbxDistrito.getSelectedItem().toString();
            LocalDate fechaNacimiento = LocalDate.parse(txtFechaNacimiento.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            registroCliente.modificarCliente(codigo, nombre, apellidos, telefono, correo, provincia, canton, distrito, fechaNacimiento);
            JOptionPane.showMessageDialog(this, "Cliente modificado con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar cliente: " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        cbxProvincia.setSelectedIndex(0);
        cbxCanton.removeAllItems();
        cbxDistrito.removeAllItems();
        txtFechaNacimiento.setText("");
    }//GEN-LAST:event_LimpiarActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        try {
            long codigo = Long.parseLong(txtCodigo.getText());
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                registroCliente.eliminarCliente(codigo);
                JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "Eliminación cancelada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar cliente: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        try {
            String criterio = JOptionPane.showInputDialog(this, "Ingrese el criterio de búsqueda (código, nombre o apellidos):");
            Cliente clienteEncontrado = null;

            if (criterio.matches("\\d+")) {
                long codigo = Long.parseLong(criterio);
                clienteEncontrado = registroCliente.buscarPorCodigo(codigo);
            } else if (criterio.contains(" ")) {
                clienteEncontrado = registroCliente.buscarPorApellidos(criterio);
            } else {
                clienteEncontrado = registroCliente.buscarPorNombre(criterio);
            }

            if (clienteEncontrado != null) {
                txtCodigo.setText(String.valueOf(clienteEncontrado.getCodigo()));
                txtNombre.setText(clienteEncontrado.getNombre());
                txtApellidos.setText(clienteEncontrado.getApellidos());
                txtTelefono.setText(String.valueOf(clienteEncontrado.getTelefono()));
                txtCorreo.setText(clienteEncontrado.getCorreo());
                cbxProvincia.setSelectedItem(clienteEncontrado.getProvincia());
		cargarCantones();
                cbxCanton.setSelectedItem(clienteEncontrado.getCanton());
		cargarDistritos();
                cbxDistrito.setSelectedItem(clienteEncontrado.getDistrito());
                txtFechaNacimiento.setText(clienteEncontrado.getFechaNacimiento().toString());
                JOptionPane.showMessageDialog(this, "Cliente encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar cliente: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
	    cargarCantones();
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        try {
            long codigo = Long.parseLong(txtCodigo.getText());
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String telefono = txtTelefono.getText();
            String correo = txtCorreo.getText();
            String provincia = cbxProvincia.getSelectedItem().toString();
            String canton = cbxCanton.getSelectedItem().toString();
            String distrito = cbxDistrito.getSelectedItem().toString();
            LocalDate fechaNacimiento = LocalDate.parse(txtFechaNacimiento.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Cliente nuevoCliente = new Cliente(codigo, nombre, apellidos, telefono, correo, provincia, canton, distrito, fechaNacimiento);
            registroCliente.agregarCliente(nuevoCliente);
            JOptionPane.showMessageDialog(this, "Cliente agregado con éxito.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar cliente: " + e.getMessage());
        }// Limpiar los campos
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        cbxProvincia.setSelectedIndex(0);
        cbxCanton.removeAllItems();
        cbxDistrito.removeAllItems();
        txtFechaNacimiento.setText("");
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

        private void cbxCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCantonActionPerformed
		cargarDistritos();
        }//GEN-LAST:event_cbxCantonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void create() {
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
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCliente().setVisible(true);
            }
        });
    }

    
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton Limpiar;
        private javax.swing.JButton btnAgregarCliente;
        private javax.swing.JButton btnBuscarCliente;
        private javax.swing.JButton btnEliminarCliente;
        private javax.swing.JButton btnModificar;
        private javax.swing.JComboBox<String> cbxCanton;
        private javax.swing.JComboBox<String> cbxDistrito;
        private javax.swing.JComboBox<String> cbxProvincia;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JTextField txtApellidos;
        private javax.swing.JTextField txtCodigo;
        private javax.swing.JTextField txtCorreo;
        private javax.swing.JTextField txtFechaNacimiento;
        private javax.swing.JTextField txtNombre;
        private javax.swing.JTextField txtTelefono;
        // End of variables declaration//GEN-END:variables
}
