package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
//创建匿名内部类，其对象只能访问final的变量
//该内部接口创建后重写内部方法
//该内部类属于Request对象
public class Demo01 {
	public static void main(String args[]){
		Queue<Request> q = new ArrayDeque<Request>();
		for(int i = 0; i < 10; i++){
			final int num = i + 1;
			q.offer(new Request(){

				@Override
				public void deposit() {
					System.out.println(num+" "+Math.random()*10);
					
				}
				
			}
					
				);
		}
		dealWith(q);
	}
	//处理业务方法
	public static void dealWith(Queue<Request> q){
		Request r = null;
		while((r = q.poll())!=null){
			r.deposit();
		}
	}
}

interface Request{
	void deposit();
}