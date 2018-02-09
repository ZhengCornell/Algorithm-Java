public class TestSimple{
     public void print() {  	
          Simple item = new Simple(3, "blue");     	
          System.out.println(item);             
     }    
     public static void main(String args[]){
    	 TestSimple ts = new TestSimple();
    	 ts.print();
     }
}