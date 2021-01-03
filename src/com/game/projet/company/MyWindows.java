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
        //this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,250);
        //this.setLocationRelativeTo(null);
        Biblio maBiblio=new Biblio();

        JPanel pan = new JPanel(); pan.setBackground(Color.gray);
        pan.setLayout(new GridLayout(7, 2));

        JPanel pan2 = new JPanel(); pan2.setBackground(Color.darkGray);
        pan2.setLayout(new BorderLayout());





        /****************************** *****************************/

        /*********************  Gesionnaire de  positions ***********/






        JLabel refeLivre = new JLabel("Référence : " );                                 /***** La reference ****/
        JTextField reference= new JTextField();
        reference.setPreferredSize(new Dimension(100, 25));
        pan.add(refeLivre);
        pan.add(reference);


        JLabel tireLivre = new JLabel("Titre : " );                                 /***** Le titre ****/
        JTextField titre = new JTextField();
        titre.setPreferredSize(new Dimension(100, 25));
        pan.add(tireLivre);
        pan.add(titre);



        JLabel nomAuteur = new JLabel("Nome auteur : ");                          /** Le nom de l'auteur**/
        JTextField auteur = new JTextField();
        auteur.setPreferredSize(new Dimension(100, 25));
        pan.add(nomAuteur);
        pan.add(auteur);




        JLabel maisonEdition = new JLabel("Maison Edition : ");                     /** Maison d'édition **/
        JTextField maison = new JTextField();
        maison.setPreferredSize(new Dimension(100, 25));
        pan.add(maisonEdition);
        pan.add(maison);




        JLabel anneeEdition = new JLabel("Année Edition : ");                      /**  Année d'édition **/
        JTextField annee = new JTextField();
        annee.setPreferredSize(new Dimension(100, 25));

        pan.add(anneeEdition);
        pan.add(annee);




        JLabel langueLivre = new JLabel("Langue  : ");                            /**  Langue  d'édition **/
        JTextField langue = new JTextField();
        langue.setPreferredSize(new Dimension(100, 25));
        pan.add(langueLivre);
        pan.add(langue);



        JTextArea zoneAfficher = new JTextArea();                                 /***  Zone d'affichage ****/


        zoneAfficher.setPreferredSize(new Dimension(200,200));
        pan2.add(zoneAfficher, BorderLayout.NORTH);





/*******************************************************************************************************************************/

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
        pan.add(ajoutLivre);
/*******************************************************************************************************************************/





/*******************************************************************************************************************************/
        JButton tLivres = new JButton(" Tout les lires");                        /****  Boutton  pour afficher tous les livres****/
        tireLivre.setMaximumSize(new Dimension(30,25));
        pan2.add(tLivres,BorderLayout.WEST);


        tLivres.addActionListener( new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           zoneAfficher.setText(null);
                                           affichLivreBiblio(maBiblio, zoneAfficher);
                                       }
                                   }
        );
/*******************************************************************************************************************************/



/*******************************************************************************************************************************/

        JButton titreA = new JButton(" livre titres A");                        /****  Boutton  pour afficher tous les livres
                                                                                               dont la reference est un nombre impaire ****/
       titreA.setMaximumSize(new Dimension(30,25));
        titreA.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               zoneAfficher.setText(null);
               getAllBooksWithNameStartByAFieled(maBiblio, zoneAfficher);


           }
       });

        pan2.add(titreA, BorderLayout.CENTER);
/*******************************************************************************************************************************/





/*******************************************************************************************************************************/

        JButton refAmpaire = new JButton(" Référence Imapaire");              /****  Boutton  pour afficher tous les livres****/
                                                                                   /***  dont la référence est imapire ****/
        refAmpaire.setMaximumSize(new Dimension(30,25));
        pan2.add(refAmpaire, BorderLayout.EAST);
        refAmpaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                zoneAfficher.setText(null);
                getAllBooksWhithIDSNOddTextField(maBiblio,zoneAfficher);


            }
        });
/*******************************************************************************************************************************/

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan, pan2);

       this.getContentPane().add(split, BorderLayout.CENTER);


        this.setVisible(true);


        JMenuBar monMenu = new JMenuBar();
        this.setJMenuBar(monMenu);

        JMenu menuFichier = new JMenu("Fichier");
        monMenu.add(menuFichier);

        JMenuItem subMenuExit = new JMenuItem("Exit");

        subMenuExit.addActionListener( new ActionListener() {
                                           public void actionPerformed(ActionEvent e) {
                                               System.exit(0);
                                           }
                                       }
        );

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






    private void affichLivreBiblio(Biblio maBiblio, JTextArea labelCR) {
        String cr = "";
        for (int i = 0; i< maBiblio.getListDeLivres().size(); i++){

            cr +=     maBiblio.getListDeLivres().get(i).getIndiceRef()+" -- "
                      +maBiblio.getListDeLivres().get(i).getTitre() + " -- "
                      +maBiblio.getListDeLivres().get(i).getAuteur() +" --"
                      +maBiblio.getListDeLivres().get(i).getEditeur()+" -- "
                      +maBiblio.getListDeLivres().get(i).getAnnee()+"--"
                      +maBiblio.getListDeLivres().get(i).getLangue()+"\n" ;
        }
        labelCR.setText(cr);
    }



    private void createBook(String tire,String auteur , Integer annee, String maison,
                            String langue, Integer reference, Biblio maBiblio) {



        Livre monLivre = new Livre(tire,auteur , annee, maison,  langue, reference);

        maBiblio.AddBook(monLivre);


    }



   private void getAllBooksWhithIDSNOddTextField(Biblio maBiblio, JTextArea jTextField){
       ArrayList arrayList = maBiblio.getAllBooksWhithIDSNOdd();
       String cr = "";
       for (int i = 0; i< arrayList.size(); i++){


           cr +=    arrayList.get(i)+" \n ";

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

    private void    getAllBooksWithNameStartByAFieled(Biblio maBiblio, JTextArea jTextField){

        ArrayList arrayList = maBiblio.getAllBooksWithNameStartByA();
        String cr = "";
        for (int i = 0; i< arrayList.size(); i++){

            cr +=    arrayList.get(i)+" \n ";
        }

        jTextField.setText(cr);


    }



}
