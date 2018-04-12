package nl.sey.doolhof;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import nl.sey.doolhof.algoritme.Algoritme;

public class Doolhof {
	private String fileName;
    private Veld[][] velden;
    private Stap start;

    public Doolhof(String fileName) throws FileNotFoundException {
    	this.fileName = fileName;
		File file = new File(fileName);
    	String text = "";
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                text += input.nextLine() + "\n";
            }
        }
    	parseDefinition(text);
    }

    public void parseDefinition(String text) {
        if (text == null || (text = text.trim()).length() == 0) {
            throw new IllegalArgumentException("empty lines data");
        }

        String[] lines = text.split("[\r]?\n");
        velden = new Veld[lines.length][lines[0].length()];

        for (int row = 0; row < getRijen(); row++) {
            if (lines[row].length() != getKolommen()) {
                throw new IllegalArgumentException("line " + (row + 1) + " wrong length (was " + lines[row].length() + " but should be " + getKolommen() + ")");
            }

            for (int col = 0; col < getKolommen(); col++) {
            	Veld veld = velden[row][col] = new Veld();
            	veld.setType(lines[row].charAt(col));
            	if(veld.isType(VeldType.START)) {
            		start = new Stap(row, col);
            	}
            }
        }
    }
    
    public boolean zoekOplossing(Algoritme algoritme) {
    	reset();
    	if(!algoritme.zoekOplossing(this)) {
    		return false;
    	} else {
    		return true;
    	}
    }

    public int getRijen() {
        return velden.length;
    }

    public int getKolommen() {
        return velden[0].length;
    }

    public int getSize() {
    	return getKolommen() * (getRijen() + 1);
    }

    public Veld getVeld(Stap stap) {
    	int rij = stap.getRij(), kolom = stap.getKolom();
        if((rij >= 0) && (rij < getRijen()) && (kolom >= 0) && (kolom < getKolommen())) {
        	return velden[rij][kolom];
        } else {
        	return null;
        }
    }
    
    public Stap getStart() {
    	return start;
    }

    public void reset() {
    	for(int rij=0; rij<getRijen(); rij++) {
        	for(int kolom=0; kolom<getKolommen(); kolom++) {
        		velden[rij][kolom].reset();
        	}
    	}
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder(getSize() + 1);
        result.append(fileName + '\n');
        for (int row = 0; row < getRijen(); row++) {
            for (int col = 0; col < getKolommen(); col++) {
            	result.append(velden[row][col].toString());
            }
            result.append('\n');
        }
        return result.toString();
    }
}
