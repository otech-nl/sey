package koffie;

public class Cup {
	private static String[] smaken = {"Java","Espresso","Cappucino","Zwart","Verkeerd","Moccha", "Wiener melange"};
	private int smaak;

	public Cup(int smaak) {
		this.smaak = smaak;
	}
	
	public String toString() {
		return smaken[smaak];
	}
}
