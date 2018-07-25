package esami.ia.pileofballs;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class PileOfBalls extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	private AlternateMatrix m;
	private TripleBalls p;
	private ArrayList<Pair> array_coppie;
	private ArrayList<Pair> balls;
	private boolean running = false;
    private Thread thread;
    private boolean coll = false;
   // private boolean isCompl = true;
	
	public static void main(String[] args) {
		PileOfBalls pob = new PileOfBalls();
        
        pob.setPreferredSize(new Dimension(700, 680));
        pob.setMaximumSize(new Dimension(700, 680));
        pob.setMinimumSize(new Dimension(700, 680));
        
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
	}
	
	private void init() throws IncorrectInitAltMatrixException {
		 m = new AlternateMatrix(10);
		 array_coppie = new ArrayList<Pair>();
		 balls = new ArrayList<Pair>();
		 createTriple();
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
        m.getElements(g);
        p.disegna(g);
        
        g.dispose();
        bs.show();
	}
	
	private boolean collide1(Pair c, int i) {
		//if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ())
		if(array_coppie.get(i).equals(c))
			return true;
		
		return false;
	}
	
	private boolean collide2(Pair c, int i) {
		if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ()-1)
			return true;
		return false;
	}
	
	private boolean collide3(Pair c, int i) {
		if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ()+1)
			return true;
		return false;
	}
	
	private boolean isOccup(int x, int y) {
		Pair c = new Pair(x, y);
		for(int i = 0; i < array_coppie.size(); i++) {
			if(array_coppie.get(i).equals(c)) 
				return true;
		}	
		return false;
	}
	
	private void occupMatrix(Pair c) {
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
	
	private void freeMatrix(Pair c) {
		for(int i = 0; i < array_coppie.size(); i++)
			if(array_coppie.get(i).equals(c)) {
				array_coppie.remove(i);
				break;
			}
	}
	
	private void addBalls(Pair c) {
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
		Pair c;
		Color col;
		boolean ok = false;
		while(!ok) {
			ok = true;
			for(int i = 0; i < m.getDim(); i++) {
				if(m.getInternSize(i)%2 == 0) {
					for(int j = 0; j < m.getInternSize(i); j++) {
						col = m.get(i, j).getColor();
						c = new Pair(i, j);
						if(i+1 < m.getDim()) {
							if(j-1 >= 0) {
								if(!m.get(i, j).isWhite() && m.get(i+1, j-1).isWhite()) {
									this.freeMatrix(c);
									m.get(i, j).setC(Color.WHITE);
									
									this.occupMatrix(new Pair(i+1, j-1));
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
								
								this.occupMatrix(new Pair(i+1, j));
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
						c = new Pair(i, j);
						if(i+1 < m.getDim()) {
							if(!m.get(i, j).isWhite() && m.get(i+1, j).isWhite()) {
								this.freeMatrix(c);
								m.get(i, j).setC(Color.WHITE);
								
								this.occupMatrix(new Pair(i+1, j));
								m.get(i+1, j).setC(col);
								ok = false;
								break;
							}
							
							if(j+1 < m.getInternSize(i+1)) {
								if(!m.get(i, j).isWhite() && m.get(i+1, j+1).isWhite()) {
									this.freeMatrix(c);
									m.get(i, j).setC(Color.WHITE);
									
									this.occupMatrix(new Pair(i+1, j+1));
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
		Pair p;
		int t;
		int intDim;
		boolean contin = false;
		for(int i = 0; i < array_coppie.size(); i++) {
			this.addBalls(array_coppie.get(i));
			col = m.get(array_coppie.get(i).getI(), array_coppie.get(i).getJ()).getColor();
			for(int j = 0; j < balls.size(); j++) {
				if(balls.get(j).getI()%2 == 0) {
					t = 1;
					intDim = 8;
				}	
				else {
					t = -1;
					intDim = 9;
				}
				if(m.get(balls.get(j).getI(), balls.get(j).getJ()+1).getColor().equals(col) && balls.get(j).getJ()+1 < intDim) {
					System.out.println("caso 1");
					p = new Pair(balls.get(j).getI(), balls.get(j).getJ()+1);
					this.addBalls(p);
				}
						
				if(m.get(balls.get(j).getI(), balls.get(j).getJ()-1).getColor().equals(col) && balls.get(j).getJ()-1 >= 0) {
					System.out.println("caso 2");
					p = new Pair(balls.get(j).getI(), balls.get(j).getJ()-1);
					this.addBalls(p);
				}
						
				if(m.get(balls.get(j).getI()+1, balls.get(j).getJ()).getColor().equals(col) && balls.get(j).getI()+1 < m.getDim()) {
					System.out.println("caso 3");
					p = new Pair(balls.get(j).getI()+1, balls.get(j).getJ());
					this.addBalls(p);
				}
						
				if(m.get(balls.get(j).getI()-1, balls.get(j).getJ()).getColor().equals(col) && balls.get(j).getI()-1 >= 0) {
					System.out.println("caso 4");
					p = new Pair(balls.get(j).getI()-1, balls.get(j).getJ());
					this.addBalls(p);
				}
						
				if(m.get(balls.get(j).getI()+1, balls.get(j).getJ()+t).getColor().equals(col) && balls.get(j).getI()+1 < m.getDim() 
					&& balls.get(j).getJ()+t >=0 && balls.get(j).getJ()+t < intDim) {
					System.out.println("caso 5");
					p = new Pair(balls.get(j).getI()+1, balls.get(j).getJ()+t);
					this.addBalls(p);
				}
						
				if(m.get(balls.get(j).getI()-1, balls.get(j).getJ()+t).getColor().equals(col) && balls.get(j).getI()-1 >= 0
					&& balls.get(j).getJ()+t >=0 && balls.get(j).getJ()+t < intDim) {
					System.out.println("caso 6");
					p = new Pair(balls.get(j).getI()-1, balls.get(j).getJ()+t);
					this.addBalls(p);
				}
			}
			System.out.println("Balls size: "+balls.size());
			if(balls.size() > 3) {
				for(int y = 0; y < balls.size(); y++) {
					m.get(balls.get(y).getI(), balls.get(y).getJ()).setC(Color.WHITE);
					this.freeMatrix(balls.get(y));
					System.out.println(balls.get(y).toString());
					contin = true;
				}
			}
			balls = new ArrayList<Pair>();
			System.out.println("Array size: "+array_coppie.size());
			System.out.println("Balls size: "+balls.size());
		}
		
		return contin;
	}
	
	private void settaPalline(int i1, int i2, int i3, int j1, int j2, int j3) {
		m.get(i1, j1).setC(p.getP0().getColor());
		m.get(i2, j2).setC(p.getP1().getColor());
		m.get(i3, j3).setC(p.getP2().getColor());
		this.occupMatrix(new Pair(i1, j1));
		this.occupMatrix(new Pair(i2, j2));
		this.occupMatrix(new Pair(i3, j3));
	}
	
	private void aggiorna() {
		coll = false;
		Pair c1 = new Pair(p.getP0().getCoppia().getI(), p.getP0().getCoppia().getJ());
		Pair c2 = new Pair(p.getP1().getCoppia().getI(), p.getP1().getCoppia().getJ());
		Pair c3 = new Pair(p.getP2().getCoppia().getI(), p.getP2().getCoppia().getJ());
		
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
							this.occupMatrix(new Pair(tmp1i, tmp1j));
							this.occupMatrix(new Pair(tmp2i, tmp2j));
							this.occupMatrix(new Pair(tmp3i, tmp3j));
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
							this.occupMatrix(new Pair(tmp1i, tmp1j));
							this.occupMatrix(new Pair(tmp2i, tmp2j));
							this.occupMatrix(new Pair(tmp3i, tmp3j));
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
							this.occupMatrix(new Pair(tmp1i, tmp1j));
							this.occupMatrix(new Pair(tmp2i, tmp2j));
							this.occupMatrix(new Pair(tmp3i, tmp3j));
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
							this.occupMatrix(new Pair(tmp1i, tmp1j));
							this.occupMatrix(new Pair(tmp2i, tmp2j));
							this.occupMatrix(new Pair(tmp3i, tmp3j));
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
							this.occupMatrix(new Pair(tmp1i, tmp1j));
							this.occupMatrix(new Pair(tmp2i, tmp2j));
							this.occupMatrix(new Pair(tmp3i, tmp3j));
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
							this.occupMatrix(new Pair(tmp1i, tmp1j));
							this.occupMatrix(new Pair(tmp2i, tmp2j));
							this.occupMatrix(new Pair(tmp3i, tmp3j));
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
							this.occupMatrix(new Pair(tmp1i, tmp1j));
							this.occupMatrix(new Pair(tmp2i, tmp2j));
							this.occupMatrix(new Pair(tmp3i, tmp3j));
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
		
		
		aggiustaMatrice();
		if(coll) {
			p.getP0().setX(-500);
			p.getP1().setX(-500);
			p.getP2().setX(-500);
			disegna();
			while(scoppiaPalline()) {
				aggiustaMatrice();
			}
			createTriple();
		}
			
		if(!m.get(0, 4).isWhite() || !m.get(1, 4).isWhite() && m.get(1,5).isWhite())
			running = false;
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

	@Override
	public void run() {
		try {
			init();
		} catch (IncorrectInitAltMatrixException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//disegna();
		
		while(running) {
			disegna();
			try {
				Thread.sleep(500);
				aggiorna();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}stop();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int botton = arg0.getKeyCode();
		switch(botton) {
			case KeyEvent.VK_RIGHT:
				p.goRight();
				disegna();
				break;
			case KeyEvent.VK_LEFT:
				p.goLeft();
				disegna();
				break;
			case KeyEvent.VK_UP:
				p.giraSx();
				disegna();
				break;
			case KeyEvent.VK_DOWN:
				p.giraDx();
				disegna();
				break;
			default:
				System.out.println("Comando non valido");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
