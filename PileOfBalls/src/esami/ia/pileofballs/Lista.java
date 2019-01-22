package esami.ia.pileofballs;

import java.awt.Color;

public class Lista {
	private int first;
	private int second;
	private int third;
	private int four;
	
	public Lista(int first, int second, int third, Color color){
		this.first = first;
		this.second = second;
		this.third = third;
		if(color.equals(Color.BLUE))
			this.four = 0;
		
		else if(color.equals(Color.GREEN))
			this.four = 1;
		
		else if(color.equals(Color.RED))
			this.four = 2;
		
		else if(color.equals(Color.ORANGE))
			this.four = 3;
		
		else if (color.equals(Color.MAGENTA))
			this.four = 4;
	}

	public Lista(int first, int second, int third, int four){
		this.first = first;
		this.second = second;
		this.third = third;
		this.four = four;
	}
	
	public Lista (){
		this.first = 0;
		this.second = 0;
		this.third = 0;
		this.four = 0;
	}
	
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
	
	public String toString(){
		return "("+this.first+", "+this.second+", "+this.third+", "+this.four+")";
	}
	
}
