package nl.sey.cursus;

public class Cursus {
	
	public static final String STICHTING = "Empower Yourself";

	private String titel = null;
	public String[] deelnemers = {"Alice", "Bob", "Charlie"};
			
	public Cursus(String _titel) {
		titel = _titel;
	}

	public String getOmschrijving() {
		String omschrijving = "cursus " + titel;
		return omschrijving + " van stichting " + STICHTING;
	}
	
	public String getDeelnemers() {
		String tekst = "Er zijn nog geen deelnemers.";
		if(deelnemers.length > 0) {
			tekst = "Er zijn " + deelnemers.length + " deelnemers, namelijk:";
			for(int i=0; i<deelnemers.length; i++) {
				tekst = tekst + " " + deelnemers[i];
			}
		}
		return tekst;
	}
	
	public static void main(String[] args) {
		Cursus mijnCursus = new Cursus("Java Tester");
		mijnCursus.deelnemers[1] = "Bernadette";
        System.out.println("Welkom bij "+ mijnCursus.getOmschrijving());
        System.out.println(mijnCursus.getDeelnemers());
	}

}
