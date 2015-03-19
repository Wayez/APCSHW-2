public class KDriver{

      public static boolean equals(double a,double b){
	return (a==0 && b==0) || a<1.0E-160 && b<1.0E-160 || a!=0 && (a-b)/a < 0.000001;
    }

    public static void main(String[]arrr){
        KnightsTour t = new KnightsTour(5);
	t.solve(3,3);
	System.out.println(t);
    }
}
//
