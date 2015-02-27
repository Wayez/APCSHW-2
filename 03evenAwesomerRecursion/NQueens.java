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
	//System.out.println(this);
	//wait(10);
	if (r<0 || r>=board.length || c<0)
	    return false;
	if (c==board[0].length)
	    return true;
	if (valid(r,c)){
	    board[r][c]='Q';
	    for (int x=0; x<board.length; x++){
		if (NQH(x,c+1))
		    return true;
	    }	
	    board[r][c]='_';
	    return false;	    
	}
	return false;
    }
    public boolean valid(int r, int c){
        for (int x=0; x<board.length; x++){
	    if (board[r][x]=='Q')
		return false;
	}
	for (int y=0; y<board.length; y++){
	    if (board[y][c]=='Q')
		return false;
	}
	for (int x2=0; r+x2<board.length&&c+x2<board.length; x2++){
	    if (board[r+x2][c+x2]=='Q')
		return false;
	}
	for (int x3=0;  r+x3<board.length&&c-x3>=0; x3++){
	    if (board[r+x3][c-x3]=='Q')
		return false;
	}
	for (int x4=0; r-x4>=0&&c+x4<board.length; x4++){
	    if (board[r-x4][c+x4]=='Q')
		return false;
	}
	for (int x5=0; r-x5>=0&&c-x5>=0; x5++){
	    if (board[r-x5][c-x5]=='Q')
		return false;
	}
	int x2=0;
	while (r+x2<board.length&&r-x2>=0&&c+x2<board.length&&c-x2>=0 ){
	    if(board[r+x2][c+x2]=='Q')
		return false;
	    if(board[r-x2][c+x2]=='Q')
		return false;
	    if(board[r+x2][c-x2]=='Q')
		return false;
	    if(board[r+x2][c-x2]=='Q')
		return false;
	    x2++;
	}
	return true;
    }
}
