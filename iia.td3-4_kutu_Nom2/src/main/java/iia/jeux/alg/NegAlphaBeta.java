package iia.jeux.alg;

import java.util.ArrayList;

import iia.jeux.modele.CoupJeu;
import iia.jeux.modele.PlateauJeu;
import iia.jeux.modele.joueur.Joueur;

public class NegAlphaBeta implements AlgoJeu {

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
    public NegAlphaBeta(Heuristique h, Joueur joueurMax, Joueur joueurMin) {
        this(h,joueurMax,joueurMin,PROFMAXDEFAUT);
    }

    public NegAlphaBeta(Heuristique h, Joueur joueurMax, Joueur joueurMin, int profMaxi) {
        this.h = h;
        this.joueurMin = joueurMin;
        this.joueurMax = joueurMax;
        profMax = profMaxi;
//		System.out.println("Initialisation d'un MiniMax de profondeur " + profMax);
    }




   // -------------------------------------------
  // Méthodes de l'interface AlgoJeu
  // -------------------------------------------
   public CoupJeu meilleurCoup(PlateauJeu p) {
        /* A vous de compléter le corps de ce fichier */
	   int profondeur=profMax;
	   ArrayList<CoupJeu> coupsPossible = p.coupsPossibles(this.joueurMax);
	   long  Max = NegAlphaBeta(p , this.joueurMax,-1000000,1000000,1,  profondeur );
	   CoupJeu meilleurCoup = coupsPossible.get(0); 
	   for( CoupJeu coup : coupsPossible ) {
		   	PlateauJeu temp = p.copy();
			temp.joue(this.joueurMax, coup);
			long NewVal=NegAlphaBeta(temp,this.joueurMax,-1000000,1000000,1, (profondeur-1));
		
			if(NewVal> Max  ) {
				System.out.print(" validité du coup :" +p.coupValide(this.joueurMax, coup)+"////"+coup.toString()); 
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

    
    public long NegAlphaBeta( PlateauJeu p , Joueur j ,long alpha, long beta , int parite,int profondeur) {
    	ArrayList<CoupJeu> coups = p.coupsPossibles(j);
    	if( profondeur == 0 ) {
    		h.setJoueurs(this.joueurMax, this.joueurMin);; 
    		int Max= h.eval(p, j)*parite;
    	}else {
    		for( CoupJeu coup : coups ) {
    			PlateauJeu temp = p.copy();
    			temp.joue(j, coup);
                alpha = Math.max(alpha, -NegAlphaBeta(temp,j,-beta,-alpha,-parite,(profondeur-1)));
                	if (alpha>= beta ) {
                		return beta; 
                }
            }
    	}
		return alpha;  
    	
    }
    
    //A vous de jouer pour implanter Minimax

}
