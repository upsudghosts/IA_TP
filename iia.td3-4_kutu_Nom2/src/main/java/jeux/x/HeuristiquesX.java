package jeux.x;

import iia.jeux.alg.Heuristique;
import iia.jeux.modele.PlateauJeu;
import iia.jeux.modele.joueur.Joueur;

public class HeuristiquesX {

	public HeuristiquesX() {
		// TODO Auto-generated constructor stub
	}

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
				return  p.coupsPossibles(j).size() - p.coupsPossibles(joueurNoir).size();
			}else {
				return p.coupsPossibles(joueurNoir).size() - p.coupsPossibles(j).size();
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
				return  p.coupsPossibles(j).size() - p.coupsPossibles(joueurBlanc).size();
			}else {
				return p.coupsPossibles(joueurBlanc).size() - p.coupsPossibles(j).size();
			}
		}
	};
}
