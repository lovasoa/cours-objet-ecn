package sirop;

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
        plateau.ajouterRobotNeuneu("Patrick Jaifaim", new Point2D(0,0));
        
        plateau.tourDeJeu();
    }
    
}
