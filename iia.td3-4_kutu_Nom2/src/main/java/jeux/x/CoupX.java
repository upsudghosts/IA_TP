package jeux.x;

import iia.jeux.modele.CoupJeu;

public class CoupX implements CoupJeu{
	/****** Attributs *******/ 
	private int colonne, graines, score;
	
	public CoupX(int c, int g, int s) {
		this.colonne = c;
		this.graines = g;
		this.score = s;
	}
	
	/****** Accesseurs *******/ 
	public int getColonne() {
		return this.colonne;
	}
	
	public int getGraines() {
		return this.graines;
	}
	
	public int getScore() {
		return this.score;
	}

	/****** Accesseurs *******/ 

	public String toString() {
		return "("+this.colonne+")";
	}
	     
}
