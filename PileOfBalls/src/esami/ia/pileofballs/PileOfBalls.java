package esami.ia.pileofballs;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class PileOfBalls extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MatriceAlternata m;
	private TriplePalle p;
	private ArrayList<Coppia> array_coppie;
	private boolean running = false;
    private Thread thread;
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
        //frame.addKeyListener(pob);
        
        pob.start();
	}
	
	private void createTriple() {
		Random r = new Random();
		//int j = r.nextInt(9);
		int j = 4; 
		int i = 0;
		p = new TriplePalle(m.get(i,j),m.get(i+1,j),m.get(i+1,j+1));
	}
	
	private void init() throws IncorrectInitAltMatrixException {
		 m = new MatriceAlternata(10);
		 array_coppie = new ArrayList<Coppia>();
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
	
	private void settaPalline() {
		m.setInPos(p.getP0(), p.getP0().getCoppia().getI(), p.getP0().getCoppia().getJ());
		m.setInPos(p.getP1(), p.getP1().getCoppia().getI(), p.getP1().getCoppia().getJ());
		m.setInPos(p.getP2(), p.getP2().getCoppia().getI(), p.getP2().getCoppia().getJ());
		array_coppie.add(new Coppia(p.getP0().getCoppia().getI(), p.getP0().getCoppia().getJ()));
		array_coppie.add(new Coppia(p.getP1().getCoppia().getI(), p.getP1().getCoppia().getJ()));
		array_coppie.add(new Coppia(p.getP2().getCoppia().getI(), p.getP2().getCoppia().getJ()));
	}
	
	private boolean collide1(Coppia c, int i) {
		//if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ())
		if(array_coppie.get(i).equals(c))
			return true;
		
		return false;
	}
	
	private boolean collide2(Coppia c, int i) {
		if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ()-1)
			return true;
		return false;
	}
	
	private boolean collide3(Coppia c, int i) {
		if(array_coppie.get(i).getI() == c.getI() && array_coppie.get(i).getJ() == c.getJ()+1)
			return true;
		return false;
	}
	
	private boolean isOccup(int x, int y) {
		Coppia c = new Coppia(x, y);
		for(int i = 0; i < array_coppie.size(); i++) {
			if(array_coppie.get(i).equals(c)) 
				return true;
		}	
		return false;
	}
	
	private void rimuoviDaArray(Coppia c) {
		for(int i = 0; i < array_coppie.size(); i++)
			if(array_coppie.get(i).equals(c))
				array_coppie.remove(i);
	}
	
	private void aggiustaMatrice() {
		Coppia c;
		Color col;
		boolean ok = false;
		while(!ok) {
			ok = true;
			for(int i = 0; i < m.getDim(); i++) {
				if(m.getInternSize(i)%2 == 0) {
					for(int j = 0; j < m.getInternSize(i); j++) {
						col = m.get(i, j).getColor();
						c = new Coppia(i, j);
						if(i+1 < m.getDim()) {
							if(j-1 >= 0) {
								if(!m.get(i, j).isWhite() && m.get(i+1, j-1).isWhite()) {
									this.rimuoviDaArray(c);
									m.get(i, j).setC(Color.WHITE);
									
									array_coppie.add(new Coppia(i+1, j-1));
									m.get(i+1, j-1).setC(col);
									ok = false;
									break;
								}
							}else {
								//System.out.println("ERROR! j-1 < 0.");
							}
							
							if(!m.get(i, j).isWhite() && m.get(i+1, j).isWhite()) {
								this.rimuoviDaArray(c);
								m.get(i, j).setC(Color.WHITE);
								
								array_coppie.add(new Coppia(i+1, j));
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
						c = new Coppia(i, j);
						if(i+1 < m.getDim()) {
							if(!m.get(i, j).isWhite() && m.get(i+1, j).isWhite()) {
								this.rimuoviDaArray(c);
								m.get(i, j).setC(Color.WHITE);
								
								array_coppie.add(new Coppia(i+1, j));
								m.get(i+1, j).setC(col);
								ok = false;
								break;
							}
							
							if(j+1 < m.getInternSize(i+1)) {
								if(!m.get(i, j).isWhite() && m.get(i+1, j+1).isWhite()) {
									this.rimuoviDaArray(c);
									m.get(i, j).setC(Color.WHITE);
									
									array_coppie.add(new Coppia(i+1, j+1));
									m.get(i+1, j+1).setC(col);
									ok = false;
									break;
								}
							}else {
								//System.out.println("ERROR! j+1 >= internalSize");
							}
						}else {
							System.out.println("ERROR! i+1 >= dim");
						}
					}
				}
			}
		}
	}
	//messa in pausa
	private void scoppiaPalline() {
		int cont = 1;
		int x = 1;
		int y = 1;
		ArrayList<Coppia> tmp = new ArrayList<Coppia>();
		for(int i = 0; i < m.getDim(); i++) {
			for(int j = 0; j < m.getInternSize(i); j++) {
				if(!m.get(i, j).isWhite()) {
					while(m.get(i, j+x).getColor().equals(m.get(i, j).getColor())) {
						cont++;
						x++;
						tmp.add(new Coppia(i, j+x));
					}
					x = 1;
					while(m.get(i, j-x).getColor().equals(m.get(i, j).getColor())) {
						x++;
						cont++;
						tmp.add(new Coppia(i, j-x));
					}
					System.out.println(cont);
					break;
				}
			}
			if(cont >= 4) 
				break;
		}
		
		if(cont >= 4) {
			for(int i = 0; i < tmp.size(); i++) {
				System.out.println(tmp.get(i).toString());
				m.get(tmp.get(i).getI(), tmp.get(i).getJ()).setC(Color.WHITE);
			}
		}
	}
	
	private void settaPalline(int i1, int i2, int i3, int j1, int j2, int j3) {
		m.get(i1, j1).setC(p.getP0().getColor());
		m.get(i2, j2).setC(p.getP1().getColor());
		m.get(i3, j3).setC(p.getP2().getColor());
		array_coppie.add(new Coppia(i1, j1));
		array_coppie.add(new Coppia(i2, j2));
		array_coppie.add(new Coppia(i3, j3));
	}
	
	private void aggiorna() {
		
		if(!p.aggiorna(m)) {
			
			settaPalline();
			createTriple();
		}else {
			Coppia c1 = new Coppia(p.getP0().getCoppia().getI(), p.getP0().getCoppia().getJ());
			Coppia c2 = new Coppia(p.getP1().getCoppia().getI(), p.getP1().getCoppia().getJ());
			Coppia c3 = new Coppia(p.getP2().getCoppia().getI(), p.getP2().getCoppia().getJ());
			for(int i = 0; i < array_coppie.size(); i++) {
				
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
						array_coppie.add(new Coppia(tmp1i, tmp1j));
						array_coppie.add(new Coppia(tmp2i, tmp2j));
						array_coppie.add(new Coppia(tmp3i, tmp3j));
					}else {
						settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
						aggiustaMatrice();
					}
					createTriple();
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
						array_coppie.add(new Coppia(tmp1i, tmp1j));
						array_coppie.add(new Coppia(tmp2i, tmp2j));
						array_coppie.add(new Coppia(tmp3i, tmp3j));
					}else {
						settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
					}
					createTriple();
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
						array_coppie.add(new Coppia(tmp1i, tmp1j));
						array_coppie.add(new Coppia(tmp2i, tmp2j));
						array_coppie.add(new Coppia(tmp3i, tmp3j));
					}else {
						settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
					}
					createTriple();
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
						array_coppie.add(new Coppia(tmp1i, tmp1j));
						array_coppie.add(new Coppia(tmp2i, tmp2j));
						array_coppie.add(new Coppia(tmp3i, tmp3j));
					}else {
						settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
					}
					createTriple();
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
						array_coppie.add(new Coppia(tmp1i, tmp1j));
						array_coppie.add(new Coppia(tmp2i, tmp2j));
						array_coppie.add(new Coppia(tmp3i, tmp3j));
					}else {
						settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
					}
					createTriple();
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
						array_coppie.add(new Coppia(tmp1i, tmp1j));
						array_coppie.add(new Coppia(tmp2i, tmp2j));
						array_coppie.add(new Coppia(tmp3i, tmp3j));
					}else {
						settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
					}
					createTriple();
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
						array_coppie.add(new Coppia(tmp1i, tmp1j));
						array_coppie.add(new Coppia(tmp2i, tmp2j));
						array_coppie.add(new Coppia(tmp3i, tmp3j));
					}else {
						settaPalline(c1.getI()-2, c2.getI()-2, c3.getI()-2, c1.getJ(), c2.getJ(), c3.getJ());
					}
					createTriple();
					break;
				}
			}
		}
		aggiustaMatrice();
		//scoppiaPalline();
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
}
