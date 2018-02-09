public class Post {
    String title; // 成员变量
    String content; // 成员变量
    
    // 成员方法
    void print() {
        System.out.println(title);
        System.out.println(content);
    }
}



public class HelloWorld {  
    
    public static void main(String[] args) {  
        Post post = new Post(); // 创建博客对象      
        post.title = "天码营的博客"; // 访问对象属性
        post.content = "这是我的第一篇博客";  // 访问对象属性
        post.print(); // 调用对象方法
        
    }
}
