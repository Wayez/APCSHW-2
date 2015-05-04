import java.util.*;
import java.io.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private Point place;
    private Frontier front;
    private int[] path;
    //Terminal keycodes to clear the terminal, or hide/show the cursor

    /** Same constructor as before...*/
    public Maze(String filename){  
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    
	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	
	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
    }

    public String toString(){
	return toString(false);
    }
   
    /**private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
	}**/
    
    
    /** private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
	}**/

    public void clearTerminal(){
	System.out.println(clear);
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    public String toString(boolean animate){
	if (animate){
	    String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	    for(int i = 0; i < maxx * maxy; i++){
		if(i % maxx == 0 && i != 0){
		    ans += "\n";
		}
		char c =  maze[i % maxx][i / maxx];
		if(c == '#'){
		    ans += c;//color(38,47)+c;
		}else{
		    ans += c;//color(32,40)+c;
		}
		ans += "\n\n\nFrontier = " + front.toString();
	    }
	    return hide + go(0,0) + ans + "\n" + show;// + color(37,40);
	}
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += c;//color(38,47)+c;
	    }else{
		ans += c;//color(32,40)+c;
	    }
	}
	return ans;
	
    }



    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){  
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty] = ' ';
	    return solve(animate, 1);
	}
    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty] = ' ';
	    return solve(animate, 0);
	}
    }
    
<<<<<<< HEAD
    public boolean solve(boolean animate, int mode){
        front = new Frontier();
	for (int x = 0; x < maze.length; x++){
	    for (int y = 0; y <maze[0].length; y++){
		if (maze[x][y]=='S'){
		    startx = x;
		    starty = y;
		}
	    }
	}
	Point p = new Point(startx, starty, 0);
	front.add(p);
	while (front.getSize()>0){
	    if (animate){
		System.out.println(toString(true));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Frontier = " + front.toString());
		wait(10);
	    }
	    Point temp= new Point();
	    if (mode == 0)
		temp = front.removeLast();
	    if (mode == 1)
		temp = front.removeFirst();
	    maze[temp.getX()][temp.getY()] = 'x';
	    if (temp.solved()){
		System.out.println(toString(true));
		return true;
	    }
	    front.add(temp.getLeft());
	    front.add(temp.getRight());
	    front.add(temp.getUp());
	    front.add(temp.getDown());
	}
	return false;
	    
=======
    public boolean solve(int x,int y){
       
>>>>>>> 0fcdc231c0de79b5ec964ce15e8d7e24edba6f8f
    }

     public boolean solveBFS(){
	return solveBFS(false);
     }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    
    /**return an array [x1,y1,x2,y2,x3,y3...]
      *that contains the coordinates of the solution from start to end.
      *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
      *Postcondition:  the correct solution is in the returned array
       */
    // public int[] solutionCoordinates(){ }    
    public class Point{
	public int x, y, num;
	public Point next;
	public Point(){
	    this(0, 0, 0);
	}
	public Point(int x, int y, int num){
	    this.x=x;
	    this.y=y;
	    this.num=num;
	}
	public int getX(){
	    return x;
	}
	public int getY(){
	    return y;
	}
	public int getNum(){
	    return num;
	}
	public char getValue(){
	    return maze[x][y];
	}
	public boolean valid(int xcor, int ycor){
	    return maze[xcor][ycor]==' ';
	}
	public boolean solved(){
	    return this.getLeft().getValue() == 'E' || this.getRight().getValue() == 'E' || this.getUp().getValue() == 'E' || this.getDown().getValue() == 'E';
	}
	public boolean validLeft(){
	    Point test = this.getLeft();
	    return valid(test.getX(), test.getY());
	}
	public boolean validRight(){
	    Point test = this.getRight();
	    return valid(test.getX(), test.getY());
	}
	public boolean validUp(){
	    Point test = this.getUp();
	    return valid(test.getX(), test.getY());
	}
	public boolean validDown(){
	    Point test = this.getDown();
	    return valid(test.getX(), test.getY());
	}
	public Point getLeft(){
	    Point left = new Point(x - 1, y, num + 1);
	    return left;
	}
	public Point getRight(){
	    Point right = new Point(x + 1, y, num + 1);
	    return right;
	}
	public Point getUp(){
	    Point up = new Point(x, y + 1, num + 1);
	    return up;
	}
	public Point getDown(){
	    Point down = new Point(x, y - 1, num + 1);
	    return down;
	}
	public String toString(){
	    return "( " + x + ", " + y + ")";
	}
    }
    
    public class Frontier{
	public MyDeque<Point> front = new MyDeque<Point>();
	public Frontier(){}
	public void add(Point p){
	    if (maze[p.getX()][p.getY()]==' ')
		front.addLast(p);
	}
	public Point removeLast(){
	    return front.removeLast();
	}
	public Point removeFirst(){
	    return front.removeFirst();
	}
	public int getSize(){
	    return front.getSize();
	}
	public String toString(){
	    return front.toString();
	}
    }
    
    

	

}
