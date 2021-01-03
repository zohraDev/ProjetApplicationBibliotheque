package com.game.projet.company;




import javax.swing.*;
import java.util.ArrayList;

/**
     * Classe qui va nous permettre de stocker des livres et retourner
     * différentes statistique sur le contenu de la bibliothèque.
     */

    public class Biblio {

        private   ArrayList<Livre> listDeLivres;


        /**
         * Méthode constructeur de l'objet Bibliothèque
         * Ici on ne demande pas d'argument
         * Car on va réer une bibliothèque qui va subir un
         * inventaire au lancement de l'application
         * On instanciera simplement Une arraylist Vide.
         */
        public Biblio() {
            listDeLivres = new ArrayList<>();

        }

        /**
         * Méthode getter de la variable liste de livre qui
         * va nous permettres de consulter et Ajouter des livres
         * et eventuellement en modifier.
         * @return          => une ArrayList de Livre
         */
        public ArrayList<Livre> getListDeLivres() {
            return listDeLivres;
        }


        /**
         * Méthode qui va à partir de la liste complète des livres de la
         * bibliothèque retourner une sous liste de titre de livres qui commence
         * strictement par la lettre A
         * @return   Une ArrayList de Titre de livre commençant par la lettre A
         */
        public ArrayList<String> getAllBooksWithNameStartByA(){
            ArrayList<String> maSousListe = new ArrayList<>();
            for (int i = 0; i<this.getListDeLivres().size(); i++){
                Livre monLivreATester = this.getListDeLivres().get(i);
                if (monLivreATester.getTitre().toLowerCase().startsWith("a")){
                    maSousListe.add(monLivreATester.getTitre());
                }

            }

            return maSousListe;
        }

        /**
         * Méthode qui va à partir de la liste complète des livres de la
         * bibliothèque retourner une sous liste de titre et d'indice de livres qui ont
         * un indiceRef strictement impair
         * @return   Une ArrayList de Titre de livre et son indice Ref qui est Impair
         */
        public ArrayList<String> getAllBooksWhithIDSNOdd(){
            ArrayList<String> maSousListe = new ArrayList<>();
            for (int i = 0; i<this.getListDeLivres().size(); i++){

                Livre monLivreATester = this.getListDeLivres().get(i);

                if (monLivreATester.getIndiceRef() % 2 == 1){
                    maSousListe.add(monLivreATester.getTitre() + " / " + monLivreATester.getIndiceRef());
                }

            }
            return maSousListe;
        }





        public void AddBook(Livre livre){




              if(!verifyIndiceRefOfBook(livre.getIndiceRef())){
                  listDeLivres.add(livre);
                  JOptionPane.showMessageDialog(null, "Livre Ajouté");

              }else{
                  JOptionPane.showMessageDialog(null, "Le livre existe déjà");

              }
            //return listDeLivres;
        }







    private boolean verifyIndiceRefOfBook(int indiceRef) {

        boolean isAlredyExist = false;

        for (int i = 0; i<listDeLivres.size() ; i++){

            if (listDeLivres.get(i).getIndiceRef() == indiceRef){
                isAlredyExist = true;
                return isAlredyExist;
            }

        }

        return isAlredyExist;
    }










    }

