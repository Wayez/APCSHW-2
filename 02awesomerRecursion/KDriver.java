public class KDriver{

    public static void main(String[]arrr){
	KnightsTour t = new KnightsTour(6);
	if(t.solve()){
		System.out.println(t);
	}else{
		System.out.println("Cannot solve");
	}
    }
}
//
