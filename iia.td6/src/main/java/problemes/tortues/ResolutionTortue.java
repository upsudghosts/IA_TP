package problemes.tortues;

import iia.espacesEtats.algorithmes.*;
import iia.espacesEtats.modeles.*;

/**
 * Exemple de r�solution de probl�me
 *
 * @author Philippe Chatalic
 * @author Alexandre Allauzen
 */
public class ResolutionTortue {

    public static void main(String[] args) {
        /* D�finition d'un probl�me � partir d'un �tat initial */
        Probleme pb = new ProblemeTortue(new EtatTortue());
        
        /* Choix de l'algorithme de r�solution*/     
        AlgorithmeRechercheEE algo = new RechercheEnProfondeurSimple();      // Mettre le bon algorithme ici 
        
        /* La solution, si elle est trouv� est retourn�e sous forme d'une
         * liste de noeuds allant de l'�tat initial � l'�tat final
         */
        Solution sol = algo.chercheSolution(pb);
        if (sol != null) {
            System.out.println("Solution trouv�e : ");
            sol.affiche();
            System.out.println("Nombre total de noeuds d�velopp�s : " + algo.getNbNoeudsDeveloppes());
       } else {
            System.out.println("Echec !");
        }
    }
}
