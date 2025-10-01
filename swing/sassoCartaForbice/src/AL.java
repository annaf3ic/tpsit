import java.awt.*;
import java.awt.event.*;
public class AL extends Frame implements WindowListener,ActionListener {
    TextField text = new TextField(20);
    Button sasso;
    Button carta;
    Button forbice;

    public static void main(String[] args) {
        AL myWindow = new AL("La mia prima finestra");
        myWindow.setSize(350,100);
        myWindow.setVisible(true);
    }
    
    public AL(String title) {
        super(title);
        setLayout(new FlowLayout());
        addWindowListener(this);
        sasso = new Button("Sasso");
        carta = new Button("Carta");
        forbice = new Button("Forbice");
        
        sasso.setActionCommand("Sasso");
        carta.setActionCommand("Carta");
        forbice.setActionCommand("Forbice");
    }
    
    public void actionPerformed(ActionEvent e) {
        numClicks++;
        text.setText("Pulsante cliccato " + numClicks + " volte");
    }
    
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
}