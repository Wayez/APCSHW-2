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
        String ans = "Size = " + heap.get(0) + "\n";
        int counter = 0;
        int target = 1;
        boolean start = false;
        for (int x : heap){
            if (start){
                ans += x + " ";
                counter++;  
                if (counter == target){
                    counter = 0;
                    target = target * 2;
                    ans += "\n";
                }
            }
            start = true;
        }
        return ans;
    }
    public int remove(){
        int root = peak();
        int currentLeafIndex = heap.get(0);
        int currentLeaf = heap.remove(currentLeafIndex);
        int parentIndex = currentLeafIndex / 2;
        while (heap.get(parentIndex) != root){
            currentLeaf = heap.set(parentIndex, currentLeaf);
            currentLeafIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        return heap.set(1, currentLeaf);
    }
    public int peak(){
        if (heap.get(0) == 0)
            throw new IndexOutOfBoundsException();
        return heap.get(1);
    }
    public void add(int x){
        heap.add(x);
        heap.set(0, heap.get(0) + 1);
        int currentIndex = heap.get(0);
        int parentIndex = heap.get(0) / 2;
        if (isMax){
            while (x > heap.get(parentIndex) && parentIndex > 0){
                heap.set(currentIndex, heap.set(parentIndex, x));
                currentIndex = parentIndex;
                parentIndex = parentIndex / 2;
            }
        }
        else {
           while (x < heap.get(parentIndex) && parentIndex > 0){
                heap.set(currentIndex, heap.set(parentIndex, x));
                currentIndex = parentIndex;
                parentIndex = parentIndex / 2;
            } 
        }
    }
    public static void main(String[]args){
        MyHeap alpha = new MyHeap(false);
        alpha.add(4);
        alpha.add(3);
        alpha.add(7);
        alpha.add(8);
        alpha.add(35);
        alpha.add(17);
        alpha.add(9);
        alpha.add(11);
        alpha.add(67);
        alpha.add(14);
        alpha.add(5);
        alpha.add(78);
        alpha.add(55);
        System.out.println(alpha.toString());
        //alpha.remove();
    }
}