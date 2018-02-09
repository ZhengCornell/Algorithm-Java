package leee;
/*枚举，穷举*/
public class Meiju {
	public static void main(String args[]){
	int a,b,c,d,e;
	int res = 555555, ans;
	for(a=1;a<=9;a++){
		for(b=1;b<=9;b++){
			for(c=1;c<=9;c++){
				for(d=1;d<=9;d++){
					for(e=1;e<=9;e++){
						ans=a*10000+b*1000+c*100+d*10+e;
						if(ans*a == res){
							System.out.print(ans);
						}
					}
				}
			}
		}
	}
	}
}
