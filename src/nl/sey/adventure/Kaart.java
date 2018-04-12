package nl.sey.adventure;

public class Kaart {
	
	private Locatie start;

	/* deze kaart ziet er als volgt uit (je start bij de rivier):
	 * 
	 *    (berg)---(top)
	 *    |
	 *    (rivier)---(monding)
	 */
	public Kaart() {
		start = new Locatie("rivier", "Je staat bij een rivier. Naar het noorden zie je bergen.\n"
				+ "Uit het oosten klinkt het geluid van golven.");
		Locatie locatie2 = new Locatie("monding", "Je staat bij de monding van een rivier. "
				+ "De rivier komt uit het westen.");
		start.verbind('o', locatie2);
		locatie2.verbind('w', start);
		
		Locatie locatie3 = new Locatie("berg", "Je staat aan de voet van een berg. Er ontspringt hier een rivier,\n"
				+ "die naar het zuiden stroomt. In het oosten zie je de top van de berg.");
		start.verbind('n', locatie3);
		locatie3.verbind('z', start);
		
		Locatie locatie4 = new Locatie("top", "Je staat op de top van de berg. Je hebt een prachtig uitzicht.\n"
				+ "In het zuiden zie je de monding van een rivier. Je kunt afdalen naar het westen.");
		locatie3.verbind('o', locatie4);
		locatie4.verbind('w', locatie3);
	}
	
	public Locatie getStart() {
		return start;
	}
}
