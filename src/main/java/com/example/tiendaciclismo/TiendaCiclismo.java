/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.example.tiendaciclismo;

/**
 *
 * @author universidad
 */
public class TiendaCiclismo {

    private static Tienda tienda;

    public static Tienda getTienda() {
        return tienda;
    }

    public static void initLookAndFeel() {
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
			java.util.logging.Logger.getLogger(VentanaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(VentanaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(VentanaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(VentanaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
    }

    public static void ejecutarInicioSesion() {
	java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
			new VentanaInicioSesion().setVisible(true);
		}
	});
    }

    public static void ejecutarAplicacionPrincipal() {
	java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
                    System.out.println("Aplicación principal");
		}
	});
    }

    public static void main(String[] args) {
        try {
            tienda = new Tienda();
        } catch (Exception e) {
            System.err.println("Fallo al inicializar, saliendo...");
        }

        ejecutarInicioSesion();
    }
}
