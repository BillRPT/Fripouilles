package Vues;

import javax.swing.*;
import Fonction.*;
import java.awt.*;

public class V_logo extends JPanel {
	JLabel labelLogo;
	
	public V_logo() {
		setLayout(new GridBagLayout()); //centre l'image dans le panneau
		
		labelLogo = new JLabel(Fonction.resizeImageIcon(new ImageIcon("images/fripouilles_logo.png"), 325,170));
		add(labelLogo);
		
	}
	
}
