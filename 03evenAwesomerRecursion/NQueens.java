public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private char[][]board;
    
    
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
    public NQueens(int size){
	board=new char[size][size];
	fill();
    }
    public void fill(){
	for (int x=0;x<board.length;x++){
	    for (int y=0;y<board.length;y++){
		board[x][y]='_';
	    }
	}
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

    public boolean solve(){
	return solve(0);
    }
    public boolean solve(int x){
	return NQH(0, x);
    }
    public boolean NQH(int r, int c){
	System.out.println(this);
	wait(1000);
	if (r<0 || r>=board.length || c<0)
	    return false;
	if(!valid(r, c))
	    return false;
	if (c==board[0].length)
	    return true;
	board[r][c]='Q';
	for (int w=0; w<board.length; w++){
	    if (NQH(r+1,w))
		return true;
	}
	board[r][c]='_';
	return false;
    }
    public boolean valid(int r, int c){
        for (int x=0; x<board.length; x++){
	    int x2=0;
	    if (board[r][x]=='Q')
		return false;
	    while (r+x2<board.length&&r-x2>=0&&x+x2<board.length&&x-x2>=0 ){
		if(board[r+x2][x+x2]=='Q')
		    return false;
		if(board[r-x2][x+x2]=='Q')
		    return false;
		if(board[r+x2][x-x2]=='Q')
		    return false;
		if(board[r+x2][x-x2]=='Q')
		    return false;
		x2++;
	    }
	}
	for (int y=0; y<board.length; y++){
	    if (board[y][c]=='Q')
		return false;
	}
	return true;
    }
}
