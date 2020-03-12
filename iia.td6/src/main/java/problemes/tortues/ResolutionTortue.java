package problemes.tortues;

import iia.espacesEtats.algorithmes.*;
import iia.espacesEtats.modeles.*;

/**
 * Exemple de résolution de problème
 *
 * @author Philippe Chatalic
 * @author Alexandre Allauzen
 */
public class ResolutionTortue {

    public static void main(String[] args) {
        /* Définition d'un problème à partir d'un état initial */
        Probleme pb = new ProblemeTortue(new EtatTortue());
        
        /* Choix de l'algorithme de résolution*/     
        AlgorithmeRechercheEE algo = null;      // Mettre le bon algorithme ici 
        
        /* La solution, si elle est trouvé est retournée sous forme d'une
         * liste de noeuds allant de l'état initial à l'état final
         */
        Solution sol = algo.chercheSolution(pb);
        if (sol != null) {
            System.out.println("Solution trouvée : ");
            sol.affiche();
            System.out.println("Nombre total de noeuds développés : " + algo.getNbNoeudsDeveloppes());
       } else {
            System.out.println("Echec !");
        }
    }
}
