package nl.sey;

import java.util.stream.IntStream;

public class Sudoku {

	private static final int LENGTE = 9;
	private static final int MAXIMUM = 9;
	private static final int MINIMUM = 1;
	private static final int LEEG = 0;
	private static final int START = 0;
	private static final int BLOK = 3;
	
	private static final int[][] voorbeeld = {
		      {8, 0, 0, 0, 0, 0, 0, 0, 0},
		      {0, 0, 3, 6, 0, 0, 0, 0, 0},
		      {0, 7, 0, 0, 9, 0, 2, 0, 0},
		      {0, 5, 0, 0, 0, 7, 0, 0, 0},
		      {0, 0, 0, 0, 4, 5, 7, 0, 0},
		      {0, 0, 0, 1, 0, 0, 0, 3, 0},
		      {0, 0, 1, 0, 0, 0, 0, 6, 8},
		      {0, 0, 8, 5, 0, 0, 0, 1, 0},
		      {0, 9, 0, 0, 0, 0, 4, 0, 0}
		    };
	
	private int[][] bord;
	
	public Sudoku(int[][] bord) {
		this.bord = bord;
	}
	
    public static void main(String[] args) {
    	Sudoku puzzle = new Sudoku(voorbeeld); 
        puzzle.zoekOplossing();
        System.out.println(puzzle);
    }

    public boolean zoekOplossing() {
        for (int rij = START; rij < LENGTE; rij++) {
            for (int kolom = START; kolom < LENGTE; kolom++) {
                if (bord[rij][kolom] == LEEG) {
                    for (int k = MINIMUM; k <= MAXIMUM; k++) {
                        bord[rij][kolom] = k;
                        if (isToegestaan(rij, kolom) && zoekOplossing()) {
                            return true;
                        }
                        bord[rij][kolom] = LEEG;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isToegestaan(int rij, int kolom) {
        return rijIsToegestaan(rij) &&
          kolomIsToegestaan(kolom) &&
          blokIsToegestaan(rij, kolom);
    }

    private boolean blokIsToegestaan(int rij, int kolom) {
        boolean[] reeks = new boolean[LENGTE];
        int blokRijStart = (rij / BLOK) * BLOK;
        int blokRijEnd = blokRijStart + BLOK;

        int blokKolomStart = (kolom / BLOK) * BLOK;
        int blokKolomEnd = blokKolomStart + BLOK;

        for (int r = blokRijStart; r < blokRijEnd; r++) {
            for (int c = blokKolomStart; c < blokKolomEnd; c++) {
                if (!controleer(r, reeks, c)) return false;
            }
        }
        return true;
    }

    private boolean kolomIsToegestaan(int kolom) {
        boolean[] reeks = new boolean[LENGTE];
        return IntStream.range(START, LENGTE)
          .allMatch(rij -> controleer(rij, reeks, kolom));
    }

    private boolean rijIsToegestaan(int rij) {
        boolean[] reeks = new boolean[LENGTE];
        return IntStream.range(START, LENGTE)
          .allMatch(kolom -> controleer(rij, reeks, kolom));
    }

    private boolean controleer(int rij, boolean[] reeks, int kolom) {
        if (bord[rij][kolom] != LEEG) {
            if (!reeks[bord[rij][kolom] - 1]) {
                reeks[bord[rij][kolom] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder(LENGTE);
	    for (int rij = START; rij < LENGTE; rij++) {
	        for (int kolom = START; kolom < LENGTE; kolom++) {
            	result.append(bord[rij][kolom] + " ");
            }
            result.append('\n');
	    }
        return result.toString();
	}
}
