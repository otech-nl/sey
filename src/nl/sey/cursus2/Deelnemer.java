package nl.sey.cursus2;

import java.util.HashMap;
import java.util.Map;

public class Deelnemer extends Persoon {
	Map<Vak, Integer> cijfers;
	
	public Deelnemer(String achternaam, String voornaam) {
		super(achternaam, voornaam);
		cijfers = new HashMap<Vak, Integer>();
	}
}
