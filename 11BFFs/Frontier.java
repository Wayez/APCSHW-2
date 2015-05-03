import java.util.*;
import java.io.*;

public class Frontier{
    public MyDeque<Point> front;
    public Frontier(){}
    public void add(Point p){
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
}
