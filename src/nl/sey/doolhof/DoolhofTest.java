package nl.sey.doolhof;

import nl.sey.doolhof.algoritme.Iteratief;
import nl.sey.doolhof.algoritme.Algoritme;
import nl.sey.doolhof.algoritme.Recursief;

public class DoolhofTest {
	
    public static void main(String[] args) throws Exception {
    	Algoritme[] algoritmes = {new Iteratief(), new Recursief()};
    	for(int i=1; i<=2; i++) {
            Doolhof doolhof = new Doolhof("src/nl/sey/doolhof/data/"+i+".txt");
            for(Algoritme algoritme: algoritmes) {
                System.out.println(algoritme);
                if(doolhof.zoekOplossing(algoritme)) {
                	System.out.println(doolhof);
                } else {
                	System.err.println("GEEN OPLOSSING");
                }
            }
    	}
    }
}
