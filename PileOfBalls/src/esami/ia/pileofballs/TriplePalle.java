package esami.ia.pileofballs;

import java.awt.Graphics;
import java.util.Random;

public class TriplePalle {
	private Palla p1;
	private Palla p2;
	private Palla p3;
	private Random r;
	private int cont;
	private boolean tipo;
	public TriplePalle(Palla p1, Palla p2, Palla p3) {
		
		r = new Random();
		this.tipo = true;
		int tmp1 = r.nextInt(4);
		int tmp2 = r.nextInt(4);
		int tmp3 = r.nextInt(4);
		
		this.cont = 0;
		
		this.p1 = new Palla(p1.getX(), p1.getY(), tmp1, p1.getCoppia().getI(), p1.getCoppia().getJ(), 1);
		this.p2 = new Palla(p2.getX(), p2.getY(), tmp2, p2.getCoppia().getI(), p2.getCoppia().getJ(), 2);
		this.p3 = new Palla(p3.getX(), p3.getY(), tmp3, p3.getCoppia().getI(), p3.getCoppia().getJ(), 3);
	}
	
	
	public void disegna(Graphics g) {
		returnWithSerial(1).disegna(g);
		returnWithSerial(2).disegna(g);
		returnWithSerial(3).disegna(g);
	}
	
	public boolean aggiorna(MatriceAlternata m) {
		if(this.cont%2==0) {
			returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()+2);
			returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()+2);
			returnWithSerial(3).getCoppia().setI(returnWithSerial(3).getCoppia().getI()+2);
		}
		this.cont++;
		
		if(returnWithSerial(1).getCoppia().getI()<m.getDim()) {
			returnWithSerial(1).setY(returnWithSerial(1).getY()+50);
			returnWithSerial(2).setY(returnWithSerial(2).getY()+50);
			returnWithSerial(3).setY(returnWithSerial(3).getY()+50);
			return true;
		}else {
			returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()-2);
			returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()-2);
			returnWithSerial(3).getCoppia().setI(returnWithSerial(3).getCoppia().getI()-2);
			return false;
		}
	}
	
	public void goRight() {
		if(returnWithSerial(3).getCoppia().getJ() < 9) {
			returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()+1);
			returnWithSerial(2).getCoppia().setJ(returnWithSerial(2).getCoppia().getJ()+1);
			returnWithSerial(3).getCoppia().setJ(returnWithSerial(3).getCoppia().getJ()+1);
			System.out.println(returnWithSerial(3).getCoppia().getJ());
			returnWithSerial(1).setX(returnWithSerial(1).getX()+50);
			returnWithSerial(2).setX(returnWithSerial(2).getX()+50);
			returnWithSerial(3).setX(returnWithSerial(3).getX()+50);
		}
	}
	public void goLeft() {
		if(returnWithSerial(2).getCoppia().getJ() > 0) {
			returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
			returnWithSerial(2).getCoppia().setJ(returnWithSerial(2).getCoppia().getJ()-1);
			returnWithSerial(3).getCoppia().setJ(returnWithSerial(3).getCoppia().getJ()-1);
			System.out.println(returnWithSerial(2).getCoppia().getJ());
			returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
			returnWithSerial(2).setX(returnWithSerial(2).getX()-50);
			returnWithSerial(3).setX(returnWithSerial(3).getX()-50);
		}
	}
	
	public void giraDx() {
		if(this.tipo == true) {
			this.tipo = false;
			returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()+1);
			returnWithSerial(2).getCoppia().setI(returnWithSerial(2).getCoppia().getI()-1);
			returnWithSerial(1).setX(returnWithSerial(1).getX()+50);
			returnWithSerial(2).setY(returnWithSerial(2).getY()-50);
			returnWithSerial(2).setX(returnWithSerial(2).getX()+25);
			System.out.println("p1: "+p1.getSerial());
			System.out.println("p2: "+p2.getSerial());
			System.out.println("p3: "+p3.getSerial());
		}else {
			this.tipo = true;
			returnWithSerial(3).getCoppia().setJ(returnWithSerial(3).getCoppia().getJ()-1);
			returnWithSerial(1).getCoppia().setI(returnWithSerial(1).getCoppia().getI()+1);
			returnWithSerial(3).setX(returnWithSerial(3).getX()-50);
			returnWithSerial(1).setY(returnWithSerial(1).getY()+50);
			returnWithSerial(1).setX(returnWithSerial(1).getX()-25);
			
			Palla tmp1 = returnWithSerial(1);
			Palla tmp2 = returnWithSerial(2);
			Palla tmp3 = returnWithSerial(3);
			/*tmp1.setSerial(2);
			tmp2.setSerial(3);
			tmp3.setSerial(1);*/
			
			

			System.out.println("p1: "+p1.getSerial());
			System.out.println("p2: "+p2.getSerial());
			System.out.println("p3: "+p3.getSerial());
		}
	}
	
	public void giraSx() {
		returnWithSerial(1).getCoppia().setJ(returnWithSerial(1).getCoppia().getJ()-1);
		returnWithSerial(3).getCoppia().setI(returnWithSerial(3).getCoppia().getI()-1);
		returnWithSerial(3).getCoppia().setJ(returnWithSerial(3).getCoppia().getJ()-1);
		returnWithSerial(1).setX(returnWithSerial(1).getX()-50);
		returnWithSerial(3).setY(returnWithSerial(3).getY()-50);
		returnWithSerial(3).setX(returnWithSerial(3).getX()-25);
	}
	
	private Palla returnWithSerial(int i) {
		if(p1.getSerial() == i)
			return p1;
		else if(p2.getSerial() == i)
			return p2;
		else if(p3.getSerial() == i)
			return p3;
		else
			return null;
	}
	
	public Palla getP1() {
		return this.returnWithSerial(1);
	}

	public Palla getP2() {
		return this.returnWithSerial(2);
	}

	public Palla getP3() {
		return this.returnWithSerial(3);
	}
	
	public boolean isTipo() {
		return tipo;
	}
}
