import java.util.*
import java.io.*
public class lakeMaking{
    int[][]lake;
    int initVolume;
    int endVolume;
    int lakeVolume;
    public static void main(String[]args){
	BufferedReader BR = new BufferedReader(new FileReader("makelake.in"));
	
	//file reading stuff
	//initial calculation of stuff
	solve(lake.length(),lake[].length);
	//calculate end volume
	lakevolume=startVolume - endVolume;
    }
    
    public static void dig(int x, int y, int depth){
	int max=0;
	if (lake[x][y]>max){
	    max=lake[x][y];
	}
	
	for (int z: lake.length()){
	    for (int w: lake[].length()){
		if (z >= x && z < x + 3 && w <= y && w > y - 3){
		    if (lake[z][w]>max){
			max=lake[z][w];
		    }
		}
	    }
	}
	for (int z: lake.length()){
	    for (int w: lake[].length()){
		if (z>=x&&z<x+3&&w<=y&&w>y-3){
		    if (lake[z][w]>max-depth){
			lake[z][w]=max-depth;
		    }
		}
	    }
	}

    public static boolean solve(int x, int y){
	dog 