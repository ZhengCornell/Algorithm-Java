package poly.servlet;

public class MyServlet extends HttpServlet{
	//重写doGet，不重写service//
	public void doGet(){
		System.out.println("MyServlet.doGet()");
	}
}
