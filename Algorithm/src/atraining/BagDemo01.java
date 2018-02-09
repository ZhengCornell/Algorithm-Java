package atraining;

public class BagDemo01 {

	public static void main(String[] args) {
		int[] val = {10,40,30,50};
		int[] wt = {5,4,6,3};
		int W = 10;
		System.out.println(bag(val,wt,W));
		
	
		
	}

	
	
	
	
	public static int bag(int[] val, int[] wt, int W){
		int N = wt.length;//物品总数
		int[][] V = new int[N+1][W+1];//物品组合：价格配重量 N=4,W=10
		for(int col = 0; col < W + 1; col++){
			V[0][col] = 0;
		}
		for(int row = 0; row < N + 1; row++){
			V[row][0] = 0;
		}
		
		for(int item = 1; item <= N; item++){
			for(int weight = 1; weight <= W; weight++){
				if(wt[item-1]<=weight){
					V[item][weight] = Math.max(val[item-1]+V[item-1][weight-wt[item-1]],V[item-1][weight]);
				}else{
					V[item][weight] = V[item-1][weight];
				}
				
			}
		}
		return V[N][W];
		
		
	}
}
