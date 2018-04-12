package koffie;
// Nick Baijens (8 mei 2018)

import java.util.Scanner;

public class AutomaatTest {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		KoffieAutomaat automaat = new KoffieAutomaat("Philips", 3);
			
		System.out.println(automaat);
		while(true) {		
			if(automaat.isLeeg()) {
				System.out.println("Automaat LEEG! Hoeveel cups aanvullen? (aantal)");
				int aantal = input.nextInt();
				automaat.vul(aantal);
			} else {
				System.out.println("Wil je een kop koffie? (y/n)");
				String antwoord = input.next();
				if(antwoord.equals("y")) {
					System.out.println("1 kopje " + automaat.zetKoffie() + " word gezet");
				} else
					System.out.println("er word geen koffie gezet");			
			}
			System.out.println(automaat);
		}		
	}
}
