package esami.ia.pileofballs;

import java.awt.Color;

public class ListaSeven {
	private int first;
	private int second;
	private int third;
	private int four;
	private int five;
	private int six;
	private int seven;
	
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public int getFour() {
		return four;
	}

	public void setFour(int four) {
		this.four = four;
	}

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

	public ListaSeven(int first, int second, int third, int four, int five, int six, int seven) {
		this.setFirst(first);
		this.setSecond(second);
		this.setThird(third);
		this.setFour(four);
		this.setFive(five);
		this.setSix(six);
		this.setSeven(seven);
	}
	
	public ListaSeven(){
		this.first = 0;
		this.second = 0;
		this.third = 0;
		this.four = 0;
		this.five = 0;
		this.six = 0;
		this.seven = 0;
	}
	
	public String toString(){
		return  "("+this.first+", "+this.second+", "+this.third+", "+this.four+", "+this.five+", "+this.six+", "+this.seven+")";
	}
	
	public Color getFourColor(int c){
		switch(c){
			case 0:
				return Color.BLUE;
			case 1:
				return Color.GREEN;
			case 2: 
				return Color.RED;
			case 3:
				return Color.ORANGE;
			case 4:
				return Color.MAGENTA;
			default:
				return null;
		}
	}

}
