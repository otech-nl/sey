package nl.sey.cursus2;

public class Persoon {
	private String achternaam, voornaam;
	
	public Persoon(String achternaam, String voornaam) {
		setNaam(achternaam, voornaam);
	}
	
	public void setNaam(String achternaam, String voornaam) {
		this.achternaam = achternaam;
		this.voornaam = voornaam;
	}
	
	public String getNaam() {
		return String.join(" ", voornaam, achternaam);
	}
}
