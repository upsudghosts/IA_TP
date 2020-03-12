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
    	Noeud currN = new Noeud();
    	
    	Etat currE;
    
    	currE = p.getEtatInitial();
    	currN.setEtat(currE);
    	currN.setPere(currN);
    	
    	graphe.add(currN);
   		front.add(currE);
      
       	do { 		
       		currE = front.get(0);
       		currN.setEtat(currE);
        	
        	if(p.isTerminal(currE)) {
       			do{
       				sol.add(currN.getEtat());
       				currN = currN.getPere();
       			}while(!currN.memeEtat(p.getEtatInitial())) ;
       			return sol;
       			
       		} else {
       			Etat[] succ = currE.successeurs().toArray(new Etat[currE.successeurs().size()]);
        		front.remove(currE);
        		currN.setPere(currN);
        			
        		for(int i = 0; i < succ.length; i++) {
        			front.add(i,succ[i]);
        			currN.setEtat(succ[i]);
       				graphe.add(currN);
       			}
       		}
        		
       	}while(!front.isEmpty());

        return sol;
    }
        
}
