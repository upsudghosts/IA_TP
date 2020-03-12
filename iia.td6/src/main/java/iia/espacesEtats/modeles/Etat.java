package iia.espacesEtats.modeles;

import java.util.Collection;

/**
 * L'interface d'un état est succincte, tout ce dont on a besoin pour un état
 * est : 
 * - que l'on soit capable de calculer ses successeurs
 * - que l'on puisse l'afficher d'une manière standard pour visualiser un chemin 
 * - et que la fonction equals soit redéfinie de manière adéquate.
 */
public interface Etat {


    /**
     * @param e l'état considéré
     * @return L'ensemble des états atteignables à partir de l'état par un
     * opérateur de changement d'état L'utilisation d'une Collection permet de
     * choisir librement La classe la mieux adaptée en fonction du problème
     */
    public Collection<Etat> successeurs();

    @Override
    public boolean equals(Object obj);

    /**
     * @return Une représentation de l'état sous forme de chaîne
     */
    @Override
    public String toString();
}
