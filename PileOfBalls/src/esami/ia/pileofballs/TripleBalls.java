package esami.ia.pileofballs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class TripleBalls {
	private Ball p0;
	private Ball p1;
	private Ball p2;
	private Random r;
	private int cont;
	private boolean tipo;
	private int direz;
	
	public TripleBalls(Ball p0, Ball p1, Ball p2) {
		
		r = new Random();
		int limite = 4;
		if(PileOfBalls.sogliaLivello >= 700)
			limite = 5;
		
		this.direz = 0;
		this.tipo = true;
		int tmp0 = r.nextInt(limite);
		int tmp1 = r.nextInt(limite);
		int tmp2 = r.nextInt(limite);
		
		this.cont = 0;
		
		this.p0 = new Ball(p0.getX(), p0.getY()-50, tmp0, p0.getCoppia().getI(), p0.getCoppia().getJ(), 0);
		this.p1 = new Ball(p1.getX(), p1.getY()-50, tmp1, p1.getCoppia().getI(), p1.getCoppia().getJ(), 1);
		this.p2 = new Ball(p2.getX(), p2.getY()-50, tmp2, p2.getCoppia().getI(), p2.getCoppia().getJ(), 2);
	}
	
	public Ball getBallDown(int j){
		if(j == this.p0.getCoppia().getI())
			return this.p1;
		else
			return  this.p2;
	}
	
	public int getDirez() {
		return this.direz;
	}
	
	public void disegna(Graphics g) {
		returnWithSerial(0).disegna(g);
		returnWithSerial(1).disegna(g);
		returnWithSerial(2).disegna(g);
	}
	
	public boolean aggiorna(AlternateMatrix m) {
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
		if(returnWithSerial(2).getCoppia().getJ() < 9 && direz == 0
				|| returnWithSerial(2).getCoppia().getJ() < 8 && direz == 2
					|| returnWithSerial(0).getCoppia().getJ() < 8 && direz == 1) {
				returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()+1);
				returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()+1);
				returnWithSerial(2).getCoppia().setJ(returnWithSerial(2).getCoppia().getJ()+1);
			
		
			returnWithSerial(0).setX(returnWithSerial(0).getX()+50);
			returnWithSerial(1).setX(returnWithSerial(1).getX()+50);
			returnWithSerial(2).setX(returnWithSerial(2).getX()+50);
		}
	}
	public void goLeft() {
		
		if((returnWithSerial(1).getCoppia().getJ() > 0 && direz == 0)
				|| returnWithSerial(1).getCoppia().getJ() > 0 && direz == 1
					|| returnWithSerial(0).getCoppia().getJ() > 0 && direz == 2) {
			
			returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()-1);
			returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
			returnWithSerial(2).getCoppia().setJ(returnWithSerial(2).getCoppia().getJ()-1);
			
			
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
			
			if(returnWithSerial(0).getCoppia().getJ() == 9) {
				returnWithSerial(0).setX(returnWithSerial(0).getX()-50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
				returnWithSerial(2).setX(returnWithSerial(2).getX()-50);
				
				returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()-1);
				returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
				returnWithSerial(2).getCoppia().setJ(returnWithSerial(2).getCoppia().getJ()-1);
			}
			
		}else {
			this.tipo = true;
			
			if(direz == 1) {
				returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()-1);
				returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()+1);
				returnWithSerial(0).setX(returnWithSerial(0).getX()-50);
				returnWithSerial(1).setY(returnWithSerial(1).getY()+50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-25);
				
				Color c0 = returnWithSerial(0).getColor();
				Color c1 = returnWithSerial(1).getColor();
				Color c2 = returnWithSerial(2).getColor();
				
				
				returnWithSerial(0).setC(c1);
				returnWithSerial(1).setC(c2);
				returnWithSerial(2).setC(c0);
			}else {
				returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()+1);
				returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
				returnWithSerial(2).setX(returnWithSerial(2).getX()-25);
				returnWithSerial(2).setY(returnWithSerial(2).getY()+50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
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
			
			if(returnWithSerial(0).getCoppia().getJ() == 8) {
				returnWithSerial(0).setX(returnWithSerial(0).getX()-50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
				returnWithSerial(2).setX(returnWithSerial(2).getX()-50);
				
				returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()-1);
				returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
				returnWithSerial(2).getCoppia().setJ(returnWithSerial(2).getCoppia().getJ()-1);
			}
			
		}else {
			this.tipo = true;
			if(direz == 2) {
				returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()+1);
				returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
				returnWithSerial(2).setX(returnWithSerial(2).getX()-25);
				returnWithSerial(2).setY(returnWithSerial(2).getY()+50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
				
				Color c0 = returnWithSerial(0).getColor();
				Color c1 = returnWithSerial(1).getColor();
				Color c2 = returnWithSerial(2).getColor();
				
				
				returnWithSerial(0).setC(c2);
				returnWithSerial(1).setC(c0);
				returnWithSerial(2).setC(c1);
			}else {
				returnWithSerial(0).getCoppia().setJ(returnWithSerial(0).getCoppia().getJ()-1);
				returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()+1);
				returnWithSerial(0).setX(returnWithSerial(0).getX()-50);
				returnWithSerial(1).setY(returnWithSerial(1).getY()+50);
				returnWithSerial(1).setX(returnWithSerial(1).getX()-25);
			}
		
			direz = 0;
		}
	}
	
	private Ball returnWithSerial(int i) {
		if(p0.getSerial() == i)
			return p0;
		else if(p1.getSerial() == i)
			return p1;
		else if(p2.getSerial() == i)
			return p2;
		else
			return null;
	}
	
	public Ball getP0() {
		return this.returnWithSerial(0);
	}

	public Ball getP1() {
		return this.returnWithSerial(1);
	}

	public Ball getP2() {
		return this.returnWithSerial(2);
	}
	
	public boolean isTipo() {
		return tipo;
	}

	public void setP0(Ball p0) {
		this.p0 = p0;
	}

	public void setP1(Ball p1) {
		this.p1 = p1;
	}

	public void setP2(Ball p2) {
		this.p2 = p2;
	}
	
	
}
