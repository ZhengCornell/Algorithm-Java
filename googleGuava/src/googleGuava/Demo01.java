package googleGuava;

import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

public class Demo01 {

	public static void main(String[] args) {
		Table<String,String,Integer> t = HashBasedTable.create();
		t.put("a","javase",80);
		t.put("b","javase",90);
		t.put("a","oracle",100);
		t.put("c","oracle",95);
		Set<Cell<String,String,Integer>> c = t.cellSet();
		for(Cell<String,String,Integer> temp:c){
			System.out.println(temp.getRowKey()+"---"+temp.getColumnKey()+"---"+temp.getValue());
		}
	}

}
