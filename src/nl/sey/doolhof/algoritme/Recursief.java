package nl.sey.doolhof.algoritme;

import java.util.LinkedList;
import java.util.List;

import nl.sey.doolhof.Stap;
import nl.sey.doolhof.Veld;
import nl.sey.doolhof.VeldType;
import nl.sey.doolhof.Doolhof;

public class Recursief extends Algoritme {

    protected List<Stap> zoekOplossing(Doolhof doolhof, Stap stap) {
    	Veld veld = doolhof.getVeld(stap);
        if((veld == null) || !veld.isOpen()) {
            return null;
        }

        if (veld.isType(VeldType.DOEL)) {
            return new LinkedList<>();
        }

        veld.setBezocht();
        for (int[] richting : RICHTINGEN) {
            List<Stap> pad = zoekOplossing(doolhof, new Stap(stap, richting));
            if(pad != null) {
            	if(!veld.isType(VeldType.START)) {
            		veld.setPad();
            		pad.add(0, stap);
            	}
                return pad;
            }
        }

        return null;
    }
}
