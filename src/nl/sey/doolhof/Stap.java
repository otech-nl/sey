package nl.sey.doolhof;

public class Stap {
    int rij;
    int kolom;
    Stap vorige;

    public Stap(int rij, int kolom, Stap vorige) {
    	this.rij = rij;
    	this.kolom = kolom;
    	this.vorige = vorige;
    }

    public Stap(int rij, int kolom) {
    	this(rij, kolom, null);
    }

    public Stap(Stap vorige, int[] richting) {
        this(vorige.rij + richting[0], vorige.kolom + richting[1], vorige);
    }

    public int getRij() {
        return rij;
    }

    public int getKolom() {
        return kolom;
    }

    public Stap getVorige() {
        return vorige;
    }
    
    public String toString() {
    	return "rij: "+rij+", kolom: "+kolom;
    }
}
