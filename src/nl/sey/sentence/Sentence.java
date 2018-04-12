package nl.sey.sentence;

public class Sentence {
	
	protected String str;

	public Sentence(String str) {
		this.str = str;
	}

	public boolean isWelformed() {
		boolean test = Character.isUpperCase(str.charAt(0)) 
				&& (str.charAt(str.length()-1) == '.');
		String[] words = str.split(" ");
		for(String word: words) {
			test = test && (word.length() <= 6);
		}
		return test && (words.length <= 8);
	}
}
