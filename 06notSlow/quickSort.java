import java.util.*;
import java.io.*;
public class quickSort{
    public static int[] ary;
    public static int startDup = 0;
    public 
    public static void main(String[] args){
	ary = new int[10];
	Random rand = new Random();
	for (int x = 0; x < ary.length; x++){
	    int num = rand.nextInt(1000);
	    ary[x] = num;
	}
	System.out.println(Array.toString(ary));
	sort();
	System.out.prinyln(Array.toString(ary));
    }
    public static void sort(){
	return sortH(0, ary.length);
    }
    public static void sortH(int ei, int si){
	Random rand = new Random();
	if (ei > si) {
	    int guess = rand.nextInt(ary.length);
	    int ans = partion(ei, si, guess);
	    sortH(0, 
	} else {
	    int guess1 = rand.nextInt(ei+1);
	    int guess2 = rand.nextInt(ary.length - si);
	    int ans1 = partition(0, ei, guess1);
	    int ans2 = partition(si, ary.length-1, si + guess2);
	    if (ei != 0 && si != ary.length - 1){
		sortH(0, startDup);
		sortH(ans1, si);
		sortH(ei, 
	    
	    





}
