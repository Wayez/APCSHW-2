import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private int[][]board;
    
    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String name(){
	return "chowdhury.wayez";
    }
    
    public String toString(){
	String ans = "\n";
	for (int x=0 ; x < board.length; x++){
	    for (int y=0 ; y< board[0].length;y++){
		ans += board[x][y] + "\t";
	    }
	    ans += "\n";
	}
	return hide + clear  + go(0,0) + ans + "\n" + show;
    }
    
    public KnightsTour(int size){
	board=new int[size][size];
    }
    
    
    public boolean solve(){
	return solve(0,0,1);
    }
    
    public boolean solve(int startx, int starty){
	return solve(startx, starty, 1);
    }
    
    
		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	if (x >= 0 && x < board.length && y >= 0 && y < board[0].length)
	    return false;
	if (board[x][y]>0)
	    return false;
	if (currentMoveNumber==board.length*board[0].length)
	    return true;
	if (solve( x + 1, y + 2,currentMoveNumber + 1) ||  solve( x - 1, y + 2,currentMoveNumber + 1) ||  solve( x + 1, y - 2,currentMoveNumber + 1)||  solve( x - 1, y - 2,currentMoveNumber + 1) ||  solve( x + 2, y + 1,currentMoveNumber + 1) || solve( x + 2, y- 1,currentMoveNumber + 1) ||  solve( x - 2, y + 1,currentMoveNumber + 1) || solve( x - 2, y - 1,currentMoveNumber + 1)){
	    board[x][y]=currentMoveNumber;
	    return true;
	}
	
	return false;
    }
}
