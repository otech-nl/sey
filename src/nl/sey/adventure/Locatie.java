package nl.sey.adventure;

import java.util.Hashtable;

public class Locatie {

	private String naam; 
	private String omschrijving;
	private Hashtable<Character, Locatie> verbindingen;
	private static Hashtable<String, Locatie> locaties = new Hashtable<String, Locatie>();
	private boolean bezocht;
	
	public Locatie(String naam, String omschrijving) {
		this.naam = naam;
		this.omschrijving = omschrijving;
		bezocht = false;
		verbindingen = new Hashtable<Character, Locatie>();
		locaties.put(naam, this);
	}
	
	public void verbind(char richting, Locatie locatie) {
		verbindingen.put(richting, locatie);
	}
	
	public int getAantalVerbindingen() {
		return verbindingen.size();
	}
	
	public Locatie gaNaar(char richting) {
		return verbindingen.get(richting);
	}
	
	public String getNaam() {
		return naam;
	}
	
	public static Locatie zoekOpNaam(String naam) {
		return locaties.get(naam);
	}
	
	public String toString() {
		String tekst;
		if(bezocht) {
			tekst = "["+ naam + "]:";
		} else {
			tekst = omschrijving + " Je kunt naar:";
			bezocht = true;
		}
		for(char richting: verbindingen.keySet()) {
			tekst += " " + richting;
		}
		return tekst;
	}

	public Locatie handleCommand(char command) {
		if(command == 'k') {
			System.out.println(omschrijving);
			return this;  // wel een geldig commando, maar locatie blijft dezelfde
		} else {
			return gaNaar(command);
		}
	}
}
