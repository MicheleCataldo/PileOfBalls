package esami.ia.pileofballs;

import java.awt.Color;
import java.awt.Graphics;

public class Palla {

	public static int maxY = 400;
	private int x;
	private int y;
	private int w;
	private int h;
	private Color c;
	private Coppia coppia;
	private int serial;
	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public Palla(int x, int y, int i, int j) {
		this.x = x;
		this.y = y;
		this.w = 50;
		this.h= 50;
		this.coppia = new Coppia(i,j);
		this.c = Color.WHITE;
		this.serial = 0;
	}
	
	public Palla(int x, int y, int c, int i, int j, int serial) {
		this.x = x;
		this.y = y;
		this.w = 50;
		this.h= 50;
		this.serial = serial;
		this.coppia = new Coppia(i,j);
		switch(c) {
			case 0:
				this.c = Color.BLUE;
				break;
			case 1:
				this.c = Color.GREEN;
				break;
			case 2:
				this.c = Color.RED;
				break;
			case 3:
				this.c = Color.ORANGE;
				break;
		}
	}
	
	public Coppia getCoppia() {
		return coppia;
	}

	public void setCoppia(Coppia coppia) {
		this.coppia = coppia;
	}

	public boolean isWhite() {
		if(this.c.equals(Color.WHITE))
			return true;
		return false;
	}
	
	public void setC(Color c) {
		this.c = c;
	}
	
	public Color getColor() {
		return c;
	}


	public void disegna(Graphics g) {
		g.setColor(this.c);
		g.fillOval(this.x, this.y, this.w, this.h);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
