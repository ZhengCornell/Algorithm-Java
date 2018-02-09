package threadstatus;
//倒计时
public class Sleep {

	public static void main(String[] args) throws InterruptedException {
		int num = 10;
		boolean flag = true;
		while(flag){
			System.out.println(num--);
			Thread.sleep(1000);
			if(num <=0){
				flag = false;
			}
		}
	}

}
