package javaprogramint;

public class swap_num 
{
	public static void main(String[] args) {
		int a=10;
		int b=20;
		
		System.out.println("before swapping value of a is" +a);
		System.out.println("before swapping value of b is" +b);
		
	/*	//logic 1 using third variable..
		int c;
		c=a;
		a=b;
		b=c;
		System.out.println("after swapping value of a is" +a);
		System.out.println("after swapping value of b is" +b);
		*/
		
	/*	  //logic 2 using "+"and "-" operator
		a=a+b;  //10+20=30  a=30
		b=a-b;  //30-20=10  b=10
		a=a-b;  //30-10     a=20
		System.out.println("after swapping value of a is" +a);
		System.out.println("after swapping value of b is" +b);
		*/
		
		//logic 3 using "*" and "/" operator
		a=a*b;  //10*20=200
		b=a/b;  //200/20=10
		a=a/b;  //200/10=20
		System.out.println("after swapping value of a is" +a);
		System.out.println("after swapping value of b is" +b);
		
		
		
	}

}
