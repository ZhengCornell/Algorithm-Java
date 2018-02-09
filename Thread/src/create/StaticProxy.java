package create;
//静态代理 设计模式
//真实角色
//代理角色:持有真实角色的引用
//二者实现相同接口
public class StaticProxy {
	public static void main(String args[]){
		//创建真实角色
		You you = new You();
		//创建代理角色 + 真实角色的引用(构造器或者setget方法)
		WeddingCompany company = new WeddingCompany(you);
		//执行任务
		company.marry();
	}
}

//共同接口
interface Marry{
	public abstract void marry();
}
//真实角色
class You implements Marry{

	@Override
	public void marry() {
		System.out.println("你和我结婚了");
		
	}
	
}
//代理角色
class WeddingCompany implements Marry{
	private Marry you;

	public WeddingCompany(Marry you) {
		super();
		this.you = you;
	}
	public WeddingCompany() {
		
	}
	private void before(){
		System.out.println("布置");
	}
	private void after(){
		System.out.println("收拾");
	}
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}