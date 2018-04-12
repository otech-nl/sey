package nl.sey.cursus2;

import java.util.ArrayList;
import java.util.List;

public class Cursus {
	
	public static final String STICHTING = "Empower Yourself";

	private String titel = null;
	private List<Deelnemer> deelnemers;
			
	public Cursus(String _titel) {
		titel = _titel;
		deelnemers = new ArrayList<Deelnemer>();
		deelnemers.add(new Deelnemer("Aalten", "Alice van"));
		deelnemers.add(new Deelnemer("Robertsen", "Bob"));
		deelnemers.add(new Deelnemer("Claassen", "Charlie"));
	}

	public String toString() {
		String omschrijving = String.format("cursus %s van stichting %s",
				titel, STICHTING);

		String tekst = "Er zijn nog geen deelnemers.";
		if(deelnemers.size() > 0) {
			tekst = "Er zijn " + deelnemers.size() + " deelnemers, namelijk:";
			for(Deelnemer deelnemer: deelnemers) {
				tekst = tekst + " " + deelnemer.getNaam();
			}
		}
		return omschrijving + "\n" + tekst;
	}
	
	public static void main(String[] args) {
		Cursus mijnCursus = new Cursus("Java Tester");
		mijnCursus.deelnemers.set(1, new Deelnemer("Berends", "Bernadette"));
        System.out.println("Welkom bij "+ mijnCursus.toString());
	}

}
