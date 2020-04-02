package iia.espacesEtats.algorithmes;

import iia.espacesEtats.modeles.Probleme;
import iia.espacesEtats.modeles.Solution;

/**
 *  Interface minimale d'un algorithme de résolution de problème
 *  de recjercje dans un graphe d'états
 *  
 * @author Philippe Chatalic
 */

public interface AlgorithmeRechercheEE {

    /**
     * Recherche un chemin solution pour un problème formulé en terme de
     * recherche dans un espace d'états
     *
     * @param p le problème à résoudre
     * @return une solution du problème
     */
    public Solution chercheSolution(Probleme p);
}
