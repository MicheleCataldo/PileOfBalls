package esami.ia.pileofballs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class TriplePalle {
	private Palla p1;
	private Palla p2;
	private Palla p3;
	private Random r;
	private int cont;
	public TriplePalle(Palla p1, Palla p2, Palla p3) {
		
		r = new Random();
		int tmp1 = r.nextInt(4);
		int tmp2 = r.nextInt(4);
		int tmp3 = r.nextInt(4);
		
		this.cont = 0;
		
		this.p1 = new Palla(p1.getX(), p1.getY(), tmp1, p1.getCoppia().getI(), p1.getCoppia().getJ());
		this.p2 = new Palla(p2.getX(), p2.getY(), tmp2, p2.getCoppia().getI(), p2.getCoppia().getJ());
		this.p3 = new Palla(p3.getX(), p3.getY(), tmp3, p3.getCoppia().getI(), p3.getCoppia().getJ());
	}
	
	public void disegna(Graphics g) {
		p1.disegna(g);
		p2.disegna(g);
		p3.disegna(g);
	}
	
	public boolean aggiorna(MatriceAlternata m) {
		if(this.cont%2==0) {
			p1.getCoppia().setI(p1.getCoppia().getI()+2);
			p2.getCoppia().setI(p2.getCoppia().getI()+2);
			p3.getCoppia().setI(p3.getCoppia().getI()+2);
		}
		this.cont++;
		
		if(p1.getCoppia().getI()<m.getDim()) {
			p1.setY(p1.getY()+50);
			p2.setY(p2.getY()+50);
			p3.setY(p3.getY()+50);
			return true;
		}else {
			p1.getCoppia().setI(p1.getCoppia().getI()-2);
			p2.getCoppia().setI(p2.getCoppia().getI()-2);
			p3.getCoppia().setI(p3.getCoppia().getI()-2);
			return false;
		}
	}
	
	public Palla getP1() {
		return p1;
	}

	public Palla getP2() {
		return p2;
	}

	public Palla getP3() {
		return p3;
	}
}
