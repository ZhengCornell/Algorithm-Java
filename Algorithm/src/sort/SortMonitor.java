package sort;
//写一个泛型的
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//模拟数组排序
public class SortMonitor {
	public static void sort(Object[] a,Comparator com){
		boolean s = true;
		for(int j = 0; j < a.length; j++){
			for(int i = 0; i< a.length - 1 - j; i++){
				if(com.compare(a[i],a[i + 1]) < 0){
					Object temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] =temp;
					s = false;
				}
			}
			if(s){
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	
	
	
	
	
	
	public static void sort(Object[] a){
		boolean s = true;
		for(int j = 0; j < a.length; j++){
			for(int i = 0; i< a.length - 1 - j; i++){
				if(((Comparable)a[i]).compareTo(a[i+1]) > 0){
					Object temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] =temp;
					s = false;
				}
			}
			if(s){
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	
	public static<T extends Comparable<T>> void sort(T[] a){
		boolean s = true;
		for(int j = 0; j < a.length; j++){
			for(int i = 0; i< a.length - 1 - j; i++){
				if(((Comparable)a[i]).compareTo(a[i+1]) > 0){
					T temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] =temp;
					s = false;
				}
			}
			if(s){
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	
	//容器排序:转成数组、改变容器中对应值、
	public static<T extends Comparable<T>> void sort(List<T> l){
		Object[] a = l.toArray();
		sort(a);
		//循环改变
		for(int i = 0; i < a.length; i++){
			l.set(i,(T)a[i]);
		}
	}
} 
