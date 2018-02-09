package Queue;

public class Demo02 {

	public static void main(String[] args) {
		MyStack<String> m = new MyStack<String>(4);
		m.push1("www.baidu.com");
		m.push2("www.google.com");
		m.push2("www.sina.com");
		m.push1("www.bjsxt.com");
		System.out.println(m.peek1());
		//历史纪录,显然后进先出
		String history = null;
		while((history=m.pop1())!=null){
			System.out.println(history);
		}
		

	}

}
