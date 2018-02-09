package genericity;
//t可以随意定义 T type ？不确定 KV E element
//不能使用基本类型，类似int long 等等
//声明时不能使用静态属性和静态方法（静态的在编译是才用到，太晚了）
public class Student1<T1,T2> {
	private T1 javaScore;
	private T2 oracleScore;
	
	
	public T1 getJavaScore() {
		return javaScore;
	}


	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}


	public T2 getOracleScore() {
		return oracleScore;
	}


	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}


	public static void main(String args[]){
		//使用时指定类型
		Student1<String,Integer> stu = new Student1<String,Integer>();
		//安全 类型检查  省心 类型转换
		stu.setJavaScore("优秀");
		stu.setOracleScore(100);
		 
	}

}
