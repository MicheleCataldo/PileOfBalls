package esami.ia.pileofballs;

public class Coppia {
	private int i;
	private int j;
	
	public Coppia(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public Coppia() {}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	
	public boolean equals(Coppia c) {
		if(c.getI() == this.i && c.getJ() == this.j)
			return true;
		return false;
	}
	
	
}
