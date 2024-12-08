package Vues;

import javax.swing.*;
import java.awt.*;

public class V_principal extends JFrame {
	private JPanel mainPanel;
    public V_principal() {
        // Fen�tre principale
        this.setTitle("Fripouilles");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
         
        mainPanel = new JPanel(new BorderLayout());
        this.setContentPane(mainPanel);
    }
	
}
