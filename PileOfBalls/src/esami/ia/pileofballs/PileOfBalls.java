package esami.ia.pileofballs;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import esami.ia.dlv.IA;

public class PileOfBalls extends Canvas implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 700;
	private static int HEIGHT = 680;
	private AlternateMatrix m;
	private TripleBalls p;
	private TripleBalls p_succ;
	private ArrayList<Tris> array_coppie;
	private ArrayList<Tris> balls;
	private boolean running = false;
    private Thread thread;
    private boolean coll = false;
    private int punteggio;
    private Parts parts = Parts.PLAY;
    private IA ia;
    public static int livello = 1;
    private int sogliaLivello = 300;
    private boolean ia_attivo = true;
   // private boolean isCompl = true;
	
	public static void main(String[] args) {
		PileOfBalls pob = new PileOfBalls();
        
        pob.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pob.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        pob.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        
        JFrame frame = new JFrame("Pile of Balls");
        frame.add(pob);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(pob);
        
        pob.start();
	}
	
	private void createTriple() {
		//Random r = new Random();
		//int j = r.nextInt(9);
		int j = 4; 
		int i = 0;
		p = new TripleBalls(m.get(i,j),m.get(i+1,j),m.get(i+1,j+1));
		p_succ = new TripleBalls(m.get(i,j),m.get(i+1,j),m.get(i+1,j+1));
	}
	
	private void createTripleSucc(){
		int j = 4; 
		int i = 0;
		p = p_succ;
		p_succ = new TripleBalls(m.get(i,j),m.get(i+1,j),m.get(i+1,j+1));
	}
	
	private void init() throws IncorrectInitAltMatrixException {
		 m = new AlternateMatrix(12);
		 array_coppie = new ArrayList<Tris>();
		 balls = new ArrayList<Tris>();
		 punteggio = 0;
		 ia = new IA();
		 createTriple();
		 //this.dlv();
	}
	
	private void init2() throws IncorrectInitAltMatrixException{
		this.init();
		Random r = new Random();
		int c = 0;
		for(int i = 0; i < 10; i+=2){
			c = r.nextInt(4);
			m.setColor(c, 11, i);
			array_coppie.add(new Tris(11, i, m.get(11, i).getColor()));
		}
		this.dlv();
	}
	
	private void init3() throws IncorrectInitAltMatrixException{
		this.init();
		Random r = new Random();
		int c = r.nextInt(5);
		int c1;
		for(int i = 0; i < 10; i++){
			c1 = c;
			while(c1==c)
				c = r.nextInt(5);	
			m.setColor(c, 11, i);
			array_coppie.add(new Tris(11, i, m.get(11, i).getColor()));
		}
		this.dlv();
	}
	
	private void disegna() {
		BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800);
        
        if(parts.equals(Parts.PLAY) || parts.equals(Parts.PAUSE)
        		|| parts.equals(Parts.LOST)) {
	        m.getElements(g);
	        p.disegna(g);
	        g.setColor(Color.WHITE);
	        g.drawLine(505, 0, 505, PileOfBalls.HEIGHT);
	        Font fnt0 = new Font("8-bit pusab", Font.BOLD, 10);
	        g.setFont(fnt0);
	        g.drawString("Punteggio: "+this.punteggio, 510, 50);
	        g.drawLine(505, 60, PileOfBalls.WIDTH+20, 60);
	        g.drawString("Livello "+this.livello, 510, 100);
	        g.drawString("Soglia lvl: "+this.sogliaLivello, 510, 150);
	        g.drawString("IA: "+this.ia_attivo, 510, 200);
	        for(int i = 0; i < 3; i++){
	        	switch(i){
	        		case 0:
	        			g.setColor(p_succ.getP0().getColor());
	        			g.fillOval(535, 250, 50, 50);
	        			break;
	        		case 1:
	        			g.setColor(p_succ.getP1().getColor());
	        			g.fillOval(510, 300, 50, 50);
	        			break;
	        		case 2:
	        			g.setColor(p_succ.getP2().getColor());
	        			g.fillOval(560, 300, 50, 50);
	        			break;
	        	}
	        	
	        }
	        if(parts.equals(Parts.PAUSE)) {
	        	Font fnt1 = new Font("8-bit pusab", Font.BOLD, 40);
		        g.setFont(fnt1);
		        g.setColor(Color.GRAY);
		        g.drawString("PAUSE", 120, PileOfBalls.HEIGHT/2);
	        }
	        else if(parts.equals(Parts.LOST)) {
	        	Font fnt1 = new Font("8-bit pusab", Font.BOLD, 40);
		        g.setFont(fnt1);
		        g.setColor(Color.GRAY);
		        g.drawString("GAME OVER", 120, PileOfBalls.HEIGHT/2);
	        }
	        
	        if(sogliaLivello < punteggio){
	        	g.fillRect(150, 200, 250, 250);
	        	g.setColor(Color.BLACK);
	        	g.drawString("Livello passato!", 200, 300);
	        }	
        }
        else if(parts.equals(Parts.MENU)) {
        	g.setColor(Color.RED);
	        Font fnt0 = new Font("8-bit pusab", Font.BOLD, 40);
	        g.setFont(fnt0);
	        g.drawString("Pile of Balls", 120, 100);
	        Font fnt1 = new Font("8-bit pusab", Font.BOLD, 20); 
	        g.setFont(fnt1);
	        g.drawString("Press ENTER to start", 150, 300);
        }
        
        g.dispose();
        bs.show();
	}
	
	private void controllaBalls(){
		ArrayList<Tris> id = new ArrayList<Tris>();
		int limite;
		boolean is = true;
		while(is){
			is = false;
			for(int i = 0; i < balls.size(); i++){
				limite = 9;
				if(balls.get(i).getI()%2==0)
					limite = 8;
				
				if(balls.get(i).getI() >= m.getDim()){
					balls.remove(balls.get(i));
					is = true;
					break;
				}	
				
				if(balls.get(i).getJ() > limite){
					balls.remove(balls.get(i));
					is = true;
					break;
				}	
			}
		}
	}
	
	private int formaUnaTripla(Tris ball){
		int cont = 0;
		int limite_j = 9;
		if(ball.getI()%2==0)
			limite_j = 8;
		
		if(ball.getJ()-1 >= 0){
			if(!m.get(ball.getI(), ball.getJ()-1).isWhite()){
				System.out.println("Entra");
				if(ball.isColorEqual(m.get(ball.getI(), ball.getJ()-1).getColor())){
					cont++;
				}	
			}
		}
		
		if(ball.getJ()+1 <= limite_j){
			if(!m.get(ball.getI(), ball.getJ()+1).isWhite()){
				System.out.println("Entra");
				if(ball.isColorEqual(m.get(ball.getI(), ball.getJ()+1).getColor())){
					cont++;
				}	
			}
		}
		
		if(ball.getI()-1 >=0){
			if(!m.get(ball.getI()-1, ball.getJ()).isWhite()){
				System.out.println("Entra");
				if(ball.isColorEqual(m.get(ball.getI()-1, ball.getJ()).getColor())){
					cont++;
				}	
			}
		}
			
		if(ball.getI()+1 <= 11){
			if(!m.get(ball.getI()+1, ball.getJ()).isWhite()){
				System.out.println("Entra");
				if(ball.isColorEqual(m.get(ball.getI()+1, ball.getJ()).getColor())){
					cont++;
				}	
			}
		}
		
		if(ball.getI()%2==0){
			if(ball.getI()+1 <= 11 && ball.getJ()+1 <= limite_j){
				if(!m.get(ball.getI()+1, ball.getJ()+1).isWhite()){
					System.out.println("Entra");
					if(ball.isColorEqual(m.get(ball.getI()+1, ball.getJ()+1).getColor())){
						cont++;
					}	
				}
			}
			
			if(ball.getI()-1 >= 0 && ball.getJ()+1 <= limite_j){
				if(!m.get(ball.getI()-1, ball.getJ()+1).isWhite()){
					System.out.println("Entra");
					if(ball.isColorEqual(m.get(ball.getI()-1, ball.getJ()+1).getColor())){
						cont++;
					}	
				}
			}
		}else{
			if(ball.getI()+1 <= 11 && ball.getJ()-1 >= 0){
				if(!m.get(ball.getI()+1, ball.getJ()-1).isWhite()){
					System.out.println("Entra");
					if(ball.isColorEqual(m.get(ball.getI()+1, ball.getJ()-1).getColor())){
						cont++;
					}	
				}
			}
			
			if(ball.getI()-1 >= 0 && ball.getJ()-1 >= 0){
				if(!m.get(ball.getI()-1, ball.getJ()-1).isWhite()){
					System.out.println("Entra");
					if(ball.isColorEqual(m.get(ball.getI()-1, ball.getJ()-1).getColor())){
						cont++;
					}	
				}
			}
		}
			
		return 2-cont;
	}
	
	private boolean collide1(Tris c, int i) {
		//if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ())
		if(array_coppie.get(i).equals(c))
			return true;
		
		return false;
	}
	
	private boolean collide2(Tris c, int i) {
		if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ()-1)
			return true;
		return false;
	}
	
	private boolean collide3(Tris c, int i) {
		if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ()+1)
			return true;
		return false;
	}
	
	private boolean isOccup(int x, int y) {
		Tris c = new Tris(x, y, Color.WHITE);
		for(int i = 0; i < array_coppie.size(); i++) {
			if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ()) 
				return true;
		}	
		return false;
	}
	
	private void occupMatrix(Tris c) {
		System.out.println("Colore: "+c.getColor());
		boolean is = false;
		for(int i = 0; i < array_coppie.size(); i++)
			if(array_coppie.get(i).equals(c)) {
				is = true;
				break;
			}
		
		if(!is) {
			array_coppie.add(c);
		}
	}
	
	private void freeMatrix(Tris c) {
		for(int i = 0; i < array_coppie.size(); i++)
			if(array_coppie.get(i).equals(c)) {
				array_coppie.remove(i);
				break;
			}
	}
	
	private ArrayList<Tris> posLibere(){
		ArrayList<Tris> pos_libere = new ArrayList<Tris>();
		int limite;
		for(int i = 0; i < m.getDim(); i++){
			limite = 9;
			if(i%2==0)
				limite = 8;
			for(int j = 0; j < limite; j++)
				if(!this.isOccup(i, j))
					pos_libere.add(new Tris(i,j,Color.WHITE));
		}
		return pos_libere;
	}
	
	private void addBalls(Tris c) {
		boolean is = false;
		for(int i = 0; i < balls.size(); i++)
			if(balls.get(i).equals(c)) {
				is = true;
				break;
			}
		
		if(!is) {
			balls.add(c);
		}	
	}
	
	private void aggiustaMatrice() {
		Tris c;
		Color col;
		boolean ok = false;
		while(!ok) {
			ok = true;
			for(int i = 0; i < m.getDim(); i++) {
				if(m.getInternSize(i)%2 == 0) {
					for(int j = 0; j < m.getInternSize(i); j++) {
						col = m.get(i, j).getColor();
						c = new Tris(i, j, col);
						if(i+1 < m.getDim()) {
							if(j-1 >= 0) {
								if(!m.get(i, j).isWhite() && m.get(i+1, j-1).isWhite()) {
									this.freeMatrix(c);
									m.get(i, j).setC(Color.WHITE);
									
									this.occupMatrix(new Tris(i+1, j-1, col));
									m.get(i+1, j-1).setC(col);
									ok = false;
									break;
								}
							}else {
								//System.out.println("ERROR! j-1 < 0.");
							}
							
							if(!m.get(i, j).isWhite() && m.get(i+1, j).isWhite()) {
								this.freeMatrix(c);
								m.get(i, j).setC(Color.WHITE);
								
								this.occupMatrix(new Tris(i+1, j, col));
								m.get(i+1, j).setC(col);
								ok = false;
								break;
							}
						}else {
							//System.out.println("ERROR! i+1 >= dim");
						}
					}
				}
				else {
					for(int j = 0; j < m.getInternSize(i); j++) {
						col = m.get(i, j).getColor();
						c = new Tris(i, j, col);
						if(i+1 < m.getDim()) {
							if(!m.get(i, j).isWhite() && m.get(i+1, j).isWhite()) {
								this.freeMatrix(c);
								m.get(i, j).setC(Color.WHITE);
								
								this.occupMatrix(new Tris(i+1, j, col));
								m.get(i+1, j).setC(col);
								ok = false;
								break;
							}
							
							if(j+1 < m.getInternSize(i+1)) {
								if(!m.get(i, j).isWhite() && m.get(i+1, j+1).isWhite()) {
									this.freeMatrix(c);
									m.get(i, j).setC(Color.WHITE);
									
									this.occupMatrix(new Tris(i+1, j+1, col));
									m.get(i+1, j+1).setC(col);
									ok = false;
									break;
								}
							}else {
								//System.out.println("ERROR! j+1 >= internalSize");
							}
						}else {
							//System.out.println("ERROR! i+1 >= dim");
						}
					}
				}
			}
		}
	}
	//messa in pausa
	private boolean scoppiaPalline() {
		Color col;
		Tris p;
		int t;
		int intDim;
		int intDim2;
		boolean contin = false;
		balls.clear();
		for(int i = 0; i < array_coppie.size(); i++) {
			this.addBalls(array_coppie.get(i));
			col = m.get(array_coppie.get(i).getI(), array_coppie.get(i).getJ()).getColor();
			for(int j = 0; j < balls.size(); j++) {
				if(balls.get(j).getI()%2 == 0) {
					t = 1;
					intDim = 8;
					intDim2 = 9;
				}	
				else {
					t = -1;
					intDim = 9;
					intDim2 = 8;
				}
				if(balls.get(j).getJ()+1 <= intDim) {
					if(m.get(balls.get(j).getI(), balls.get(j).getJ()+1).getColor().equals(col)) {
						System.out.println("caso 1");
						p = new Tris(balls.get(j).getI(), balls.get(j).getJ()+1, col);
						this.addBalls(p);
					}
				}
						
				if(balls.get(j).getJ()-1 >= 0) {
					if(m.get(balls.get(j).getI(), balls.get(j).getJ()-1).getColor().equals(col)) {
						System.out.println("caso 2");
						p = new Tris(balls.get(j).getI(), balls.get(j).getJ()-1, col);
						this.addBalls(p);
					}
				}
						
				if(balls.get(j).getI()+1 < m.getDim() && balls.get(j).getJ() <= intDim2 && balls.get(j).getJ() >= 0) {
					if(m.get(balls.get(j).getI()+1, balls.get(j).getJ()).getColor().equals(col)) {
						System.out.println("caso 3");
						
						p = new Tris(balls.get(j).getI()+1, balls.get(j).getJ(), col);
						this.addBalls(p);
					}
				}
						
				if(balls.get(j).getI()-1 >= 0 && balls.get(j).getJ() <= intDim2 && balls.get(j).getJ() >= 0) {
					if(m.get(balls.get(j).getI()-1, balls.get(j).getJ()).getColor().equals(col) ) {
						System.out.println("caso 4");
						
						p = new Tris(balls.get(j).getI()-1, balls.get(j).getJ(), col);
						this.addBalls(p);
					}
				}
					
				
				if(balls.get(j).getI()+1 < m.getDim() && balls.get(j).getJ()+t >=0 && balls.get(j).getJ()+t <= intDim2) {
					if(m.get(balls.get(j).getI()+1, balls.get(j).getJ()+t).getColor().equals(col) ) {
						System.out.println("caso 5");
						p = new Tris(balls.get(j).getI()+1, balls.get(j).getJ()+t, col);
						this.addBalls(p);
					}
				}
				
				
				if(balls.get(j).getI()-1 >= 0 && balls.get(j).getJ()+t >=0 && balls.get(j).getJ()+t <= intDim2) {
					if(m.get(balls.get(j).getI()-1, balls.get(j).getJ()+t).getColor().equals(col)) {
						System.out.println("caso 6");
						p = new Tris(balls.get(j).getI()-1, balls.get(j).getJ()+t, col);
						this.addBalls(p);
					}
				}
			}
			
			//this.controllaBalls();
			
			if(balls.size() > 3) {
				for(int y = 0; y < balls.size(); y++) {
					m.get(balls.get(y).getI(), balls.get(y).getJ()).setC(Color.WHITE);
					this.freeMatrix(balls.get(y));
					contin = true;
				}
				if(balls.size()<=10)
					punteggio += balls.size()*5;
			}
			balls.clear();
		}
		
		return contin;
	}
	
	private void settaPalline(int i1, int i2, int i3, int j1, int j2, int j3) {
		m.get(i1, j1).setC(p.getP0().getColor());
		m.get(i2, j2).setC(p.getP1().getColor());
		m.get(i3, j3).setC(p.getP2().getColor());
		this.occupMatrix(new Tris(i1, j1, p.getP0().getColor()));
		this.occupMatrix(new Tris(i2, j2, p.getP1().getColor()));
		this.occupMatrix(new Tris(i3, j3, p.getP2().getColor()));
	}
	
	private void aggiorna() throws InterruptedException {
		if(parts.equals(Parts.PLAY)) {
			coll = false;
			Tris c1 = new Tris(p.getP0().getCoppia().getI(), p.getP0().getCoppia().getJ(), p.getP0().getColor());
			Tris c2 = new Tris(p.getP1().getCoppia().getI(), p.getP1().getCoppia().getJ(), p.getP1().getColor());
			Tris c3 = new Tris(p.getP2().getCoppia().getI(), p.getP2().getCoppia().getJ(), p.getP2().getColor());
			
			if(!p.aggiorna(m)) {
				settaPalline(c1.getI(), c2.getI(), c3.getI(), c1.getJ(), c2.getJ(), c3.getJ());
				coll = true;
			}else {
				
				for(int i = 0; i < array_coppie.size(); i++) {
					if(p.isTipo()) {	
						int tmp1i = c1.getI();
						int tmp2i = c2.getI();
						int tmp3i = c3.getI();
						int tmp1j = c1.getJ()+1;
						int tmp2j = c2.getJ()-1;
						int tmp3j = c3.getJ()+1;
						
						
						if(this.collide1(c1, i) && tmp2j >=0 && tmp3j < 10) {
							System.out.println("Collide1");
							if(this.isOccup(tmp1i, tmp1j)) {
								tmp1i--;
								tmp1j--;
							}
							if(this.isOccup(tmp2i, tmp2j)) {
								tmp2i--;
							}
							if(this.isOccup(tmp3i, tmp3j)) {
								tmp3i-=2;
								tmp3j--;
							}
							if(m.get(tmp1i, tmp1j).isWhite() &&
									m.get(tmp2i, tmp2j).isWhite()
									&& m.get(tmp3i, tmp3j).isWhite()) {
								m.get(tmp1i, tmp1j).setC(p.getP0().getColor());
								m.get(tmp2i, tmp2j).setC(p.getP1().getColor());
								m.get(tmp3i, tmp3j).setC(p.getP2().getColor());
								this.occupMatrix(new Tris(tmp1i, tmp1j, p.getP0().getColor()));
								this.occupMatrix(new Tris(tmp2i, tmp2j, p.getP1().getColor()));
								this.occupMatrix(new Tris(tmp3i, tmp3j, p.getP2().getColor()));
							}else {
								settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
								aggiustaMatrice();
							}
							coll = true;
							break;
						}
						else if(this.collide1(c1, i) && tmp3j >= 10) {
							System.out.println("Collide2");
							tmp3i -=2;
							tmp3j--;
							tmp1j-=2;
							if(m.get(tmp1i, tmp1j).isWhite() &&
									m.get(tmp2i, tmp2j).isWhite()
									&& m.get(tmp3i, tmp3j).isWhite()) {
								m.get(tmp1i, tmp1j).setC(p.getP0().getColor());
								m.get(tmp2i, tmp2j).setC(p.getP1().getColor());
								m.get(tmp3i, tmp3j).setC(p.getP2().getColor());
								this.occupMatrix(new Tris(tmp1i, tmp1j, p.getP0().getColor()));
								this.occupMatrix(new Tris(tmp2i, tmp2j, p.getP1().getColor()));
								this.occupMatrix(new Tris(tmp3i, tmp3j, p.getP2().getColor()));
							}else {
								settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
							}
							coll = true;
							break;
						}
						else if(this.collide1(c1, i) && tmp2j < 0) {
							System.out.println("Collide3");
							tmp2i-=2;
							tmp2j++;
							if(m.get(tmp1i, tmp1j).isWhite() &&
									m.get(tmp2i, tmp2j).isWhite()
									&& m.get(tmp3i, tmp3j).isWhite()) {
								m.get(tmp1i, tmp1j).setC(p.getP0().getColor());
								m.get(tmp2i, tmp2j).setC(p.getP1().getColor());
								m.get(tmp3i, tmp3j).setC(p.getP2().getColor());
								this.occupMatrix(new Tris(tmp1i, tmp1j, p.getP0().getColor()));
								this.occupMatrix(new Tris(tmp2i, tmp2j, p.getP1().getColor()));
								this.occupMatrix(new Tris(tmp3i, tmp3j, p.getP2().getColor()));
							}else {
								settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
							}
							coll = true;
							break;
						}
						else if((this.collide2(c1, i) || this.collide1(c2, i)) && tmp3j < 10) {
							System.out.println("Collide4");
							if(m.get(c1.getI(), c1.getJ()).isWhite() &&
									!m.get(c2.getI(), c2.getJ()).isWhite()
									&& !m.get(c3.getI(), c3.getJ()).isWhite()) {
								tmp2j = c2.getJ()-1;
								tmp3j = c3.getJ()+1;
								tmp1j = c1.getJ();
							}else {
								tmp1j = c1.getJ()+1;
								tmp2j = c2.getJ()+1;
								tmp3j = c3.getJ()+1;
							}
							if(m.get(tmp1i, tmp1j).isWhite() &&
									m.get(tmp2i, tmp2j).isWhite()
									&& m.get(tmp3i, tmp3j).isWhite()) {
								m.get(tmp1i, tmp1j).setC(p.getP0().getColor());
								m.get(tmp2i, tmp2j).setC(p.getP1().getColor());
								m.get(tmp3i, tmp3j).setC(p.getP2().getColor());
								this.occupMatrix(new Tris(tmp1i, tmp1j, p.getP0().getColor()));
								this.occupMatrix(new Tris(tmp2i, tmp2j, p.getP1().getColor()));
								this.occupMatrix(new Tris(tmp3i, tmp3j, p.getP2().getColor()));
							}else {
								settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
							}
							coll = true;
							break;
						}
						else if((this.collide2(c1, i) || this.collide1(c2, i)) && tmp3j >=10) {
							System.out.println("Collide5");
							tmp1j = c1.getJ();
							tmp2j = c2.getJ()+1;
							tmp3i -=2;
							tmp3j = c3.getJ();
							if(m.get(tmp1i, tmp1j).isWhite() &&
									m.get(tmp2i, tmp2j).isWhite()
									&& m.get(tmp3i, tmp3j).isWhite()) {
								m.get(tmp1i, tmp1j).setC(p.getP0().getColor());
								m.get(tmp2i, tmp2j).setC(p.getP1().getColor());
								m.get(tmp3i, tmp3j).setC(p.getP2().getColor());
								this.occupMatrix(new Tris(tmp1i, tmp1j, p.getP0().getColor()));
								this.occupMatrix(new Tris(tmp2i, tmp2j, p.getP1().getColor()));
								this.occupMatrix(new Tris(tmp3i, tmp3j, p.getP2().getColor()));
							}else {
								settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
							}
							coll = true;
							break;
						}
						else if((this.collide3(c1, i) || this.collide1(c3,i)) && tmp2j >=0) {
							System.out.println("Collide6");
							tmp1j = c1.getJ()-1;
							tmp2j = c2.getJ()-1;
							tmp3j = c3.getJ()-1;
							if(m.get(tmp1i, tmp1j).isWhite() &&
									m.get(tmp2i, tmp2j).isWhite()
									&& m.get(tmp3i, tmp3j).isWhite()) {
								m.get(tmp1i, tmp1j).setC(p.getP0().getColor());
								m.get(tmp2i, tmp2j).setC(p.getP1().getColor());
								m.get(tmp3i, tmp3j).setC(p.getP2().getColor());
								this.occupMatrix(new Tris(tmp1i, tmp1j, p.getP0().getColor()));
								this.occupMatrix(new Tris(tmp2i, tmp2j, p.getP1().getColor()));
								this.occupMatrix(new Tris(tmp3i, tmp3j, p.getP2().getColor()));
							}else {
								settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
							}
							coll = true;
							break;
						}
						else if((this.collide3(c1, i) || this.collide1(c3,i)) && tmp2j < 0) {
							System.out.println("Collide7");
							tmp1j = c1.getJ();
							tmp2i-=2;
							tmp2j = c2.getJ();
							tmp3j = c3.getJ()-1;
							if(m.get(tmp1i, tmp1j).isWhite() &&
									m.get(tmp2i, tmp2j).isWhite()
									&& m.get(tmp3i, tmp3j).isWhite()) {
								m.get(tmp1i, tmp1j).setC(p.getP0().getColor());
								m.get(tmp2i, tmp2j).setC(p.getP1().getColor());
								m.get(tmp3i, tmp3j).setC(p.getP2().getColor());
								this.occupMatrix(new Tris(tmp1i, tmp1j, p.getP0().getColor()));
								this.occupMatrix(new Tris(tmp2i, tmp2j, p.getP1().getColor()));
								this.occupMatrix(new Tris(tmp3i, tmp3j, p.getP2().getColor()));
							}else {
								settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
							}
							coll = true;
							break;
						}
					}else {
						if(this.collide1(c3, i) && p.getDirez() == 1) {
							settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
							coll = true;
							break;
						}else if(this.collide1(c2, i) && p.getDirez() == 2) {
							settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
							coll = true;
							break;
						}
					}
				}
			}	
			
			Thread.sleep(200);
			aggiustaMatrice();
			disegna();
			if(coll) {
				p.getP0().setX(-500);
				p.getP1().setX(-500);
				p.getP2().setX(-500);
				disegna();
				balls.clear();
				while(scoppiaPalline()) {
					Thread.sleep(200);
					disegna();
					Thread.sleep(200);
					aggiustaMatrice();
					disegna();
					Thread.sleep(200);
					balls.clear();
				}
				createTripleSucc();
				this.dlv();
			}
				
			if(!m.get(0, 4).isWhite() || !m.get(1, 4).isWhite() && m.get(1,5).isWhite())
				parts = Parts.LOST;
		}	
	}
	 private synchronized void start(){
	        if(running)
	            return;
	        
	        running = true;
	        thread = new Thread(this);
	        thread.start();
	    }
	    
	 private synchronized void stop(){
	       if(!running)
	            return;
	        
	       running = false;
	       try {
	    	   thread.join();
	       } catch (InterruptedException ex) {
	    	   Logger.getLogger(PileOfBalls.class.getName()).log(Level.SEVERE, null, ex);
	       }
	       System.exit(1);
	 }

	public void run() {
		try {
			this.init();
		} catch (IncorrectInitAltMatrixException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//disegna();
		
		while(running) {
			if(sogliaLivello <= punteggio){
				livello++;
				punteggio = 0;
				if(livello == 2){
					try {
						this.init2();
					} catch (IncorrectInitAltMatrixException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(livello == 3){
					try {
						this.init3();
					} catch (IncorrectInitAltMatrixException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(livello > 3){
					try {
						Thread.sleep(3000);
						running = false;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(running){
				disegna();
				try {
					Thread.sleep(100);
					aggiorna();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}stop();
	}

	public void keyPressed(KeyEvent arg0) {
		int botton = arg0.getKeyCode();
		switch(botton) {
			case KeyEvent.VK_RIGHT:
				if(parts.equals(Parts.PLAY)) {
					p.goRight();
					disegna();
				}
				break;
			case KeyEvent.VK_LEFT:
				if(parts.equals(Parts.PLAY)) {
					p.goLeft();
					disegna();
				}
				break;
			case KeyEvent.VK_UP:
				if(parts.equals(Parts.PLAY)) {
					p.giraSx();
					disegna();
				}
				break;
			case KeyEvent.VK_DOWN:
				if(parts.equals(Parts.PLAY)) {
					p.giraDx();
					disegna();
				}
				break;
			case KeyEvent.VK_ENTER:
				switch(parts) {
					case MENU:
					try {
						init();
						parts = Parts.PLAY;
						break;
					} catch (IncorrectInitAltMatrixException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					case PLAY:
						parts = Parts.PAUSE;
						break;
					case PAUSE:
						parts = Parts.PLAY;
						break;
					case LOST:
						parts = Parts.MENU;
						break;
				default:
					break;
				}
			case KeyEvent.VK_I:
				ia_attivo = !ia_attivo;
				break;
			default:
				break;
		}
	}

	private void dlv(){
		if(this.ia_attivo){
			ArrayList<Lista> tripla = new ArrayList<Lista>();
			tripla.add(new Lista(0, p.getP0().getCoppia().getI(), p.getP0().getCoppia().getJ(), p.getP0().getColor()));
			tripla.add(new Lista(1, p.getP1().getCoppia().getI(), p.getP1().getCoppia().getJ(), p.getP1().getColor()));
			tripla.add(new Lista(2, p.getP2().getCoppia().getI(), p.getP2().getCoppia().getJ(), p.getP2().getColor()));
			
			ArrayList<Lista> triplasucc = new ArrayList<Lista>();
			triplasucc.add(new Lista(0, p_succ.getP0().getCoppia().getI(), p_succ.getP0().getCoppia().getJ(), p_succ.getP0().getColor()));
			triplasucc.add(new Lista(1, p_succ.getP1().getCoppia().getI(), p_succ.getP1().getCoppia().getJ(), p_succ.getP1().getColor()));
			triplasucc.add(new Lista(2, p_succ.getP2().getCoppia().getI(), p_succ.getP2().getCoppia().getJ(), p_succ.getP2().getColor()));
		
			ArrayList<Lista> occupati = new ArrayList<Lista>();
			ArrayList<Pair> costo = new ArrayList<Pair>();
			
			for(int i = 0; i < array_coppie.size(); i++){
				occupati.add(new Lista(i, array_coppie.get(i).getI(), array_coppie.get(i).getJ(), array_coppie.get(i).getColor()));
				costo.add(new Pair(i, this.formaUnaTripla(array_coppie.get(i))));
			}
			
			try {
				disegna();
				ArrayList<ListaSeven> ris = ia.scegliPosizione(occupati, tripla, triplasucc, costo, this.posLibere());
				if(!ris.isEmpty()){
					int pos = -1;
					for(int i = 0; i < ris.size(); i++)
						if(ris.get(i).getFive() != 2)
							pos = i;
					
					if(pos == -1){
						pos = 0;
						ris.get(pos).setFive(0);
					}
					
					int j = ris.get(pos).getThird();
					if(j == 9)
						ris.get(pos).setThird(ris.get(pos).getThird()-1);
					
					System.out.println("Colore: "+ris.get(pos).getFour());
					System.out.println(ris.get(pos));
					p.getP0().setX(p.getP0().getX()-(50*(p.getP0().getCoppia().getJ()-ris.get(pos).getThird())));
					p.getP1().setX(p.getP1().getX()-(50*(p.getP1().getCoppia().getJ()-ris.get(pos).getThird())));
					p.getP2().setX(p.getP2().getX()-(50*((p.getP2().getCoppia().getJ()-1)-ris.get(pos).getThird())));
					
					p.getP0().getCoppia().setJ(ris.get(pos).getThird());
					p.getP1().getCoppia().setJ(ris.get(pos).getThird());
					p.getP2().getCoppia().setJ(ris.get(pos).getThird()+1);
					
					if(p.getP0().getCoppia().getJ() > 0){
						p.getP0().getCoppia().setJ(p.getP0().getCoppia().getJ()-ris.get(pos).getFive());
						p.getP1().getCoppia().setJ(p.getP1().getCoppia().getJ()-ris.get(pos).getFive());
						p.getP2().getCoppia().setJ(p.getP2().getCoppia().getJ()-ris.get(pos).getFive());
						
						p.getP0().setX(p.getP0().getX()-(50*ris.get(pos).getFive()));
						p.getP1().setX(p.getP1().getX()-(50*ris.get(pos).getFive()));
						p.getP2().setX(p.getP2().getX()-(50*ris.get(pos).getFive()));
					}
					
					while(!p.getBall(ris.get(pos).getSix()).getColor().equals(ris.get(pos).getFourColor(ris.get(pos).getFour()))){
						p.giraDx();
						p.giraDx();
					}
					
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		disegna();		
	}
	
	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
}
