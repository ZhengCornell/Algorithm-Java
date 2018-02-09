package genericity;
//全局常亮，公共抽象方法
//泛型此时只能使用在方法中，
public interface Comparator<T> {
	int A = 2;
	void compare(T t);
	
}
