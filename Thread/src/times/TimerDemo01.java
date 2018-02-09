package times;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo01 {

	public static void main(String[] args) {
	Timer timer = new Timer();
	TimerTask tt = new TimerTask(){

		@Override
		public void run() {
			System.out.println("终于构造出来了");
		}
		
	};
	
//	tt.run
	timer.schedule(tt,new Date(System.currentTimeMillis()+1000),200);

	}

}
