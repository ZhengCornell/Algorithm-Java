package poly.servlet;

public class HttpServlet {
	public void service(){
		System.out.println("HttpServlet.service()");
		doGet();//隐氏参数，this.doGet();//
	}
	
	public void doGet(){
		System.out.println("HttpServlet.doGet()");
	}
	
	
}
