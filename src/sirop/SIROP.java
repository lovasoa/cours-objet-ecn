package sirop;

import java.io.IOError;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zhaoshuli
 */
public class SIROP {
    static String nomFichier = "plateau.txt";
    public static void main(String[] args){
        System.out.println("Welcome to SIROP!");
        
        /** Création du plateau **/
        PlateauJeu plateau;
        try {
          plateau = SauvegardePartie.load(nomFichier);
        } catch (IOException e) {
          System.err.println("Impossible de charger un plateau de jeu existant.");
          plateau = new PlateauJeu(10,10);
        }
              
        plateau.tourDeJeu();
        
                
      try {
        SauvegardePartie.save(nomFichier, plateau);
      } catch (IOException ex) {
        ex.printStackTrace();
        System.exit(5);
      }
      
    }
    
}
