package Formulario;

import javax.swing.tree.DefaultTreeModel;
import Entidades.Arbol;
import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


/**
 *
 * @author juliocanizalez
 */
public class frmProy extends javax.swing.JFrame {

    /**
     * Creates new form frmProy
     */
    DefaultTreeModel modelo;
    Arbol root;
    Arbol hijo;
    DefaultMutableTreeNode nodo;

    public frmProy() {
        initComponents();
        root = new Arbol("Raiz");
        modelo = (DefaultTreeModel) this.arbol.getModel();
        this.txtAdd.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        txtAdd = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblPath = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Arbol");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Raiz");
        arbol.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                arbolMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(arbol);

        jLabel1.setText("Elemento a insertar:");

        txtAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddKeyPressed(evt);
            }
        });

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar Nodo");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar XML");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel2.setText("Archivo guardado en:");

        lblPath.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAdd)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblPath))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnGuardar))
                        .addGap(138, 138, 138)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(lblPath)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            nodo = (DefaultMutableTreeNode) this.arbol.getLastSelectedPathComponent();
            nodo.insert(new DefaultMutableTreeNode(this.txtAdd.getText().trim().toUpperCase()), 0);
            addToList(this.txtAdd.getText().trim().toUpperCase());
            modelo.reload(nodo);
            this.txtAdd.setText("");
            this.txtAdd.requestFocus();
        } catch (HeadlessException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Selecciona primero en dónde quieres agregar el nuevo nodo", "Error", HEIGHT);

        }
    }//GEN-LAST:event_btnAddActionPerformed
    private void addToList(String valor) {
        if (nodo.isRoot()) {//Se agrega a raiz
            hijo = new Arbol(valor);
            root.sub.add(0, hijo); //Siempre mandándolo al inicio
        } else {//Si no es raiz ocuparemos recursividad         
            String nom = this.arbol.getLastSelectedPathComponent().toString();//Obtenemos el nombre del elemento seleccionado
            root.recorrer(root, nom, valor);
        }
    }
    private void arbolMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolMousePressed

    }//GEN-LAST:event_arbolMousePressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            nodo = (DefaultMutableTreeNode) this.arbol.getLastSelectedPathComponent();
            String nom = this.arbol.getLastSelectedPathComponent().toString();
            root.deleteFromList(root, nom);
            modelo.removeNodeFromParent(nodo);
            modelo.reload();
            this.txtAdd.requestFocus();
        } catch (HeadlessException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Selecciona el nodo que quieres eliminar");
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            PrintWriter pw;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            File selectedFile;
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                this.lblPath.setText(selectedFile.getAbsolutePath());
                root.abrirXML(root);
                root.cerrarXML();
                pw = new PrintWriter(new File(selectedFile.getAbsolutePath()));
                pw.write(root.getXmlString());
                pw.close();
            }else{
                JOptionPane.showMessageDialog(null, "Operación cancelada");
            }
            
        } catch (HeadlessException e) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmProy.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            try {
            nodo = (DefaultMutableTreeNode) this.arbol.getLastSelectedPathComponent();
            nodo.insert(new DefaultMutableTreeNode(this.txtAdd.getText().trim().toUpperCase()), 0);
            addToList(this.txtAdd.getText().trim().toUpperCase());
            modelo.reload(nodo);
            this.txtAdd.setText("");
            this.txtAdd.requestFocus();
        } catch (HeadlessException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Selecciona primero en dónde quieres agregar el nuevo nodo", "Error", HEIGHT);

        }
        }
    }//GEN-LAST:event_txtAddKeyPressed


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
            java.util.logging.Logger.getLogger(frmProy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbol;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPath;
    private javax.swing.JTextField txtAdd;
    // End of variables declaration//GEN-END:variables
}