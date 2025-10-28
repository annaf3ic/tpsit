import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MasterMind extends JFrame {
    private static String[] colors;
    private static JLabel label1;
    private static JLabel label2;
    private static ArrayList<JButton> buttons;

    public MasterMind() {
        initComponents();
        colors = new String[]{"B31B1B", "ED9121", "FFD700", "228B22", "0070BB", "9966CC"};
    }

    public void eListener() {
        ActionListener listener = e -> {
            boolean conferma = false;
            String comando = ((JButton) e.getSource()).getText();
            if (comando.equals("INVIO")) {
                conferma = true;
            }
            while (!conferma) {

            }
        };
    }

    public void initComponents() {
        JFrame f = new JFrame();
        f.setSize(600, 700);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(5, 5, 370, 50);
        label1.setFont(new java.awt.Font("Segoe UI", 0, 24));
        f.add(label1);

        label2 = new JLabel();
        label2.setBounds(5, 15, 370, 50);
        label2.setFont(new java.awt.Font("Segoe UI", 0, 24));
        f.add(label2);

        int x = 5;
        int y = 5;
        for (int i = 0; i < 4; i++) {
            JButton button = new JButton();
            button.setBounds(x, y, 90, 90);
            button.setFont(new java.awt.Font("Segoe UI", 0, 20));
            button.setBackground(Color.decode("E5E4E2"));
            x += 100;
            f.add(button);
        }

        JButton invio = new JButton("INVIA");
        invio.setBounds(x, y, 90, 20);
        invio.setFont(new java.awt.Font("Segoe UI", 0, 20));
    }
}