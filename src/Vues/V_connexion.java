package Vues;

import javax.swing.*;
import java.awt.*;

import Controleurs.*;
import Fonction.*;

public class V_connexion extends JFrame {

    private C_connexion cConnex;
    private JTextField fieldPseudo;
    private JPasswordField fieldMdp;
    private JButton btnValider;

    public V_connexion(C_connexion cConnexion, C_pbenevole cPBenevole, C_psecretaire cPSecretaire, C_principal lecPrincipal) {
        this.cConnex = cConnexion;

        this.setTitle("Fripouilles - Connexion");
        this.setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel);

        JLabel labelLogo = new JLabel(Fonction.resizeImageIcon(new ImageIcon("images/fripouilles_logo.png"), 325, 170));
        labelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelLogo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel labelPseudo = new JLabel("Login :");
        labelPseudo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelPseudo);

        fieldPseudo = new JTextField(15);
        fieldPseudo.setMaximumSize(new Dimension(200, 30));
        contentPanel.add(fieldPseudo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel labelMdp = new JLabel("Mot de passe :");
        labelMdp.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelMdp);

        fieldMdp = new JPasswordField(15);
        fieldMdp.setMaximumSize(new Dimension(200, 30));
        contentPanel.add(fieldMdp);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        btnValider = new JButton("Connexion");
        btnValider.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(btnValider);

        // Passer C_connexion comme ActionListener
        btnValider.addActionListener(cConnexion);

        setVisible(false);
    }

    public String getPseudo() {
        return fieldPseudo.getText();
    }

    public char[] getPassword() {
        return fieldMdp.getPassword();
    }
}
