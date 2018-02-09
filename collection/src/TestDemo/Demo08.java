package TestDemo;

import java.util.Set;

//双键的Map就是Table rowKey + columnKey + value
//所有行数据cellSet
//所有学生rowKeySet
//所有课程columnKeySet
//所有成绩 values();
//学生对应课程rowMap ＋ get 学生 或 row学生
//课程对应学生columnMap get 课程 或 column 课程
public class Demo08 {
	public static void main(String args[]){
		Table<String,String,Integer> t = HashBasedTable.create();
		t.put("a","javase",80);
		t.put("b","javase",90);
		t.put("a","oracle",100);
		t.put("c","oracle",95);
//		t.put("a","javase",80);
//		t.put("b","javase",90);
		Set<Cell<String,String,Integer>> c = t.cellSet();
		for(Cell<String,String,Integer> temp:c){
			System.out.println(temp.getRowKey());
		}
	}
}
