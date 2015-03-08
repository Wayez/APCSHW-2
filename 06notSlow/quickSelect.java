import java.util.*;
import java.io.*;
public class quickSelect{
    public static void main(String[] args){
	int[] ary = new int[10];
	Random rand = new Random();
	for (int x = 0; x < ary.length; x++){
	    int num = rand.nextInt(1000);
	    ary[x] = num;
	}
	System.out.println(select(ary, 0));
    }
    public static int select(int[] nums, int k){
	if (nums.length==0)
	    return nums[0];
	Random rand = new Random();
	int guess = rand.nextInt(ei-si+1);
	int ans = partition(nums, si, ei, guess);
	if (ans == k)
	    return nums[guess];
	if (ans > k)
	    return select(nums, si, ans, k);
	return select(nums, ans, ei, k);
    }
    public static void partition(int[] ary, int si, int ei, int guess){
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
	System.out.println(pivot);
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
	return si;
	//System.out.println(Arrays.toString(D));
				       
    }
}
	    
	
	
    
