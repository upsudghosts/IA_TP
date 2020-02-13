package iia.jeux.alg;

import java.util.ArrayList;

import iia.jeux.modele.CoupJeu;
import iia.jeux.modele.PlateauJeu;
import iia.jeux.modele.joueur.Joueur;

public class Aléatoire  implements AlgoJeu {
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
	    public Aléatoire(Heuristique h, Joueur joueurMax, Joueur joueurMin) {
	        this(h,joueurMax,joueurMin,PROFMAXDEFAUT);
	    }

	    public Aléatoire(Heuristique h, Joueur joueurMax, Joueur joueurMin, int profMaxi) {
	        this.h = h;
	        this.joueurMin = joueurMin;
	        this.joueurMax = joueurMax;
	        profMax = profMaxi;
//			System.out.println("Initialisation d'un MiniMax de profondeur " + profMax);
	    }

	    
	public CoupJeu meilleurCoup(PlateauJeu p) {
		int rdn=0;
		ArrayList<CoupJeu> coupsPossible = p.coupsPossibles(this.joueurMax);
		int nombreAleatoire = 0 + (int)(Math.random() * ((coupsPossible.size() - 0) + 1));
		CoupJeu coup= coupsPossible.get(nombreAleatoire);
		System.out.print(coup.toString()+"  ");
			while( p.coupValide(this.joueurMax, coup) ) {
				System.out.print(" validité du coup :" +p.coupValide(this.joueurMax, coup)+"////"+coup.toString()); 
				rdn = 0 + (int)(Math.random() * ((coupsPossible.size() - 0) + 1))-1;
				coup= coupsPossible.get(rdn);
				System.out.print(coup.toString()+"  ");
			}
		return coup; 
	};
}
