package nl.sey.doolhof.algoritme;

import java.util.List;

import nl.sey.doolhof.Doolhof;
import nl.sey.doolhof.Stap;

public abstract class Algoritme {
    protected static final int[][] RICHTINGEN = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean zoekOplossing(Doolhof doolhof) {
        return zoekOplossing(doolhof, doolhof.getStart()) != null;
    }

    protected abstract List<Stap> zoekOplossing(Doolhof doolhof, Stap stap);
    
    public String toString() {
    	return this.getClass().getName();
    }
}
