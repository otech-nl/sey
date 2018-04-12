package nl.sey.doolhof.algoritme;

import java.util.LinkedList;
import java.util.List;

import nl.sey.doolhof.Stap;
import nl.sey.doolhof.Veld;
import nl.sey.doolhof.VeldType;
import nl.sey.doolhof.Doolhof;

public class Iteratief extends Algoritme {
    
    protected List<Stap> zoekOplossing(Doolhof doolhof, Stap start) {
        LinkedList<Stap> pogingen = new LinkedList<>();
        pogingen.add(start);

        while (!pogingen.isEmpty()) {
            Stap stap = pogingen.remove();
            Veld veld = doolhof.getVeld(stap);
            if((veld == null) || !veld.isOpen()) {
                continue;
            }

            if (veld.isType(VeldType.DOEL)) {
                return toonPad(doolhof, stap);
            }

            veld.setBezocht();
            for (int[] richting : RICHTINGEN) {
                Stap poging = new Stap(stap, richting);
                pogingen.add(poging);
            }
        }
        return null;
    }

    private List<Stap> toonPad(Doolhof doolhof, Stap stap) {
        LinkedList<Stap> pad = new LinkedList<>();
        while (stap != null) {
        	pad.add(0, stap);
        	Veld veld = doolhof.getVeld(stap);
        	veld.setPad();
            stap = stap.getVorige();
        }
        return pad;
    }
}
