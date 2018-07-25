package esami.ia.pileofballs;

import java.awt.Graphics;

public class AlternateMatrix {
	private Ball matrix[][];
	private int dim;
	
	public AlternateMatrix(int dim) throws IncorrectInitAltMatrixException {
		if(dim%2!=0 || dim < 10)
			throw new IncorrectInitAltMatrixException();
		
		matrix = new Ball[dim][];
		this.dim = dim;
		int x = 0;
		int y = 0;
		for(int i = 0; i < dim; i++) {
			if(i%2==0) {
				matrix[i] = new Ball[9];
				x = 25;
			}	
			else {
				matrix[i] = new Ball[10];
				x = 0;
			}	
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new Ball(x,y,i,j);
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

	public Ball get(int i, int j) {
		if(i >= getDim())
			i=getDim()-1;
		
		int intDim;
		if(i%2 == 0)
			intDim = 8;
		else
			intDim = 9;
		
		if(j >= intDim)
			j=intDim-1;
		
		if(i < 0)
			i = 0;
		
		if(j < 0)
			j = 0;
		
		return matrix[i][j];
	}
	
	public void setInPos(Ball p, int i, int j) {
		this.matrix[i][j] = p;
	}
	
	public int getInternSize(int i) {
		return matrix[i].length;
	}
	
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
