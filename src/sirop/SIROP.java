package sirop;

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
    public static void main(String[] args){
        System.out.println("Welcome to SIROP!");
        
        /** Création du plateau **/
        PlateauJeu plateau = new PlateauJeu(10,10);
        /** Ajout d'éléments sur le plateau **/
        plateau.ajouterRobotNeuneu("Patrick Jaifaim", new Point2D(5,1));
        
      try {
        SauvegardePartie sauvegarde = new SauvegardePartie(plateau);
      } catch (IOException ex) {
        ex.printStackTrace();
        System.exit(5);
      }
              
        plateau.tourDeJeu();
    }
    
}
