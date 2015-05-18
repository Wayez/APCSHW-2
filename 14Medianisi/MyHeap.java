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
        if (heap.get(0) == 1){
            heap.set(0, heap.get(0) - 1);
            return heap.remove(1);
        }
        int root = peek();
        int currentLeafIndex = 1;
        int last = heap.get(0);
        heap.set(1, heap.remove(last));
        int favoriteChildIndex = findFavoriteChild(currentLeafIndex);
        if (isMax){
            while (favoriteChildIndex != -1 && heap.get(currentLeafIndex) < heap.get(favoriteChildIndex)){
                int temp = heap.set(favoriteChildIndex, heap.get(currentLeafIndex));
                heap.set(currentLeafIndex, temp);
                currentLeafIndex = favoriteChildIndex;
                favoriteChildIndex = findFavoriteChild(currentLeafIndex);
            }
        } else {
            while (favoriteChildIndex != -1 && heap.get(currentLeafIndex) > heap.get(favoriteChildIndex)){
                int temp = heap.set(favoriteChildIndex, heap.get(currentLeafIndex));
                heap.set(currentLeafIndex, temp);
                currentLeafIndex = favoriteChildIndex;
                favoriteChildIndex = findFavoriteChild(currentLeafIndex);
            }
        }
        heap.set(0, heap.get(0) - 1);
        return root;
    }
    public int findFavoriteChild(int currentIndex){
        if (2 * currentIndex >= heap.get(0)){
            return -1;
        }
        if (2 * currentIndex + 1 >= heap.get(0)){
            return 2 * currentIndex;
        }
        if (isMax){
            if(heap.get(2 * currentIndex) > heap.get(2 * currentIndex + 1))
                return 2 * currentIndex;
            return 2 * currentIndex + 1;
        }
        else {
            if(heap.get(2 * currentIndex) < heap.get(2 * currentIndex + 1))
                return 2 * currentIndex;
            return 2 * currentIndex + 1;
        }
    }
    public int peek(){
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
        MyHeap alpha = new MyHeap();
        alpha.add(4);
        alpha.remove();
        alpha.add(3);
        alpha.add(7);
        alpha.add(8);
        alpha.add(17);
        alpha.add(9);
        System.out.println(alpha.toString());
        alpha.remove();
        alpha.remove();
        alpha.add(11);
        System.out.println(alpha.toString());
        alpha.add(67);
        alpha.add(14);
        alpha.add(5);
        alpha.add(78);
        alpha.add(55);
        System.out.println(alpha.toString());
        alpha.remove();
        alpha.remove();
        alpha.remove();
        System.out.println(alpha.toString());
        MyHeap beta = new MyHeap(false);
        beta.add(34);
        beta.add(23);
        beta.add(203);
        beta.remove();
        System.out.println(beta.toString());
        beta.add(356);
        System.out.println(beta.toString());
    }
}