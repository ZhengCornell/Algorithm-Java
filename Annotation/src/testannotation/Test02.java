package testannotation;
@MyAnnotation01
public class Test02 {
	
	@MyAnnotation01(age=19,studentName="k",schools={"北大","清华"})//定义注解
	public void test(){
		
	}
	
	@MyAnnotation02("aaaa")
	public void test02(){
		
	}
}
