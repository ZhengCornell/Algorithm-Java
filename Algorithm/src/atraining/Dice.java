package atraining;

public class Dice {

	public static void main(String[] args) {
		int[] count = new int[13];
		int N = 5000000;
		for(int i = 1; i <= N; i++){
			int j = (int)(1+Math.random()*(6))+(int)(1+Math.random()*(6));
//			double d = test(j);
//			System.out.println(j+"对应概率"+d);
			count[j] ++;
		}
		for(int k = 2; k<=12; k++){
			System.out.println(k+"对应概率"+(double)count[k]*1.0/N);
		}
		

	}
	
	public static double test(int num){
		int s = 6;
		double[] dist = new double[13];
		double[] pro = new double[13];
		for(int i = 1; i <= s; i++){
			for(int j = 1; j <= s; j++){
				dist[i+j] = dist[i+j] + 1;
			}
		}
		for(int k = 2; k <= 2*s; k++){
			pro[k] = dist[k] / 36;
		}
		return pro[num];
	}

}
