package testannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {
	
	String studentName() default "";//参数名，参数类型 默认值
	int age() default 0;
	int id() default -1;
	
	String[] schools() default {"gz","lk"};

}
