package esami.ia.pileofballs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class TriplePalle {
	private Palla p0;
	private Palla p1;
	private Palla p2;
	private Random r;
	private int cont;
	private boolean tipo;
	private int direz;
	
	public TriplePalle(Palla p0, Palla p1, Palla p2) {
		
		r = new Random();
		this.direz = 0;
		this.tipo = true;
		int tmp0 = r.nextInt(4);
		int tmp1 = r.nextInt(4);
		int tmp2 = r.nextInt(4);
		
		this.cont = 0;
		
		this.p0 = new Palla(p0.getX(), p0.getY()-50, tmp0, p0.getCoppia().getI(), p0.getCoppia().getJ(), 0);
		this.p1 = new Palla(p1.getX(), p1.getY()-50, tmp1, p1.getCoppia().getI(), p1.getCoppia().getJ(), 1);
		this.p2 = new Palla(p2.getX(), p2.getY()-50, tmp2, p2.getCoppia().getI(), p2.getCoppia().getJ(), 2);
	}
	
	
	public void disegna(Graphics g) {
		returnWithSerial(0).disegna(g);
		returnWithSerial(1).disegna(g);
		returnWithSerial(2).disegna(g);
	}
	
	public boolean aggiorna(MatriceAlternata m) {
		if(this.cont%2==0) {
			returnWithSerial(0).getCoppia().setI(returnWithSerial(0).getCoppia().getI()+2);
			returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()+2);
			returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()+2);
		}
		this.cont++;
		
		if(returnWithSerial(0).getCoppia().getI()<m.getDim()) {
			returnWithSerial(0).setY(returnWithSerial(0).getY()+50);
			returnWithSerial(1).setY(returnWithSerial(1).getY()+50);
			returnWithSerial(2).setY(returnWithSerial(2).getY()+50);
			return true;
		}else {
			returnWithSerial(0).getCoppia().setI(returnWithSerial(0).getCoppia().getI()-2);
			returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()-2);
			returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()-2);
			return false;
		}
	}
	
	public void goRight() {
		if(returnWithSerial(2).getCoppia().getJ() < 9) {
			returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()+1);
			returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()+1);
			returnWithSerial(2).getCoppia().setJ(returnWithSerial(2).getCoppia().getJ()+1);
			System.out.println(returnWithSerial(2).getCoppia().getJ());
			returnWithSerial(0).setX(returnWithSerial(0).getX()+50);
			returnWithSerial(1).setX(returnWithSerial(1).getX()+50);
			returnWithSerial(2).setX(returnWithSerial(2).getX()+50);
		}
	}
	public void goLeft() {
		if(returnWithSerial(1).getCoppia().getJ() > 0) {
			returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()-1);
			returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
			returnWithSerial(2).getCoppia().setJ(returnWithSerial(2).getCoppia().getJ()-1);
			System.out.println(returnWithSerial(1).getCoppia().getJ());
			returnWithSerial(0).setX(returnWithSerial(0).getX()-50);
			returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
			returnWithSerial(2).setX(returnWithSerial(2).getX()-50);
		}
	}
	
	public void giraDx() {
		if(this.tipo == true) {
			this.tipo = false;
			this.direz = 1;
			returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()+1);
			returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()-1);
			returnWithSerial(0).setX(returnWithSerial(0).getX()+50);
			returnWithSerial(1).setY(returnWithSerial(1).getY()-50);
			returnWithSerial(1).setX(returnWithSerial(1).getX()+25);
		}else {
			this.tipo = true;
			
			if(direz == 1) {
				returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()-1);
				returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()+1);
				returnWithSerial(0).setX(returnWithSerial(0).getX()-50);
				returnWithSerial(1).setY(returnWithSerial(1).getY()+50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-25);
			}else {
				returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()+1);
				returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
				returnWithSerial(2).setX(returnWithSerial(2).getX()-25);
				returnWithSerial(2).setY(returnWithSerial(2).getY()+50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
			}
			
			Color c0 = returnWithSerial(0).getColor();
			Color c1 = returnWithSerial(1).getColor();
			Color c2 = returnWithSerial(2).getColor();
			
			if(direz == 1) {
				returnWithSerial(0).setC(c1);
				returnWithSerial(1).setC(c2);
				returnWithSerial(2).setC(c0);
			}
			direz = 0;
		}
	}
	
	public void giraSx() {
		if(this.tipo == true) {
			this.tipo = false;
			this.direz = 2;
			
			returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()-1);
			returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()+1);
			returnWithSerial(2).setX(returnWithSerial(2).getX()+25);
			returnWithSerial(2).setY(returnWithSerial(2).getY()-50);
			returnWithSerial(1).setX(returnWithSerial(1).getX()+50);
			
		}else {
			this.tipo = true;
			if(direz == 2) {
				returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()+1);
				returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
				returnWithSerial(2).setX(returnWithSerial(2).getX()-25);
				returnWithSerial(2).setY(returnWithSerial(2).getY()+50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
			}else {
				returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()-1);
				returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()+1);
				returnWithSerial(0).setX(returnWithSerial(0).getX()-50);
				returnWithSerial(1).setY(returnWithSerial(1).getY()+50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-25);
			}
			Color c0 = returnWithSerial(0).getColor();
			Color c1 = returnWithSerial(1).getColor();
			Color c2 = returnWithSerial(2).getColor();
			
			if(direz == 2) {
				returnWithSerial(0).setC(c2);
				returnWithSerial(1).setC(c0);
				returnWithSerial(2).setC(c1);
			}
			direz = 0;
		}
	}
	
	private Palla returnWithSerial(int i) {
		if(p0.getSerial() == i)
			return p0;
		else if(p1.getSerial() == i)
			return p1;
		else if(p2.getSerial() == i)
			return p2;
		else
			return null;
	}
	
	public Palla getP0() {
		return this.returnWithSerial(0);
	}

	public Palla getP1() {
		return this.returnWithSerial(1);
	}

	public Palla getP2() {
		return this.returnWithSerial(2);
	}
	
	public boolean isTipo() {
		return tipo;
	}
}
