package nl.sey;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

/**
 * Smoelenboek zoekt plaatjes in mappen van personen.
 * Aanroepen met de naam van de hoofdmap.
 * De bestanden/mappen in de hoofdmap dienen de naam van de persoon te bevatten.
 * Plaatjes mogen van types jpg, gif of png zijn.
 */
public class Smoelenboek {

	/**
	 * De bronmap
	 */
	private File bron;
	
	public Smoelenboek(String bron) {
		this.bron = new File(bron);
	}
	
	/**
	 * Zoekt plaatjes in de bronmap.
	 * @return een hashmap van de namen naar lijsten van plaatjes
	 */
	public Hashtable<String, List<File>> zoekPlaatjes() {
		Hashtable<String, List<File>> deelnemers = new Hashtable<String, List<File>>();
		for(String naam: bron.list()) {
			File deelnemer = new File(bron.getPath(), naam);
			if(deelnemer.isDirectory()) {
				deelnemers.put(naam, zoekPlaatjes(deelnemer));
			} else {
				deelnemers.put(naam, Collections.emptyList());
			}
		}
		return deelnemers;
	}
	
	/**
	 * Zoekt plaatjes in een map.
	 * @param bron de map waarin wordt gezocht
	 * @return een lijst van bestanden
	 */
	private List<File> zoekPlaatjes(File bron) {
		List<File> plaatjes = new ArrayList<File>();
		for(String naam: bron.list()) {
			File file = new File(bron, naam);
			if(file.isDirectory()) {
				plaatjes.addAll(zoekPlaatjes(file));
			} else if(naam.endsWith(".jpg") || naam.endsWith(".gif") || naam.endsWith(".png")) {
				plaatjes.add(file);
			}
		}
		return plaatjes;
	}

	public String toString() {
		Hashtable<String, List<File>> deelnemers = zoekPlaatjes();
        StringBuilder result = new StringBuilder();

        for(String deelnemer: deelnemers.keySet()) {
			result.append("<h1>" + deelnemer + "</h1>\n");
			for(File plaatje: deelnemers.get(deelnemer)) {
				result.append("<img src=\"" + plaatje + "\">\n");
			};
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		try {
			System.out.print(new Smoelenboek(args[0]));
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.print("Geef een brondirectory");
		}
	}

}
