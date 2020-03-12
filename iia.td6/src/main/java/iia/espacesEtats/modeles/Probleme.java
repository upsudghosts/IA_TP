package iia.espacesEtats.modeles;

/**
 * Un problème se caractérise par 
 * - un nom 
 * - un état initial, 
 * - une méthode qui selon le problème posé détermine si un état 
 *   est un état terminal (ou but)
 *
 * @author Philippe Chatalic
 * @author Alexandre Allauzen
 */
public interface Probleme {

    /**
     * @return l'état initial du problème
     */
    public Etat getEtatInitial();

     /**
     * @return vrai si l'état est Terminal pour ce problème
     */
    public abstract boolean isTerminal(Etat e);

   /**
     * @return Une représentation du problème sous forme de chaîne
     */
    @Override
    public String toString();

}