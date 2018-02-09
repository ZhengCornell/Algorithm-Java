package test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.script.Invocable;
// java js 的交互
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo01 {

	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		//获得脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//定义变量 KV java 和 js 都可以取，存储到引擎上下文
		engine.put("msg","gz ok");
		String str = "var user = {name:'gz',age:18,schools:['Cornell','ZJU']};";//这是js源代码
		str += "print(user.name);";
		
//		执行js脚本
		engine.eval(str);
		engine.eval("msg = 'gz is very diao';");
		System.out.println(engine.get("msg"));
		System.out.println("%%%%%%%%%%%%%%%%%");
		
		//定义js 函数
		engine.eval("function add(a,b){var sum = a + b;return sum;}");
		//执行该函数
		//取得调用接口
		Invocable jsInvoke = (Invocable) engine;
		//执行脚本中定义的方法
		Object obj = jsInvoke.invokeFunction("add",new Object[]{13,20});//(方法，传参数) 通过Object
		System.out.println(obj);
		
		
		
//		//导入其他java包，使用其他包中的java类
//		String jsCode = "import Package(java.util); var list = Arrays.asList([\"北大\",\"清华\"]);";
//		engine.eval(jsCode);
//		
////		engine.get("list");
//		List<String> l = (List<String>)	engine.get("list");
//		
//		for(String temp:l){
//			System.out.println(temp);
//		}
	
	URL url = Demo01.class.getClassLoader().getResource("a.js");
	FileReader fr = new FileReader(url.getPath());
	engine.eval(fr);
	fr.close();
	}
}
