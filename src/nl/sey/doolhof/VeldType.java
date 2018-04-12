package nl.sey.doolhof;

public enum VeldType {

	BEZOCHT('.'),
	DOEL('E'),
	MUUR('#'),
	OPEN(' '),
	PAD('*'),
	START('S');

	private char symbol;

	VeldType(char symbol) {
		this.symbol = symbol; 
	}

	public static VeldType fromSymbol(char symbol) {
	    for (VeldType type: VeldType.values()) {
	        if (type.symbol == symbol) {
	            return type;
	        }
	    }
	    return null;
	}

	public String toString() {
		return ""+this.symbol;
	}
}
