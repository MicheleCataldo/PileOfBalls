package esami.ia.pileofballs;

import java.awt.Color;

public class Pair {
	private int i;
	private int j;
	private int color;
	
	public Pair(int i, int j) {
		this.i = i;
		this.j = j;
		this.color = 0;
	}
	
	public Pair(int i, int j, Color color){
		this.i = i;
		this.j = j;
		if(color.equals(Color.BLUE))
			this.color = 0;
		
		else if(color.equals(Color.GREEN))
			this.color = 1;
		
		else if(color.equals(Color.RED))
			this.color = 2;
		
		else if(color.equals(Color.ORANGE))
			this.color = 3;
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
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
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
