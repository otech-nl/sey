package nl.sey.cursus2;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Persoon {
	List<Vak> vakken;
	
	public Trainer(String achternaam, String voornaam) {
		super(achternaam, voornaam);
		vakken = new ArrayList<>();
	}
}
