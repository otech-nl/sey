package nl.sey.doolhof;

public class Veld {

	private VeldType type = VeldType.OPEN;

	public boolean isType(VeldType type) {
		return this.type == type;
	}

	public void setType(VeldType type) {
		if(type == VeldType.BEZOCHT) {
			System.err.println("Do not set type BEZOCHT directly");
		} else if(type == VeldType.PAD) {
			System.err.println("Do not set type PAD directly");
		} else {
			this.type = type;
		}
	}

	public void setType(char symbol) {
		setType(VeldType.fromSymbol(symbol));
	}

	public void setBezocht() {
		if(type == VeldType.OPEN) {
			type = VeldType.BEZOCHT;
		}
	}
	
	public void setPad() {
		if(type == VeldType.BEZOCHT) {
			type = VeldType.PAD;
		}
	}
	
	public boolean isOpen() {
		return (type == VeldType.OPEN) || (type == VeldType.START) || (type == VeldType.DOEL);
	}
	
	public String toString() {
		return type.toString();
	}

	public void reset() {
		if((type == VeldType.PAD) || (type == VeldType.BEZOCHT)) {
			setType(VeldType.OPEN);
		}
	}
}