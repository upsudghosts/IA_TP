package iia.espacesEtats.algorithmes;
/*
 * AEtoile.java
 */

import java.util.ArrayList;

import iia.espacesEtats.graphes.Noeud;
import iia.espacesEtats.modeles.Etat;
import iia.espacesEtats.modeles.Heuristique;
import iia.espacesEtats.modeles.Probleme;
import iia.espacesEtats.modeles.ProblemeACout;
import iia.espacesEtats.modeles.Solution;

/**
 * La classe qui implémente l'algo A*
 * 
 * A completer !
 */
public class AEtoile implements AlgorithmeHeuristiqueRechercheEE {

    private Heuristique h;
    private int noeudsDeveloppe = 0;


    /* Constructeur de base */
    public AEtoile(Heuristique h) {
        this.h = h;
    }

    /* Lance l'exploration sur un problème */
    public Solution chercheSolution(Probleme p) {
    	
    	ProblemeACout pc = new ProblemeACout(p.getEtatInitial(), p.getNom());
    	
        Solution sol = null;
        Noeud currN = new Noeud(),
        	  m = new Noeud();
     
        ArrayList<Noeud> OUVERT= new ArrayList<Noeud>(),
        				 FERME = new ArrayList<Noeud>();
        
        float g,h;
        float f, f_comp;
        currN.setEtat(p.getEtatInitial());
        currN.setPere(null);
        OUVERT.add(currN);

        while(!OUVERT.isEmpty()) {
        	m = OUVERT.get(0);
        	//Recherche dans OUVERT du Noeud ayant le plus faible F*
    		//Par défaut c'est le premier
        	for(Noeud n : OUVERT) {
        		//Calcul du F*
        		f = g + this.h.eval(n.getEtat());
        		f_comp = g + this.h.eval(m.getEtat());
        		//Comparaison avec le F* de m
        		//Si fonction evaluation plus faible alors 
        		if(f <= f_comp) m = n;
        		FERME.add(m);
        		//Calcul du cout du trajet du père jusqu'a l'état courant
        		g += pc.cout(m.getPere().getEtat(),m.getEtat());
        	}
        	
        	FERME.add(m); //On l'ajoute a ferme 
        	Etat currE = m.getEtat();
        	for(Etat fils : p.successeurs(currE)) {
        		//Calcul de F(fils)
				f_comp = g + this.h.eval(fils);
				
        		//Mise à jour du lien de parenté du fils vers m
        		currN.setEtat(fils);
        		currN.setPere(m); 
        		//Si le fils est terminal on calcule la solution pour la renvoyer
        		if(p.isTerminal(fils)) {
        			sol = new Solution();
        			do{
        				//On ajoute l'état courrant
           				sol.add(currN.getEtat());
           				System.out.println("F.add etat");
           				//On remonte au noeud père
           				currN = currN.getPere();
           			//Tant qu'on est pas remonté au noeud initial.
           			}while(currN.getPere() != null) ;
           			return sol;
        		}
        		
        		//Recherche du fils dans nos listes OUVERT et FERME
        		boolean presO = false, presF = false;
        		Noeud nO, nF;
        		
        		for(int i = 0; i < OUVERT.size(); i++) {
        			Noeud n = OUVERT.get(i);
        			if(n.memeEtat(fils)) nO = n;
        			presO = true;
        			break;
        		}
        		
        		for(int i = 0; i < FERME.size(); i++) {
        			Noeud n = FERME.get(i);
        			if(n.memeEtat(fils)) nF = n;
        			presF = true;
        			break;
        		}
        		
        		//Si pas d'occurences du fils dans OUVERT ni FERME
        		//Ajout du fils à OUVERT
        		if(!presO && !presF) OUVERT.add(currN);
        		
        		//Si OUVERT contient un occurence de fils
        		else if(presO && !presF) {
        			//Calcul de F*(k) , avec k l'occurence
        			f = g + this.h.eval(nO.getEtat());
   					//Si F*(k) > F*(fils) alors on remplace k par fils dans OUVERT
        			if(f > f_comp) {
       					OUVERT.remove(nO);
   						OUVERT.add(currN);
   					}
        		}        			
        		
        		//Si FERME contient un occurence de fils
        		else if(!presO && presF) {
        			//Calcule de F*(k) , avec k l'occurence
        			f = g + this.h.eval(nF.getEtat());
        			//Si F*(k) > F*(fils) alors on supprime k de FERME
        			//et on rajoute fils dans OUVERT
        			if(f > f_comp) {
       					FERME.remove(nF);
   						OUVERT.add(currN);
        			}
        		}
        	}
        }
        
        return sol;
    }

    public void setHeuristique(Heuristique h) {
        this.h = h;
    }

    public Heuristique getHeuristique() {
        return h;
    }
}
