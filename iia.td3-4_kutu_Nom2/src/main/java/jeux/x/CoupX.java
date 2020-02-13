package jeux.x;

import iia.jeux.modele.CoupJeu;

public class CoupX implements CoupJeu{
	/****** Attributs *******/ 
	private int colonne;
	
	public CoupX(int c) {
		this.colonne = c;
	}
	
	/****** Accesseurs *******/ 
	public int getColonne() {
		return this.colonne;
	}

	/****** Accesseurs *******/ 

	public String toString() {
		return "("+this.colonne+")";
	}
	     
}
