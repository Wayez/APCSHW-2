import java.util.*;
import java.io.*;
public class quickSort{
    public static void main(String[] args){
	int[] ary = new int[10];
	Random rand = new Random();
	for (int x = 0; x < ary.length; x++){
	    int num = rand.nextInt(1000);
	    ary[x] = num;
	}
	partition(ary, 0, ary.length-1);
    }
    public static void partition(int[] ary, int si, int ei){
	int[] D = new int[ary.length];
	System.out.println(Arrays.toString(ary));
	for (int x = 0; x < ary.length; x++){
	    if (x < si || x > ei){
		D[x]=ary[x];
	    }
	}
	System.out.println(Arrays.toString(D));
	//Random r = new Random();
	//int partition = si + r.nextInt(ei-si+1);
	int pivot = ary[si];
	System.out.println(pivot);
	int y = si;
	while (si + 1!= ei){
	    if (ary[y]<pivot){
		D[si + 1]=ary[y];
		si++;
	    } else {
		D[ei]=ary[y];
		ei--;
	    }
	    y++;
	    System.out.println(Arrays.toString(D));
	}
	D[si]=pivot;
    }
}
	    
	
	
    
