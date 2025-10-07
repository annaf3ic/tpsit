import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GiocoV1 extends javax.swing.JFrame {
    
    public GiocoV1() {
        initComponents();
        eListener();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sasso = new javax.swing.JButton();
        carta = new javax.swing.JButton();
        forbice = new javax.swing.JButton();
        sceltaGiocatore = new javax.swing.JLabel();
        sceltaComputer = new javax.swing.JLabel();
        vs = new javax.swing.JLabel();
        risultato = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sasso.setText("Sasso");

        carta.setText("Carta");

        forbice.setText("Forbice");

        sceltaGiocatore.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sceltaGiocatore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sceltaComputer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sceltaComputer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        vs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vs.setText("vs.");

        risultato.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        risultato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(risultato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sceltaGiocatore, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sceltaComputer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sasso)
                        .addGap(18, 18, 18)
                        .addComponent(carta)
                        .addGap(18, 18, 18)
                        .addComponent(forbice)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sasso)
                    .addComponent(carta)
                    .addComponent(forbice))
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
        java.awt.EventQueue.invokeLater(() -> new GiocoV1().setVisible(true));
    }
    
    public void eListener() {
        ActionListener listener = e -> {
            String[] mosse = {"Sasso", "Carta", "Forbice"};
            String giocatore = ((JButton)e.getSource()).getText();
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
        
        sasso.addActionListener(listener);
        carta.addActionListener(listener);
        forbice.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carta;
    private javax.swing.JButton forbice;
    private javax.swing.JLabel risultato;
    private javax.swing.JButton sasso;
    private javax.swing.JLabel sceltaComputer;
    private javax.swing.JLabel sceltaGiocatore;
    private javax.swing.JLabel vs;
    // End of variables declaration//GEN-END:variables
}
