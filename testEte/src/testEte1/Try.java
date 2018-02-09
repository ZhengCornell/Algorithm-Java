package testEte1;

public class Try {
	public static void main(String args[]){
	try{
		Thread.sleep(3000);
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		System.out.println("1");
	}
	}

}
