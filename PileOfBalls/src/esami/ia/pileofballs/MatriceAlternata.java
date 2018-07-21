package esami.ia.pileofballs;

import java.awt.Graphics;

public class MatriceAlternata {
	private Palla matrix[][];
	private int dim;
	
	public MatriceAlternata(int dim) throws IncorrectInitAltMatrixException {
		if(dim%2!=0 || dim < 10)
			throw new IncorrectInitAltMatrixException();
		
		matrix = new Palla[dim][];
		this.dim = dim;
		int x = 0;
		int y = 0;
		for(int i = 0; i < dim; i++) {
			if(i%2==0) {
				matrix[i] = new Palla[9];
				x = 25;
			}	
			else {
				matrix[i] = new Palla[10];
				x = 0;
			}	
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new Palla(x,y,i,j);
				x+=50;
			}
			y+=50;
		}
	}
	
	public int getDim() {
		return dim;
	}

	/*public void setDim(int dim) {
		this.dim = dim;
	}*/

	public Palla get(int i, int j) {
		if(i >= getDim())
			i=getDim()-1;
		
		if(j >= this.getInternSize(i))
			j=this.getInternSize(i)-1;
		
		if(i < 0)
			i = 0;
		
		if(j < 0)
			j = 0;
		
		return matrix[i][j];
	}
	
	public void setInPos(Palla p, int i, int j) {
		this.matrix[i][j] = p;
	}
	
	public int getInternSize(int i) {
		return matrix[i].length;
	}
	
	/*public Coppia setWithXY(Palla p) {
		Coppia tmp;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j].getX() == p.getX() && matrix[i][j].getY() == p.getY()) {
					matrix[i][j] = p;
						
					tmp = new Coppia(i, j);
					return tmp;
				}
			}
		}	
		tmp = new Coppia();
		return tmp;
	}
	
	public void setPallaOne(Palla p1) {
		for(int i = 0; i < matrix.length; i++) 
			for(int j = 0; j < matrix[i].length; j++) 
				if(matrix[i][j].getX() == p1.getX() && matrix[i][j].getY() == p1.getY()) {
					
					
					matrix[i][j+1].setC(p1.getColor());
					
				}	
	}
	
	public void setPallaTwo(Palla p2) {
		for(int i = 0; i < matrix.length; i++) 
			for(int j = 0; j < matrix[i].length; j++) 
				if(matrix[i][j].getX() == p2.getX() && matrix[i][j].getY() == p2.getY()) {
					if(j>0)
						matrix[i][j-1].setC(p2.getColor());
					else
						matrix[i-2][j].setC(p2.getColor());
					return;
				}	
	}
	
	public void setPallaThree(Palla p3) {
		for(int i = 0; i < matrix.length; i++) 
			for(int j = 0; j < matrix[i].length; j++) 
				if(matrix[i][j].getX() == p3.getX() && matrix[i][j].getY() == p3.getY()) {
					
					matrix[i][j+1].setC(p3.getColor());
					return;
				}	
	}
	
	public boolean getWithXY(int x, int y) {
		Palla tmp = null;
		boolean ok = false;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++)
				if(matrix[i][j].getX() == x && matrix[i][j].getY() == y) {
					tmp = matrix[i][j];
					ok = true;
					break;
				}
			if(ok)
				break;
		}
		
		if(!ok)
			return true;
		else {
			if(tmp.getColor().equals(Color.WHITE))
				return true;
			else
				return false;
		}
	}*/
	
	public void getElements(Graphics g) {
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++){
				//matrix[i][j].setC(Color.white);
				matrix[i][j].disegna(g);
			}
			
			System.out.println();
		}
	}
}
