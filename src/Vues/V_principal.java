package Vues;

import javax.swing.*;
import java.awt.*;

public class V_principal extends JFrame {
	JPanel mainPanel;
    public V_principal() {
        // Fen�tre principale
        setTitle("Fripouilles");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // D�finir un JPanel principal avec BorderLayout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);
    }
	
}
