package problemes.tsp;

import java.util.LinkedList;

import iia.espacesEtats.modeles.Etat;
import iia.espacesEtats.modeles.Heuristique; 

public class HeuristiqueTSP implements Heuristique{

	@Override
	public float eval(Etat e) {
		// TODO Auto-generated method stub
		int minidistance=0;
		CarteRoutiereRoumanie carte = ((EtatTSP) e).CARTE; 
		LinkedList<String> aParcourir= ((EtatTSP) e).getaParcourir();
		for (String v : aParcourir) {
			minidistance+=carte.routeLaPlusCourte(v);
		}
		return minidistance;
	}


}