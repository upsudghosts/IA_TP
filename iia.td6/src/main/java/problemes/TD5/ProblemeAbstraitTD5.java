package problemes.TD5;

import problemes.tortues.*;
import iia.espacesEtats.modeles.Etat;
import iia.espacesEtats.modeles.Probleme;

/**
 * Mod�lisation du probl�me des tortues
 * 
 * @author Philippe Chatalic
 */
public class ProblemeAbstraitTD5 implements Probleme {
    
    // Attributs  -------------------------------------------------------
    private EtatAbstraitTD5 etatInitial;
    
    private String descriptionBut = "But : Atteindre T ou W\n";

    // Constructeurs -------------------------------------------------------
    public ProblemeAbstraitTD5(Etat eInit) {
        try{
                    this.etatInitial = (EtatAbstraitTD5) eInit;
        }
        catch (Exception e) {
            throw new RuntimeException("Un ProblemeAbstraitTD5 doit se cr�er � partir d'un EtatAbstraitTD5 ! ");
        }
    }

    public ProblemeAbstraitTD5(Etat eInit,String description) {
         this(eInit);
         descriptionBut = description;
         
    }

    // M�thodes requises par l'interface Probleme
    
    @Override
    public Etat getEtatInitial() {
        return etatInitial;
    }
    
    
    @Override
    public boolean isTerminal(Etat e) {
        if (!(e instanceof EtatAbstraitTD5)) {
            return false;
        }
        EtatAbstraitTD5 ea = (EtatAbstraitTD5) e;
        return ea.equals(EtatAbstraitTD5.T) || ea.equals(EtatAbstraitTD5.W);
    }

    
   /** M�thodes abstraites de la classe Probl�me  � instancier **/
    @Override
    public String toString() {
        return "Etat initial : " + etatInitial + "\n"
              + descriptionBut;
    }
   
}
