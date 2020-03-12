package iia.espacesEtats.algorithmes;

import java.util.ArrayList;

import iia.espacesEtats.graphes.Noeud;
import iia.espacesEtats.modeles.Etat;
import iia.espacesEtats.modeles.Probleme;
import iia.espacesEtats.modeles.Solution;

/**
 * RechercheEnProfondeurSimple
 * une impl�mentation simple de l'algorithme de recherche
 * en profondeur d'abord, sans d�tection de cycles, donc uniquement adapt�e
 * aux espaces d'�tats sans cycles ni branches infinies.
 * 
 * @author <Vous m�me>
 */
public class RechercheEnProfondeurSimple extends AlgorithmeRechercheEE {
	
    //----------------------------------------------------
    // Constructeurs
    //----------------------------------------------------

    public RechercheEnProfondeurSimple() {
        super();
    }

    //----------------------------------------------------
    // Methode(s) requise par la classe abstraite  AlgorithmeRechercheEE
    //----------------------------------------------------

    @Override
    public Solution chercheSolution(Probleme p) {  	
    	ArrayList<Noeud> graphe = new ArrayList<Noeud>();
    	ArrayList<Etat> front = new ArrayList<Etat>();
    	Solution sol = new Solution();
    	
    	Etat initE = p.getEtatInitial();
    	Noeud currN = new Noeud();
    	
    	currN.setEtat(initE);
    	currN.setPere(currN);
    	
    	graphe.add(currN);
    	
    	if(p.isTerminal(initE)) {
    		return new Solution(initE);
    	} else {
    		Etat currE;
    		front.add(initE);
      
        	do { 		
        		currE = front.get(0);
        		
        		currN.setEtat(currE);
        		
        		if(p.isTerminal(currE)) {
        			while(!currN.memeEtat(initE)) {
        				sol.add(currN.getEtat());
        				currN = currN.getPere();
        			}
        			return sol;
        			
        		} else {
        			Etat[] succ = currE.successeurs().toArray(new Etat[currE.successeurs().size()]);
        			front.remove(currE);
          			
        			for(Noeud n : graphe) {
        					if(n.memeEtat(currE)) {
        						currN.setPere(n);
        					}
        				}
          		
        			
        			for(int i = 0; i < succ.length; i++) {
        				front.add(i,succ[i]);
        				currN.setEtat(succ[i]);
        				graphe.add(currN);
        			}
        		}
        		
        	}while(!front.isEmpty());
    	}

        return sol;
    }
        
}
