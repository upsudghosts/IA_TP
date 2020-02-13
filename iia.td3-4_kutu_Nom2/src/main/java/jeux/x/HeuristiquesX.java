package jeux.x;

import java.util.ArrayList;

import iia.jeux.alg.Heuristique;
import iia.jeux.modele.CoupJeu;
import jeux.x.CoupX;
import iia.jeux.modele.PlateauJeu;
import iia.jeux.modele.joueur.Joueur;

public class HeuristiquesX {

	/** Le joueur que joue "Blanc" */
	private static Joueur joueurBlanc;

	/** Le joueur que joue "noir" */
	private static Joueur joueurNoir;

	public  static void setJoueurs(Joueur jb, Joueur jn) {
		joueurBlanc = jb;
		joueurNoir = jn;
	}
	

	public static  Heuristique hblanc = new Heuristique(){
		
		public  void setJoueurs(Joueur jb, Joueur jn) {
			joueurBlanc = jb;
			joueurNoir = jn;
		}
		

		public int eval(PlateauJeu p, Joueur j){
			if(j.equals(joueurBlanc)) {
				return  HeuristiquesX.score(p,j) - HeuristiquesX.score(p,joueurNoir);
			}else {
				return HeuristiquesX.score(p,joueurNoir) - HeuristiquesX.score(p,j);
			}	
		}
	};

	public static  Heuristique hnoir = new Heuristique(){

		public  void setJoueurs(Joueur jb, Joueur jn) {
			joueurBlanc = jb;
			joueurNoir = jn;
		}
		
		public int eval(PlateauJeu p, Joueur j){
			if(j.equals(joueurNoir)) {
				return  HeuristiquesX.score(p,j) - HeuristiquesX.score(p,joueurBlanc);
			}else {
				return HeuristiquesX.score(p,joueurBlanc) - HeuristiquesX.score(p,j);
			}
		}
	};
	
	public static int score(PlateauJeu p, Joueur j) {
		int temp = 0;
		ArrayList<CoupJeu> cp = p.coupsPossibles(j);
		
		for(int i = 0; i < cp.size(); i++) {
			temp += ((CoupX)cp.get(i)).getScore();
		}
	}
}
