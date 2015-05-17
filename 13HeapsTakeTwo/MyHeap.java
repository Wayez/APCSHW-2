import java.util.*;
import java.io.*;

public class MyHeap{
    public ArrayList<Integer> heap;
    public boolean isMax;
    public MyHeap(){
        this(true);
    }
    public MyHeap(boolean isMax){
        this.isMax = isMax;
        heap = new ArrayList<Integer>(10);
        heap.add(0);
    }
    public String toString(){
        String ans = "";
        for (int x : heap){
            ans += x;
        }
        return ans;
    }
    public static void main(String[]args){
        MyHeap alpha = new MyHeap();
        System.out.println(alpha.toString());
    }
}