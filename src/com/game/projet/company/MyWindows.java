package com.game.projet.company;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyWindows extends JFrame {
    public MyWindows() throws UnsupportedLookAndFeelException {
        super("Gestion de la bibliothèque");

        //this.setBackground(Color.green);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,800);
        //this.setLocationRelativeTo(null);
        Biblio maBiblio=new Biblio();


        /**************   Seconde couche *********************/
        JPanel container = (JPanel) this.getContentPane();


        /****************************** *****************************/

        /*********************  Gesionnaire de  positions ***********/

        FlowLayout monLayout = new FlowLayout();
        container.setLayout(monLayout);





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



        JTextField zoneAfficher = new JTextField();                                 /***  Zone d'affichage ****/
        zoneAfficher.setPreferredSize(new Dimension(200,200));
        container.add(zoneAfficher);

        JTextField zoneAfficher2 = new JTextField();                                 /***  Zone d'affichage ****/
        zoneAfficher2.setPreferredSize(new Dimension(200,200));
        container.add(zoneAfficher2);


        JButton ajoutLivre =new JButton();
        ajoutLivre.setText("Ajouter");

        ajoutLivre.addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             createBook(titre.getText().trim(),
                                                        auteur.getText().trim(),
                                                        Integer.parseInt(annee.getText().trim()),
                                                        maison.getText().trim(),
                                                        langue.getText().trim(),
                                                        Integer.parseInt(reference.getText().trim()),
                                                        maBiblio);
                                             clean(  titre, auteur, annee,
                                                     maison,langue,reference);


                                         }
                                     });
        container.add(ajoutLivre);



        JButton tLivres = new JButton(" Tout les lires");                        /****  Boutton  pour afficher tous les livres****/
       container.add(tLivres);





        JButton titreA = new JButton(" livre titres A");                        /****  Boutton  pour afficher tous les livres
                                                                                        dont le titre commence par A****/
       titreA.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getAllBooksWhithIDSNOddTextField(maBiblio,zoneAfficher2);
           }
       });

        container.add(titreA);




        tLivres.addActionListener( new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           affichLivreBiblio(maBiblio, zoneAfficher);
                                       }
                                   }
        );




        JButton refAmpaire = new JButton(" Référence Imapaire");              /****  Boutton  pour afficher tous les livres****/
                                                                                   /***  dont la référence est imapire ****/
        container.add(refAmpaire);




        JMenuBar monMenu = new JMenuBar();
        this.setJMenuBar(monMenu);

        JMenu menuFichier = new JMenu("Fichier");
        monMenu.add(menuFichier);

        JMenuItem subMenuExit = new JMenuItem("Exit");
        JMenuItem subMenuNew = new JMenuItem("Nouveau");

        menuFichier.add(subMenuNew);
        menuFichier.add(subMenuExit);



        JMenu menuEdition = new JMenu("Edition");
        monMenu.add(menuEdition);

        JMenuItem subMenuCopy = new JMenuItem("Copier");
        JMenuItem subMenuPaste = new JMenuItem("Coller");

        menuEdition.add(subMenuCopy);
        menuEdition.add(subMenuPaste);
    }






    private void affichLivreBiblio(Biblio maBiblio, JTextField  labelCR) {
        String cr = "";
        for (int i = 0; i< maBiblio.getListDeLivres().size(); i++){

            cr +=     maBiblio.getListDeLivres().get(i).getIndiceRef()+" \n "
                      +maBiblio.getListDeLivres().get(i).getTitre() + " \n "
                      +maBiblio.getListDeLivres().get(i).getAuteur() +" \n "
                      +maBiblio.getListDeLivres().get(i).getEditeur()+" \n "
                      +maBiblio.getListDeLivres().get(i).getAnnee()+"\n"
                      +maBiblio.getListDeLivres().get(i).getLangue() ;
        }
        labelCR.setText(cr);
    }



    private void createBook(String tire,String auteur , Integer annee, String maison,
                            String langue, Integer reference, Biblio maBiblio) {



        Livre monLivre = new Livre(tire,auteur , annee, maison,  langue, reference);

        maBiblio.AddBook(monLivre);


    }



   private void getAllBooksWhithIDSNOddTextField(Biblio maBiblio, JTextField jTextField){
       ArrayList arrayList = maBiblio.getAllBooksWhithIDSNOdd();
       String cr = "";
       for (int i = 0; i< maBiblio.getListDeLivres().size(); i++){

           cr +=    maBiblio.getListDeLivres().get(i).getIndiceRef()+" \n "
                   +maBiblio.getListDeLivres().get(i).getTitre() + " \n "
                   +maBiblio.getListDeLivres().get(i).getAuteur() +" \n "
                   +maBiblio.getListDeLivres().get(i).getEditeur()+" \n"
                   +maBiblio.getListDeLivres().get(i).getAnnee()+"\n"
                   +maBiblio.getListDeLivres().get(i).getLangue() ;
       }

       jTextField.setText(cr);


   }


   private void clean(JTextField titre,  JTextField auteur,JTextField  annee,JTextField  maison,JTextField  langue,JTextField reference){
       titre.setText("");
       auteur.setText("");
       annee.setText("");
       maison.setText("");
       langue.setText("");
     reference.setText("");


   };



}
