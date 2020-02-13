/**
 * 
 */

package iia.jeux.alg;

import java.util.ArrayList;
import java.lang.Math;
import iia.jeux.modele.CoupJeu;
import iia.jeux.modele.PlateauJeu;
import iia.jeux.modele.joueur.Joueur;

public class Minimax implements AlgoJeu {

    /** La profondeur de recherche par défaut
     */
    private final static int PROFMAXDEFAUT = 4;

   
    // -------------------------------------------
    // Attributs
    // -------------------------------------------
 
    /**  La profondeur de recherche utilisée pour l'algorithme
     */
    private int profMax = PROFMAXDEFAUT;

     /**  L'heuristique utilisée par l'algorithme
      */
   private Heuristique h;

    /** Le joueur Min
     *  (l'adversaire) */
    private Joueur joueurMin;

    /** Le joueur Max
     * (celui dont l'algorithme de recherche adopte le point de vue) */
    private Joueur joueurMax;

    /**  Le nombre de noeuds développé par l'algorithme
     * (intéressant pour se faire une idée du nombre de noeuds développés) */
       private int nbnoeuds;

    /** Le nombre de feuilles évaluées par l'algorithme
     */
    private int nbfeuilles;


  // -------------------------------------------
  // Constructeurs
  // -------------------------------------------
    public Minimax(Heuristique h, Joueur joueurMax, Joueur joueurMin) {
        this(h,joueurMax,joueurMin,PROFMAXDEFAUT);
    }

    public Minimax(Heuristique h, Joueur joueurMax, Joueur joueurMin, int profMaxi) {
        this.h = h;
        this.joueurMin = joueurMin;
        this.joueurMax = joueurMax;
        profMax = profMaxi;
//		System.out.println("Initialisation d'un MiniMax de profondeur " + profMax);
    }
    public long maxMin( PlateauJeu p , Joueur j , int profondeur) {
    	ArrayList<CoupJeu> coups = p.coupsPossibles(j);
    	if( profondeur == 0 ) {
    		h.setJoueurs(this.joueurMax, this.joueurMin);; 
    		return h.eval(p, j);
    	}else {
    		long  max = -100000000 ;
    		for( CoupJeu coup : coups ) {
    			PlateauJeu temp = p.copy();
    			temp.joue(j, coup);
                max = Math.max(max, minMax(temp,j,(profondeur-1)));
            }
    		return max;
    	}  
    	
    }

    public long minMax( PlateauJeu p , Joueur j , int profondeur) {
    	ArrayList<CoupJeu> coups = p.coupsPossibles(j);
    	if( profondeur == 0 ) {
    		h.setJoueurs(this.joueurMax, this.joueurMin);
    		return h.eval(p, j);
    	}else {
    		long  min = 100000000 ;
    		for( CoupJeu coup : coups ) {
    			PlateauJeu temp = p.copy(); 
    			temp.joue(j, coup);
                min = Math.max(min, maxMin(temp,j,(profondeur-1)));
            }
    		return min;
    	}  
    	
    }

   // -------------------------------------------
  // Méthodes de l'interface AlgoJeu
  // -------------------------------------------
   public CoupJeu meilleurCoup(PlateauJeu p) {
        /* A vous de compléter le corps de ce fichier */
	   int profondeur=profMax;
	   ArrayList<CoupJeu> coupsPossible = p.coupsPossibles(this.joueurMax);
	   long  Max = minMax(p , this.joueurMax,  profondeur );
	   CoupJeu meilleurCoup = coupsPossible.get(0); 
	   for( CoupJeu coup : coupsPossible ) {
		   	PlateauJeu temp = p.copy();
			temp.joue(this.joueurMax, coup);
			long NewVal=minMax(temp,this.joueurMax, (profondeur-1));
			
			if(NewVal> Max &&  (p.coupValide(this.joueurMax, coup)) ) {
				meilleurCoup=coup; 
				Max=NewVal; 
			}
       }
        return meilleurCoup;

    }
  // -------------------------------------------
  // Méthodes publiques
  // -------------------------------------------
    public String toString() {
        return "MiniMax(ProfMax="+profMax+")";
    }



  // -------------------------------------------
  // Méthodes internes
  // -------------------------------------------

    //A vous de jouer pour implanter Minimax

}
