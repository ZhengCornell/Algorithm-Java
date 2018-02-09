package atraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ShuffleTest {

		public static void main(String[] args) {
			int M = 4;
			int N = 400000;
			List<Integer> l = new ArrayList<Integer>();
			List<Integer> o = new ArrayList<Integer>();
			for(int i = 0; i < M ;i++){
				l.add(i);
				o.add(i);
			}
			
			Map m = create(o,M);
			for(int k = 1; k <= N; k++){
				l = o;
			Collections.shuffle(l);
//			System.out.println("");
//			System.out.print("第"+k+"次打乱");
			for(int i = 0; i < M; i++){
				for(int j = 1; j <= M; j++){
				if(l.get(j-1) == i){
					int[] a = (int[]) m.get(i);
					a[j-1]++;
					m.put(i,a);
				}
				}
			}
//			if(l.get(0) == 0) count0[1]++;
//			if(l.get(1) == 0) count0[2]++;
//			if(l.get(2) == 0) count0[3]++;
//			if(l.get(3) == 0) count0[4]++;
//			if(l.get(0) == 1) count1[1]++;
//			if(l.get(1) == 1) count1[2]++;
//			if(l.get(2) == 1) count1[3]++;
//			if(l.get(3) == 1) count1[4]++;
//			if(l.get(0) == 2) count2[1]++;
//			if(l.get(1) == 2) count2[2]++;
//			if(l.get(2) == 2) count2[3]++;
//			if(l.get(3) == 2) count2[4]++;
//			if(l.get(0) == 3) count3[1]++;
//			if(l.get(1) == 3) count3[2]++;
//			if(l.get(2) == 3) count3[3]++;
//			if(l.get(3) == 3) count3[4]++;
//			
//			for(int j = 0; j < M; j++){
//				System.out.print(l.get(j));
//				
//			}
			
			}
			System.out.println("");
			for(int i = 0; i < M;i++){
				
				System.out.println(Arrays.toString((int []) m.get(i)));
			}
			
//			System.out.println(count0[1]+" "+count1[1]+" "+count2[1]+" "+count3[1]);
//			System.out.println(count0[2]+" "+count1[2]+" "+count2[2]+" "+count3[2]);
//			System.out.println(count0[3]+" "+count1[3]+" "+count2[3]+" "+count3[3]);
//			System.out.println(count0[4]+" "+count1[4]+" "+count2[4]+" "+count3[4]);
		
		
		
		
		
		
		
		}
		
		public static Map create(List<Integer> o,int M){
			Map m = new HashMap();
			for(int i = 0; i < M; i++){
				int[] count = new int[M];
				
				m.put(i,count);
			}
			return m;
		
		
		
		
		
		
		}

		
		
		
}

