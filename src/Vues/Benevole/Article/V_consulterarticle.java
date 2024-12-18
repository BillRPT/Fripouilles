package Vues.Benevole.Article;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.Article;
import Class.Catalogue;



public class V_consulterarticle extends JPanel{
	
	private JPanel monPanel;
	private JTable tArticle;
	private  JScrollPane scrollPane;
	private GridBagConstraints gbc;
	
	public V_consulterarticle(ArrayList<Article> lesArticles) {
		
		setLayout(new GridBagLayout());
        
        //gestionnaire de répartition (pour ordonner les champs et boutons)
        this.gbc = new GridBagConstraints();
        
        this.gbc.insets = new Insets(5, 5, 5, 5);
	    
        Object data[][] = new Object[25][4];
	    String[] title = {"idArt", "libelleArt", "typeArt", "etatArt"};
	    
	    //remplir le tableau avec les donn�es des catalogues
	    int i = 0;
	    for (Article unArticle : lesArticles) {
	    	data[i][0] = unArticle.getIdArt();
	    	data[i][1] = unArticle.getLibelleArt();
	    	data[i][2] = unArticle.getTypeArt();
	        data[i][3] = unArticle.getEtatArt();
	        i++;
	    }
	    
	    tArticle = new JTable(data, title);
	    
	    scrollPane = new JScrollPane(tArticle);
	    
	    gbc.gridx = 0; gbc.gridy = 0;
        this.add(scrollPane, gbc);
	}

}
