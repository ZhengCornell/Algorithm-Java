
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
	private boolean[][] opened;
	private int bottom;
	private WeightedQuickUnionUF qf;
	private int size;

	
	
	
	
	public Percolation(int n) {
		if(n <= 0){
			throw new IllegalArgumentException();
		}else{
		int row = n;
		int col = n;
		size = n;
		bottom = n*n+1;
		qf = new WeightedQuickUnionUF(bottom+1);
		opened = new boolean[row+1][col+1];
		for(int i = 1; i <= row; i++){
			for(int j = 1; j <= col; j++){
				opened[i][j] = false;
			}
		}
		}
	}

	public void open(int row, int col) {
	if (0 < row && row <= size && 0 < col && col <= size) {
		opened[row][col] = true;
		if (row == 1) {
			qf.union(col,0);
		}
		if (row == size) {
			qf.union((row-1)*size+col, bottom);
		}
		if (col > 1 && isOpen(row, col-1)) {
			qf.union((row-1)*size+col-1, (row-1)*size+col);
		}
		if (col < size && isOpen(row, col+1)) {
			qf.union((row-1)*size+col+1, (row-1)*size+col);
		}
		if (row > 1 && isOpen(row - 1, col)) {
			qf.union((row-2)*size+col, (row-1)*size+col);
		}
		if (row < size && isOpen(row + 1, col)) {
			qf.union((row)*size+col, (row-1)*size+col);
		}
		} else{
			throw new IllegalArgumentException();
		}
		
	}
	
	public boolean isOpen(int row, int col) {
		if (0 < row && row <= size && 0 < col && col <= size) {
		return opened[row][col];
		} else{
			throw new IllegalArgumentException();
		}
	}
	
	public boolean isFull(int row, int col) {
		if (0 < row && row <= size && 0 < col && col <= size) {
			return qf.connected(0, (row-1)*size + col);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int numberOfOpenSites() {
		int num = 0;
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (isOpen(i, j)){
					num++;
				}
			}
		}
		return num;
	}

	public boolean percolates() {
		return qf.connected(0, bottom);
	}
	
	public static void main(String[] args) {
		Percolation p = new Percolation(5);
		p.open(1, 1);
		p.open(2, 1);
		p.open(3, 1);
		p.open(4, 1);
		p.open(5, 1);
		System.out.println(p.numberOfOpenSites());
		System.out.println(p.percolates());
		System.out.println(p.isOpen(1,1 ));
	}

}

