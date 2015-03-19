public class Driver{
     public static boolean equals(double a,double b){
				return (a==0 && b==0) || a!=0 && (a-b)/a < 0.000001;
    }

    public static void main(String[]arrr){
				Recursion recursion = new Recursion();
				int score = 0;
				int total = 0;

				System.out.println("\nStarting fact: "+recursion.name()+":");

				
				double[]values = {169.0,1.0,0.00000001,0.0,-100.0};
				String f="sqrt(";


				int[][] facts = {{0,1},{1,1},{5,120},{-1,-1}};
				f="fact(";
				for(int[] pair : facts){
						total++;
						int tester = pair[0];
						int ans = pair[1];
						try{
								int result = recursion.fact(tester);
								if(result == ans){
										System.out.println(f+tester+") passed:"+result+" (+1).");
										score++;
										
								}else{
										System.out.println(f+tester+") failed:"+result);
								}	
						}catch(IllegalArgumentException e){							
								if(tester<0){
										System.out.println(f+tester+") passed: exception (+1).");
										score++;
								}else{
										System.out.println(f+tester+") failed: exception thrown at wrong time");
								}	
						}catch(StackOverflowError t) {
								System.out.println("Caught "+t);
         
						}

				}


				System.out.println("#"+recursion.name()+": "+score+" out of"+total+"\n");
	

    }
   
}
