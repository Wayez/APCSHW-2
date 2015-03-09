import java.util.*;
import java.io.*;
public class quickSelect{
    public static int[] ary;
    public static void main(String[] args){
	ary = new int[10];
	Random rand = new Random();
	for (int x = 0; x < ary.length; x++){
	    int num = rand.nextInt(1000);
	    ary[x] = num;
	}
	System.out.println(Arrays.toString(ary));
	System.out.println(select(9));
    }
    public static int select(int k){
	//if (nums.length==0)
	    //  return nums[0];
	return selectH(0, ary.length-1, k);
    }
    public static int selectH(int si, int ei, int k){
	Random rand = new Random();
	int guess = rand.nextInt(ei-si+1);
	System.out.println(guess + "**");
	int ans = partition( si, ei, guess);
	System.out.println(ans + "*");
	if (ans == k)
	    return ary[k];
	if (ans > k)
	    return selectH(si, ans-1, k);
	return selectH(ans, ei, k);
    }
    public static int partition(int si, int ei, int guess){
	int[] D = new int[ary.length];
	//System.out.println(Arrays.toString(ary));
	for (int x = 0; x < ary.length; x++){
	    if (x < si || x > ei){
		D[x]=ary[x];
	    }
	}
	//System.out.println(Arrays.toString(D));
	int temp = ary[si];
	ary[si] = ary[guess];
	ary[guess] = temp;
	int pivot = ary[si];
	//System.out.println(pivot);
	int start = si;
	int end= ei;
	for (int y = start + 1; y <= end; y++){
	    if (ary[y] < pivot){
		D[si]=ary[y];
		si++;
	    } else {
		D[ei]=ary[y];
		ei--;
	    }
	    // System.out.println(Arrays.toString(D));
	}
	D[si]=pivot;
	for (int z = 0; z < D.length; z++){
	    ary[z]=D[z];
	}
	System.out.println(Arrays.toString(D));
	return si;			       
    }
}
	    
	
	
    
