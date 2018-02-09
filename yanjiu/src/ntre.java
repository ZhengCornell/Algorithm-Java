
public class ntre {

	public static void main(String[] args) {
		double sum = 0;
		double[] R = new double[24];
		R[0] = 0.1183;
		R[1] = 0.0013;
		R[2] = 0.3561;
		R[3] = 0.0026;
		R[4] = 0.0434;
		R[5] = 0.0499;
		R[6] = 0.0171;
		R[7] = 0.0355;
		R[8] = 0.0013;
		R[9] = 0.0946;
		R[10] = 0.0250;
		R[11] = 0.0092;
		R[12] = 0.0486;
		R[13] = 0.0618;
		R[14] = 0.0092;
		R[15] = 0.0026;
		R[16] = 0.0026;
		R[17] = 0.0223;
		R[18] = 0.0013;
		R[19] = 0.0289;
		R[20] = 0.0013;
		R[21] = 0.0604;
		R[22] = 0.0013;
		R[23] = 0.0053;
				
				
				
		for(int i = 0; i < 24; i++){
			double gg = R[i]*Math.log(R[i]);
			sum = sum + gg;
		}
		System.out.println(sum);
	}

}
