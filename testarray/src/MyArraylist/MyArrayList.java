package MyArraylist;
//模拟实现JDK提供的ArrayList 类//
import java.util.ArrayList;
public class MyArrayList{ 
	/*The value is used for character storage.*/
	private Object value[];
	/*The count is the number of characters used.*/
	private int size;
	
	public MyArrayList(){
	//value = new Object[16];//value已经是对象，不必再声明了//	
		this(16);
	}
	public MyArrayList(int size){
		
	value = new Object[size];	
	}
	public int indexOf(Object s){
		if(s==null){
			return -1;
		}else{
			for(int i =  value.length - 1; i >= 0; i--){
				if(s==value[i]){
					return i;
				}
			}
			return -1;
		}
	}
	
	public void add(Object k){
		value[size] = k;
		size++;
		if(size >= value.length){
			int jia = value.length*2;
			Object[] n = new Object[jia];
			/*System.arraycopy()*/
			for(int i = 0; i < value.length; i++){
				n[i] = value[i];
			}
			value = n;
		}
	}
	public Object get(int index){
		if(index<0 || index>size-1){//可以单独封装该方法，留个口子传形参//
			try {
				throw new Exception();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return value[index];
	}
	public Object set(int a, Object b){
	        Object oldValue = value[a];
	        value[a] = b;
	        return oldValue;
	    
	}
	
	public static void main(String args[]){
	MyArrayList m = new MyArrayList();
	m.add("nmh");
	m.add(new Human("gq"));
	m.add("bbbbb");
	/*m.add(new Human("gq"));
	Human h = (Human) m.get(1);*/
	Human h = (Human) m.get(1);/*不能是0，2 因为无法强制转换*/
	System.out.println(h.getName());
	}
	

}