package nl.sey;

import java.util.ArrayList;
import java.util.List;

public class Reeks {
	
	public static List<Integer> getOplopend(int size) {
		List<Integer> reeks = new ArrayList<Integer>();
		int val = 1, incr = 1;
		for(int i=0; i<size; i++) {
			reeks.add(val);
			val += incr;
			incr++;
		}
		return reeks;
	}
	
	public static List<Integer> getExponentieel(int size) {
		List<Integer> reeks = new ArrayList<Integer>();
		for(int i=0; i<size; i++) {
			reeks.add((int)Math.pow(2, i));
		}
		return reeks;
	}
	
	public static List<Integer> getFibonaci(int size) {
		List<Integer> reeks = new ArrayList<Integer>();
		reeks.add(1);
		reeks.add(2);
		for(int i=2; i<size; i++) {
			reeks.add(reeks.get(i-2) + reeks.get(i-1));
		}
		return reeks;
	}
	
	public static void main(String[] args) {
		System.out.println("Oplopend: "+Reeks.getOplopend(10));
		System.out.println("Exponentieel: "+Reeks.getExponentieel(10));
		System.out.println("Fibonaci: "+Reeks.getFibonaci(10));
	}

}
