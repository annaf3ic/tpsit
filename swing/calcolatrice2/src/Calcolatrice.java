import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calcolatrice extends JFrame {
    private double a = 0;
    private double b = 0;
    private String operatore = "";
    private boolean nuovaOperazione = true;
    private String espressione = "";
    private static JTextField text;
    private static JTextField espressioneF;

    public Calcolatrice() {
        initComponents();
        eListener();
    }

    public void eListener() {
        ActionListener listener = e -> {
            String comando = ((JButton) e.getSource()).getText();
            System.out.println(comando);

            if ("+-×÷".contains(comando)) {
                a = Integer.parseInt(text.getText());
                operatore = comando;
                espressione = a + " " + operatore;
                espressioneF.setText(espressione);
                nuovaOperazione = true;
            } else if (comando.equals("=")) {
                b = Integer.parseInt(text.getText());
                switch (operatore) {
                    case "+":
                        a = a + b;
                        break;
                    case "-":
                        a = a - b;
                        break;
                    case "×":
                        a = a * b;
                        break;
                    case "÷":
                        if (b != 0) a = a / b;
                        else {
                            text.setText("Errore");
                            return;
                        }
                }
                text.setText(String.valueOf(a));
                espressione += " " + b + " =";
                espressioneF.setText(espressione);
                nuovaOperazione = true;
            } else if (comando.equals("C")) {
                a = 0;
                b = 0;
                operatore = "";
                text.setText("");
                espressione = "";
                espressioneF.setText("");
                nuovaOperazione = true;
            } else {
                if (nuovaOperazione) {
                    text.setText(comando);
                    nuovaOperazione = false;
                } else {
                    text.setText(text.getText() + comando);
                }
            }
        };
    }

    public void initComponents() {
        JFrame f = new JFrame();
        f.setSize(400, 700);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        espressioneF = new JTextField();
        espressioneF.setBounds(5, 5, 370, 50);
        espressioneF.setFont(new java.awt.Font("Segoe UI", 0, 24));
        f.add(espressioneF);

        text = new JTextField();
        text.setBounds(5, 60, 375, 100);
        text.setFont(new java.awt.Font("Segoe UI", 0, 36));
        f.add(text);

        String[][] buttonText = {{"7", "8", "9", "÷"}, {"4", "5", "6", "×"}, {"1", "2", "3", "-"}, {"0", "C", "=", "+"}};

        int x = 5;
        int y = 170;

        for (int i=0; i<buttonText.length; i++) {
            for (int j=0; j<buttonText[0].length; j++) {
                String text = buttonText[i][j];
                JButton button = new JButton(text);
                button.setBounds(x, y, 90, 70);
                button.setFont(new java.awt.Font("Segoe UI", 0, 20));
                x += 95;
                f.add(button);
            }
            x = 5;
            y += 75;
        }
    }
}