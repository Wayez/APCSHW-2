import java.util.*;
import java.io.*;

public class Point{
    public int x, y, num;
    public Point next;
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
    
}
	 
    
