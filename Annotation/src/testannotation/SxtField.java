package testannotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)//加载后反射才有用，这里一定要runtime
public @interface SxtField {//修饰各类属性 id name age
	String columnName();
	String type();
	int length();

}
