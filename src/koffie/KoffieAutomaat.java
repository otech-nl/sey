package koffie;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class KoffieAutomaat {
	private String merk;
	private ArrayList<Cup> cups = new ArrayList<Cup>();
	
	public KoffieAutomaat(String merk, int eersteVulling) {
		this.merk = merk;
		vul(eersteVulling);
	}
	
	public boolean isLeeg() {
		return cups.isEmpty();
	}
	
	public Cup zetKoffie() {							
		return cups.remove(0);
	}
	
	public void vul(int aantal) {
		for(int i=0;i<aantal;i++) {
			Cup newCup = new Cup(ThreadLocalRandom.current().nextInt(0, 5));
			cups.add(newCup);
		}
	}

	public String toString() {
		String cupString = "";

		for(Cup cup: cups) {
			cupString += cup + ", ";
		}
		return merk + " automaat is gevuld met: " + cupString;
	}
}
