package com.game.projet.company;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindows extends JFrame {
    public MyWindows() throws UnsupportedLookAndFeelException {
        super("Gestion de la bibliothèque");
        //this.setBackground(Color.green);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);


        /**************   Seconde couche *********************/
        JPanel container = (JPanel) this.getContentPane();


        /****************************** *****************************/

        /*********************  Gesionnaire de  positions ***********/

        FlowLayout monLayout = new FlowLayout();
        container.setLayout(monLayout);


        // GridBagLayout gridbag = new GridBagLayout();

        //GridBagConstraints c = new GridBagConstraints();

        // setFont(new Font("SansSerif", Font.PLAIN, 14));

        //container.setLayout(gridbag);




        /************************ table ************************/
        //String [] colonnes ={"Nom","Prenom", "Age"};
        //String [][] data=new String[6][3];
     //   JTable table =new JTable(data, colonnes);

       // c.fill = GridBagConstraints.NORTH;
        //c.weightx = 1.0;

        //c.gridx=0;
       // c.gridy=0;
       // container.add(table,c);



        /********************* 1 er  Attribus  Titre  **************/
        //JLabel labelTitre = new JLabel();

        //labelTitre.setText("Titre : ");
       // c.gridx=1;
        //c.gridy=0;
       // container.add(labelTitre,c);


        JLabel refeLivre = new JLabel("Référence : " );                                 /***** La reference ****/
        JTextField reference= new JTextField();
        reference.setPreferredSize(new Dimension(100, 25));
        container.add(refeLivre);
        container.add(reference);



        JLabel tireLivre = new JLabel("Titre : " );                                 /***** Le titre ****/
        JTextField titre = new JTextField();
        titre.setPreferredSize(new Dimension(100, 25));
        container.add(tireLivre);
        container.add(titre);



        JLabel nomAuteur = new JLabel("Nome auteur : ");                          /** Le nom de l'auteur**/
        JTextField auteur = new JTextField();
        auteur.setPreferredSize(new Dimension(100, 25));
        container.add(nomAuteur);
        container.add(auteur);




        JLabel maisonEdition = new JLabel("Maison Edition : ");                     /** Maison d'édition **/
        JTextField maison = new JTextField();
        maison.setPreferredSize(new Dimension(100, 25));
        container.add(maisonEdition);
        container.add(maison);




        JLabel anneeEdition = new JLabel("Année Edition : ");                      /**  Année d'édition **/
        JTextField annee = new JTextField();
        annee.setPreferredSize(new Dimension(100, 25));

        container.add(anneeEdition);
        container.add(annee);




        JLabel langueLivre = new JLabel("Langue  : ");                            /**  Langue  d'édition **/
        JTextField langue = new JTextField();
        langue.setPreferredSize(new Dimension(100, 25));
        container.add(langueLivre);
        container.add(langue);

       JButton tLivres = new JButton(" Tout les lires");                        /****  Boutton  pour afficher tous les livres****/
       container.add(tLivres);

        JButton titreA = new JButton(" livre titres A");                        /****  Boutton  pour afficher tous les livres
                                                                                        dont le titre commence par A****/
        container.add(titreA);


        JButton refAmpaire = new JButton(" Référence Imapaire");              /****  Boutton  pour afficher tous les livres****/
                                                                                   /***  dont la référence est imapire ****/
        container.add(refAmpaire);
























    }


}
