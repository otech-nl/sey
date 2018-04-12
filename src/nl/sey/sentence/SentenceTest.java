package nl.sey.sentence;

public abstract class SentenceTest {
	
	/* test a sentence and print the result */
	public static void testWelformedness(String text) {
		Sentence sentence = new Sentence(text);
		String result = "'"+text+"'";
		if(sentence.isWelformed()) {
			result += " is welformed";
		} else {
			result += " is NOT welformed";
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		String candidates[] = {
				"SEY: yes!",
				"Deze zin is te lang.",
				"Deze zin is niet te lang en niet te kort.",
				"Het gaat om de vorm",
				"Herhalingen zijn handig.",
				"Wat vinden wij van deze zin?",
				"Deze sin vind ik wel goed.",
		};
		for(String text: candidates) {
			SentenceTest.testWelformedness(text);
		}
	}
}
