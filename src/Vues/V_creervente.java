package Vues;

import java.awt. *;

import javax.swing. *;

public class V_creervente extends JPanel{
	private JPanel monPanel;
	private GridBagConstraints gbc;
	
	private JTextField nomVente;
	private JTextField dateVente;
	private JTextField typeVente;
	
	private JLabel nomdelaVente;
	private JLabel datedelaVente;
	private JLabel typedelaVente;
	
	private JButton btnAjouterVente;
	
	
	public V_creervente() {
		setLayout(new GridBagLayout());
		//Gestionnaire de répartition (pour ordonner les champs et boutons)
		this.gbc = new GridBagConstraints();
		
		this.gbc.insets = new Insets(5, 5, 5, 5);
        this.gbc.fill = GridBagConstraints.VERTICAL;
        
        this.nomVente = new JTextField(20);
        this.dateVente = new JTextField(20);
        this.typeVente = new JTextField(20);
        
        this.nomdelaVente = new JLabel("Nom de la vente");
        this.datedelaVente = new JLabel("Date de la vente");
        this.typedelaVente = new JLabel("Type de la vente");
        
        this.btnAjouterVente = new JButton("Ajouter Vente");
        
        //Positionnement des elements dans le panel avec gbc -> https://bbclone.developpez.com/fr/java/tutoriels/uiswing/gridbaglayout/?page=page_3
        gbc.gridx = 0; gbc.gridy = 0;
        this.add(nomdelaVente, gbc);
        gbc.gridx = 1;
        this.add(nomVente, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        this.add(dateVente, gbc);
        gbc.gridx = 1;
        this.add(datedelaVente, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        this.add(typeVente, gbc);
        gbc.gridx = 1;
        this.add(typedelaVente, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        this.add(typeVente, gbc);
        gbc.gridx = 1;
        this.add(btnAjouterVente, gbc);
        
	}
}
