package esami.ia.pileofballs;

import java.awt.Color;

public class ListaSeven extends Lista {
	private int five;
	private int six;
	private int seven;

	public int getFive() {
		return five;
	}

	public void setFive(int five) {
		this.five = five;
	}

	public int getSix() {
		return six;
	}

	public void setSix(int six) {
		this.six = six;
	}

	public int getSeven() {
		return seven;
	}

	public void setSeven(int seven) {
		this.seven = seven;
	}

	public ListaSeven(int first, int second, int third, Color color, int five, int six, int seven) {
		super(first, second, third, color);
		this.setFive(five);
		this.setSix(six);
		this.setSeven(seven);
	}

	public ListaSeven(int first, int second, int third, int four, int five, int six, int seven) {
		super(first, second, third, four);
		this.setFive(five);
		this.setSix(six);
		this.setSeven(seven);
	}

	public ListaSeven() {
		// TODO Auto-generated constructor stub
	}

}
