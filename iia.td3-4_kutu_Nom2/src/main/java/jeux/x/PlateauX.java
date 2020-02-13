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
					if( (damier[i]!=VIDE) ) { // on peut jouer
						lesCoupsPossibles.add(new CoupX(i, damier[i], this.CalculScoreBlanc(i,j)));
					}
			}	
		}
		
		else{
			for(int i=0 ; i < TAILLE-1 ; i++) { // toutes les lignes qui passent
				if( (damier[i+1]==VIDE) && (damier[i+1]==VIDE) )  // on peut jouer
						lesCoupsPossibles.add(new CoupX(i,damier[i],CalculScoreBlanc(i,j)));
			}
		}
			
		return lesCoupsPossibles;
    }
    
    public int CalculScoreBlanc(int colonne , Joueur jj) {
    	int score=0; 
    	PlateauX temp = ((PlateauX)this.copy()); 
    	temp.joue(jj, new CoupX(colonne, temp.damier[colonne],0));
    	if (colonne>= 0 && colonne<TAILLE/2) {
    		for(int i=0 ; i<= colonne ;i++) {
    			if(this.damier[i] != VIDE) {
    				for(int j= colonne ; i<TAILLE/2 ; i++) {
    					if(damier[j]==2 || damier[j]==3) {
    						score+= damier[j];
    					}
    				}
    				return score; 
    			}
    		}
    		return 0; 
    	}
    	return 0; 
    } 

    public int CalculScoreNoir(int colonne , Joueur jj) {
    	int score=0; 
    	PlateauX temp= ((PlateauX)this.copy()); 
    	temp.joue(jj, new CoupX(colonne, temp.damier[colonne],0));
    	if (colonne>= TAILLE/2 && colonne<TAILLE) {
    		for(int i=0 ; i<= colonne ;i++) {
    			if(temp.damier[i] != VIDE) {
    				for(int j= colonne ; i<TAILLE ; i++) {
    					if(temp.damier[j]==2 || temp.damier[j]==3) {
    						score+= temp.damier[j];
    					}
    				}
    				return score; 
    			}
    		}
    		return 0; 
    	}
    	return 0; 
    } 


    public void joue(Joueur j, CoupJeu c) {
    	int graine= ((CoupX)c).getGraines();
    	int colonne= ((CoupX)c).getColonne();
			for(int i=colonne; i < ((CoupX)c).getGraines() ; i++) { // toutes les lignes		
					if ( i%TAILLE != colonne) {
						damier[ i % TAILLE]++; 
						if(j.equals(joueurBlanc)) {
							this.cagnotte[0] = ((CoupX)c).getScore();
						}else {
							this.cagnotte[1] = ((CoupX)c).getScore();
						}
					}
					
			}	
			damier[colonne]=0;
	
    }


    public boolean finDePartie() {
         for(int c : this.cagnotte) {
        	 if (c == 48) {return true;}
         }
         return  false;
   }

    public PlateauJeu copy() {
    	return this;
    }

    public boolean coupValide(Joueur j, CoupJeu c) {
          throw new UnsupportedOperationException("Il vous faut coder cette méthode");
    }
	
}
