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
	System.out.println(a.fib(-3));
    }
    public String name(){
	return "Chowdhury, Wayez";
    }
    public void nNeg(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
    }
    public int fact(int n){
	nNeg(n);
	if (n>=2)
	    return n*fact(n-1);
	return n;
    }
    public int fib(int n){
	nNeg(n);
	if (n>1)
	    return fib(n-1)+fib(n-2);
	else
	    return n;
    }
		
    public double sqrt(double n){
	return n;
    }
}
