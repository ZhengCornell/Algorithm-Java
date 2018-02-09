package ref.test;
@SuppressWarnings("all")

public class TestUser {

	public static void main(String[] args) {
		String path = "ref.been.User";
		String path2 = "ref.been.Niubi";
		try {
			Class k = Class.forName(path2);
			Class c = Class.forName(path);//代表这个类或接口的所有信息（并非这个类的某一个对象）
			System.out.println(c.hashCode());
			System.out.println(k);
			System.out.println(c);
			Class c2 = String.class;
			Class c3 = Integer.class;
			Class c4 = long.class;
			Class c5 = path.getClass();
			Class c6 = path2.getClass();
			System.out.println(c2);
			System.out.println(c3);
			System.out.println(c4);
			System.out.println(c5);
			System.out.println(c6);
			System.out.println(k==c);
			int[] a1 = new int[10];
			int[] a2 = new int[30];
			int[][] a3 = new int[30][5]; 
			System.out.println(a1.getClass().hashCode());
			System.out.println(a2.getClass().hashCode());
			System.out.println(a3.getClass().hashCode());
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
