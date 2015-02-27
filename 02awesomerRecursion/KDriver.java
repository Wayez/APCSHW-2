public class KDriver{

    public static void main(String[]arrr){
	KnightsTour t = new KnightsTour(8);
	if(t.solve()){
		System.out.println(t);
	}else{
		System.out.println("Cannot solve");
	}
    }
}
//
