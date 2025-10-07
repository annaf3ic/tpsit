import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;

public class GiocoV2 extends javax.swing.JFrame {
    
    public GiocoV2() {
        initComponents();
        eListener();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vs = new javax.swing.JLabel();
        risultato = new javax.swing.JLabel();
        a = new javax.swing.JButton();
        b = new javax.swing.JButton();
        c = new javax.swing.JButton();
        sceltaGiocatore = new javax.swing.JLabel();
        sceltaComputer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        vs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vs.setText("vs.");

        risultato.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        risultato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        a.setText("?");

        b.setText("?");

        c.setText("?");

        sceltaGiocatore.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sceltaGiocatore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sceltaComputer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sceltaComputer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(risultato, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(sceltaGiocatore, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(vs, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sceltaComputer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a)
                    .addComponent(b)
                    .addComponent(c))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sceltaGiocatore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sceltaComputer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(risultato, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new GiocoV2().setVisible(true));
    }
    
    public void eListener() {
        ActionListener listener = e -> {
            String[] mosse = {"Sasso", "Carta", "Forbice"};
            String giocatore = mosse[new Random().nextInt(3)];
            String computer = mosse[new Random().nextInt(3)];

            String esito;
            sceltaGiocatore.setText(giocatore);
            sceltaComputer.setText(computer);
            
            if (giocatore.equals(computer)) {
                esito = "Pareggio!";
            } else if ((giocatore.equals("Sasso") && computer.equals("Forbice")) || (giocatore.equals("Carta") && computer.equals("Sasso")) || (giocatore.equals("Forbice") && computer.equals("Carta"))) {
                esito = "Hai vinto!";
            } else {
                esito = "Hai perso!";
            }
            risultato.setText(esito);
        };
        
        a.addActionListener(listener);
        b.addActionListener(listener);
        c.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a;
    private javax.swing.JButton b;
    private javax.swing.JButton c;
    private javax.swing.JLabel risultato;
    private javax.swing.JLabel sceltaComputer;
    private javax.swing.JLabel sceltaGiocatore;
    private javax.swing.JLabel vs;
    // End of variables declaration//GEN-END:variables
}
