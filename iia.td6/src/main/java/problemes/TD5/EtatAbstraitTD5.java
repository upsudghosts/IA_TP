package problemes.TD5;

import iia.espacesEtats.modeles.Etat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedList;


    // Constantes ----------------------------------------------------------
    /**
 * Formalisation d'un domaine abstrait de problme.
 * problÃ¨me de recherche dans un graphe d'tats.
 * 
 * @author  Philippe Chatalic
 */
public enum EtatAbstraitTD5 implements Etat {
    
    /* Les noms des tats */
    A,B,C,D,E,F,G,H,I,J,K,T,W;

    @Override
    public Collection<Etat> successeurs() {
        LinkedList<Etat> result;
        EnumSet<EtatAbstraitTD5> s;
        switch (this) {
            case A : return new LinkedList<Etat>(EnumSet.of(B,C,D,E));
            case B : return new LinkedList<Etat>(EnumSet.of(A,F,G));
            case C : return new LinkedList<Etat>(EnumSet.of(A,H,I));
            case D : return new LinkedList<Etat>(EnumSet.of(W));
            case E : return new LinkedList<Etat>(EnumSet.of(J));
            case F : return new LinkedList<Etat>(EnumSet.of(A,H));
            case G : return new LinkedList<Etat>(EnumSet.of(C));
            case H : return new LinkedList<Etat>(EnumSet.of(K));
            case I : return new LinkedList<Etat>(EnumSet.of(T));
            case J : return new LinkedList<Etat>(EnumSet.of(W));
            default :  return new LinkedList<Etat>();
        }
    }
    
       @Override
    public String toString() {
        switch (this) {
            case A : return "A";
            case B : return "B";
            case C : return "C";
            case D : return "D";
            case E : return "E";
            case F : return "F";
            case G : return "G";
            case H : return "H";
            case I : return "I";
            case J : return "J";
            case T : return "T";
            default /* W */ :  return "W";
        }
    }
    
}

    
   

