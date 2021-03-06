public class Recursion implements hw1{
    public static void main(String[]args){
	Recursion a=new Recursion();
	System.out.println(a.name());
	System.out.println(a.fact(10));
	System.out.println(a.fact(0));
	System.out.println(a.fact(3));
	System.out.println(a.fib(10));
	System.out.println(a.fib(0));
	System.out.println(a.fib(3));
	System.out.println(a.fib(1));
	System.out.println(a.fib(5));
	System.out.println(a.sqrt(10));
	System.out.println(a.sqrt(0));
	System.out.println(a.sqrt(3));
	System.out.println(a.sqrt(1));
	System.out.println(a.sqrt(25));
	System.out.println(a.sqrt(100000000));
	System.out.println(a.sqrt(.000000001));
		
    }
    public String name(){
	return "chowdhury.wayez";
    }
    public void nNeg(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
    }
    public int fact(int n){
	nNeg(n*1.0);
	if (n>=2)
	    return n*fact(n-1);
	return 1;
    }
    public int fib(int n){
	nNeg(n*1.0);
	if (n>1)
	    return fib(n-1)+fib(n-2);
	return n;
    }
		
    public double sqrt(double n){
	nNeg(n);
	return sqrtH(n, n / 2);
    }
    public double sqrtH(double n, double guess){
	if (guess*guess>n-0.0000000001 && guess*guess<n+0.0000000001)
	    return guess;
	return sqrtH(n, (n / guess + guess) / 2);

    }
}
