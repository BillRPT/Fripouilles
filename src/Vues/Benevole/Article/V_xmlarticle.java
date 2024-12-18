package Vues.Benevole.Article;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing. *;

import Class.Article;
import Class.Catalogue;

public class V_xmlarticle extends JPanel{

	private GridBagConstraints gbc;
    private JTextArea monTextArea;
    private String rep;
	
	public V_xmlarticle(ArrayList<Article> lesArticles) {
		rep = "";

	    setLayout(new GridBagLayout());
	    this.gbc = new GridBagConstraints();

	    this.gbc.insets = new Insets(5, 5, 5, 5);
	    this.gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    monTextArea = new JTextArea(10, 80); 
        monTextArea.setEditable(false);  
        monTextArea.setLineWrap(true);   
        monTextArea.setWrapStyleWord(true);

	    for (Article unArticle : lesArticles) {
	    	String xml = unArticle.toXML();

            rep = rep + xml + "\n";
	    }

	    monTextArea.setText(rep);

	    gbc.gridx = 0; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 2;
	    JScrollPane scrollPane = new JScrollPane(monTextArea);
	    this.add(scrollPane, gbc);
	}

}
