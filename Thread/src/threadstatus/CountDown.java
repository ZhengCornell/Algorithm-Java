package threadstatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CountDown {
	public static void main(String args[]) throws InterruptedException{
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end = endTime.getTime();
		while(true){
			//先输出
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//构建下一秒时间
			endTime = new Date(endTime.getTime() - 1000);
			//等一秒再循环
			Thread.sleep(1000);
			if(end - 10000 > endTime.getTime()){
				break;
			}
		}
	}
} 
