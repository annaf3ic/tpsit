import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calcolatrice extends JFrame {

    private JTextField display;
    private double result = 0;
    private String operator = "";
    private boolean start = true;

    public Calcolatrice() {
        setTitle("Calcolatrice");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "÷",
                "4", "5", "6", "×",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));

            button.addActionListener(e -> buttonPressed(e));
            buttonPanel.add(button);
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(display, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }

    private void buttonPressed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();

        if ("0123456789".contains(command)) {
            if (start) {
                display.setText(command);
            } else {
                display.setText(display.getText() + command);
            }
            start = false;
        } else if (command.equals("C")) {
            display.setText("0");
            start = true;
            operator = "";
            result = 0;
        } else if (command.equals("=")) {
            calculate(Double.parseDouble(display.getText()));
            display.setText("" + result);
            operator = "";
            start = true;
        } else { // Operatori (+, -, ×, ÷)
            if (!operator.isEmpty()) {
                calculate(Double.parseDouble(display.getText()));
                display.setText("" + result);
            } else {
                result = Double.parseDouble(display.getText());
            }
            operator = command;
            start = true;
        }
    }

    private void calculate(double x) {
        switch (operator) {
            case "+": result += x; break;
            case "-": result -= x; break;
            case "×": result *= x; break;
            case "÷": result /= x; break;
            default: result = x; break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calcolatrice calc = new Calcolatrice();
            calc.setVisible(true);
        });
    }
}