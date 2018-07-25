package esami.ia.pileofballs;

public class Pair {
	private int i;
	private int j;
	
	public Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public Pair() {}

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
	
	
	public boolean equals(Pair c) {
		if(c.getI() == this.i && c.getJ() == this.j)
			return true;
		return false;
	}
	
	public String toString() {
		return getI()+" "+getJ();
	}
	
	
}
