package esami.ia.pileofballs;

import java.awt.Color;

public class Tris {
	private int i;
	private int j;
	private int color;
	
	public Tris(int i, int j, Color color){
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
		
		else if (color.equals(Color.MAGENTA))
			this.color = 4;
	}
	
	public Tris() {}
	
	public boolean isColorEqual(Color color){
		int c;
		if(color.equals(Color.BLUE))
			c = 0;
		
		else if(color.equals(Color.GREEN))
			c = 1;
		
		else if(color.equals(Color.RED))
			c = 2;
		
		else if(color.equals(Color.ORANGE))
			c = 3;
		
		else if (color.equals(Color.MAGENTA))
			c = 4;
		else
			c = -1;
		
		return c==this.color;
	}

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

	public boolean equals(Tris c) {
		if(c.getI() == this.i && c.getJ() == this.j)
			return true;
		return false;
	}
	
	public String toString() {
		return getI()+" "+getJ();
	}
	
	
}
