package esami.ia.pileofballs;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	public static int maxY = 400;
	private int x;
	private int y;
	private int w;
	private int h;
	private Color c;
	private Pair coppia;
	private int serial;
	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public Ball(int x, int y, int i, int j) {
		this.x = x;
		this.y = y;
		this.w = 50;
		this.h= 50;
		this.c = Color.WHITE;
		this.coppia = new Pair(i,j,this.c);
		this.serial = 0;
	}
	
	public Ball(int x, int y, int c, int i, int j, int serial) {
		this.x = x;
		this.y = y;
		this.w = 50;
		this.h= 50;
		this.serial = serial;
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
		this.coppia = new Pair(i,j,this.c);
	}
	
	public Pair getCoppia() {
		return coppia;
	}

	public void setCoppia(Pair coppia) {
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
