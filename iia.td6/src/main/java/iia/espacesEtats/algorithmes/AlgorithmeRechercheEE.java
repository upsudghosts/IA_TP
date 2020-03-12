package iia.espacesEtats.algorithmes;

import iia.espacesEtats.modeles.Probleme;
import iia.espacesEtats.modeles.Solution;

/**
 * Interface minimale d'un algorithme de résolution de problème de recherche
 * dans un graphe d'états
 *
 * @author Philippe Chatalic
 */
public abstract class AlgorithmeRechercheEE {

    // Attributs 
    protected int nbNoeudsDeveloppes;   // Accessible dans les classes dérivées

    //----------------------------------------------------
    // Constructeurs
    //----------------------------------------------------
    AlgorithmeRechercheEE() {
        nbNoeudsDeveloppes = 0;
    }

    //----------------------------------------------------
    // Accesseurs modifieurs
    //----------------------------------------------------
     /**
     * Renvoie le nombre de noeuds développés par l'algorithme
     *
     * @return le nombre de noeuds développés
     */
    public int getNbNoeudsDeveloppes() {
        return nbNoeudsDeveloppes;
    }
    
     //----------------------------------------------------
    // Méthode(s) abstraite(s)
    //----------------------------------------------------
 
    /**
     * Recherche un chemin solution pour un problème formulé en terme de
     * recherche dans un espace d'états
     *
     * @param p le problème à résoudre
     * @return une solution du problème
     */
    public abstract Solution chercheSolution(Probleme p);


}
