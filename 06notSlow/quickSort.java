import java.util.*;
import java.io.*;
public class quickSort{
    public static void main(String[] args){
    
    }
    public void partition(int[] ary, int si, int ei){
	int[] D = new int[ary.length];
	for (int x = 0; int < ary.length; x++){
	    if (x < si || x > ei){
		D[x]=ary[x];
	    }
	}
	//Random r = new Random();
	//int partition = si + r.nextInt(ei-si+1);
	int pivot = ary[si];
	int y = si;
	while (si != ei){
	    if (ary[y]<pivot){
		D[si]=ary[y];
		si++;
	    } else {
		D[ei]=ary[y];
		ei--;
	    }
	    y++;
	}
	D[si]=pivot;
    }
}
	    
	
	
    
