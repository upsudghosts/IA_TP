package jeux.x;

import iia.jeux.modele.CoupJeu;
import iia.jeux.modele.PlateauJeu;
import iia.jeux.modele.joueur.Joueur;
import jeux.x.CoupX;

import java.util.ArrayList;

public class PlateauX implements PlateauJeu {

    /* Pour coder un nouveau jeu... il faut au minimum coder
     * - Une classe PlateauX pour représenter l'état du "plateau"
     *  de ce jeu.
     *  Cette classe doit fournir le code des méthodes de l'interface PlateauJeu
     *  qui permettent de caractériser les règles du jeu
     *  Une classe CoupX qui
     */
	
	/* *********** constantes *********** */

	/** Taille des grilles */
	public final static int TAILLE = 12;
	public final static int TAILLE_C = 2;
	
	/* *********** Paramètres de classe *********** */

	private final static int VIDE = 0;

	
	/* *********** Attributs  *********** */

	/** le damier */
	private int damier[];
	
	/**les cagnottes */
	private int cagnotte[];

	/** Le joueur que joue "Blanc" */
	private static Joueur joueurBlanc;

	/** Le joueur que joue "noir" */
	private static Joueur joueurNoir;

	/************* Gestion des paramètres de classe** ****************/ 

	public static void setJoueurs(Joueur jb, Joueur jn) {
		joueurBlanc = jb;
		joueurNoir = jn;
	}

	/************* Constructeurs ****************/ 

	public PlateauX(){
		damier = new int[TAILLE];
		cagnotte = new int [TAILLE_C];
		
		for(int i=0; i < TAILLE; i++) {
			damier[i] = VIDE;
		}
		
		for(int i=0; i< TAILLE_C; i++) {
			cagnotte[i]= VIDE;
		} 
	}

	public PlateauX(int depuis[]){
		damier = new int[TAILLE];
		for(int i=0; i < TAILLE; i++)
				damier[i] = depuis[i];
	}


    /* A Faire */
    public ArrayList<CoupJeu> coupsPossibles(Joueur j) {
		ArrayList<CoupJeu> lesCoupsPossibles = new ArrayList<CoupJeu>();
		if (j.equals(joueurBlanc)) {
			for(int i=TAILLE/2 ; i < TAILLE ; i++) { // toutes les lignes				
					if( (damier[i]!=VIDE) ) // on peut jouer
						lesCoupsPossibles.add(new CoupX(i, damier[i]));
			}	
		}
		
		else{
			for(int i=0 ; i < TAILLE-1 ; i++) { // toutes les lignes qui passent
				if( (damier[i+1]==VIDE) && (damier[i+1]==VIDE) )  // on peut jouer
						lesCoupsPossibles.add(new CoupX(i,damier[i]));
			}
		}
			
		return lesCoupsPossibles;
    }
    

    public void joue(Joueur j, CoupJeu c) {
   }

    public boolean finDePartie() {
         throw new UnsupportedOperationException("Il vous faut coder cette méthode");
   }

    public PlateauJeu copy() {
          throw new UnsupportedOperationException("Il vous faut coder cette méthode");
    }

    public boolean coupValide(Joueur j, CoupJeu c) {
          throw new UnsupportedOperationException("Il vous faut coder cette méthode");
    }

    
	
	
}
