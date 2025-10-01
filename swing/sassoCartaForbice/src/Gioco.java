import java.awt.event.*;

public class Gioco extends javax.swing.JFrame {

    public Gioco() {
        initComponents();
        
        sasso.setActionCommand("Sasso");
        carta.setActionCommand("Carta");
        forbice.setActionCommand("Forbice");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = ((JButton) e.getSource()).getActionCommand();
        switch (actionCommand) {
            case "Sasso":
                text.setText(actionCommand);
                break;
            case "Carta":
                // CODICE PULSANTE 2 QUI
                break;
            case "Forbice":
                
                break;
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sasso = new javax.swing.JButton();
        carta = new javax.swing.JButton();
        forbice = new javax.swing.JButton();
        text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sasso.setText("Sasso");
        sasso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sassoActionPerformed(evt);
            }
        });

        carta.setText("Carta");

        forbice.setText("Forbice");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sasso)
                        .addGap(18, 18, 18)
                        .addComponent(carta)
                        .addGap(18, 18, 18)
                        .addComponent(forbice)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sasso)
                    .addComponent(carta)
                    .addComponent(forbice))
                .addGap(127, 127, 127))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sassoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sassoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sassoActionPerformed

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
            java.util.logging.Logger.getLogger(Gioco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gioco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gioco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gioco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gioco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carta;
    private javax.swing.JButton forbice;
    private javax.swing.JButton sasso;
    private javax.swing.JTextField text;
    // End of variables declaration//GEN-END:variables
}