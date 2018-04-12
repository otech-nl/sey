package nl.sey.adventure;

import java.util.Scanner;

public class Adventure {
	
	private Locatie locatie;
	private static Scanner input = new Scanner(System.in);
	
	public Adventure() {
		Kaart kaart = new Kaart();
		locatie = kaart.getStart();
	}
	
	public String getLocatieNaam() {
		return locatie.getNaam();
	}
	
	public String getHelp() {
		return "Welkom in dit spel!\nSteeds als je op een nieuwe locatie komt, krijg "
				+ "je een omschrijving van de locatie.\nAls je opnieuw op een locatie komt, "
				+ "krijg je alleen een samenvatting.\nCommando's bestaan uit één letter:\n"
				+ "- Je kunt je verplaatsen door een windrichting aan te geven (n, o, w, z).\n"
				+ "- Je kunt dit bericht opnieuw lezen door 'h' (help) in te typen.\n"
				+ "- Je kunt het spel stoppen met 's'.\n"
				+ "- Je kunt de volledige beschrijving van een locatie opvragen met 'k' (kijk)\n";
	}
	
	public boolean interact() {
		System.out.println(locatie);
		System.out.print("> ");
		try {
			String line = input.nextLine();
			char command = line.charAt(0);
			if(!handleCommand(command)) {
				System.err.println("Onbekend commando: " + command);
			};
			return true;
		} catch(StringIndexOutOfBoundsException e) {
			System.err.println("Geef een commando ('h' voor help).");
			return true;
		}
	}

	public boolean handleCommand(char command) {
		Locatie nieuw = locatie.handleCommand(command); 
		if(nieuw != null) {
			locatie = nieuw;
			return true;
		} else {
			switch(command) {
			case 's':
				System.out.println("Bedankt voor het spelen. Tot ziens.");
				System.exit(0);
				break;
			case 'h':
				System.out.println(getHelp());
				break;
			default:
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Adventure adventure = new Adventure();
		System.out.println(adventure.getHelp());
		while(adventure.interact());   // herhaal tot interact 'false' teruggeeft
	}
}
