import java.util.*;
import java.io.*;

public class RunningMedian{
    public MyHeap heap1;
    public MyHeap heap2;
    public RunningMedian(){
        heap1 = new MyHeap();
        heap2 = new MyHeap(false);
    }
    public double getMedian(){
        if (heap1.get(0) == 0 && heap2.get(0) == 0)
            throw new IndexOutOfBoundsException;
        if (heap1.get(0) == heap2.get(0))
            return (heap2.peek() + heap1.peek()) / 2.0;
        if (heap1.get(0) > heap2.get(0))
            return heap1.peek();
        return heap2.peek();
    }
    public void add(int x){
        if (heap1.get(0) == 0 && heap2.get(0) == 0)
            heap1.add(x);
        else if (heap1.get(0) == heap2.get(0)){
            if (x < heap1.peek())
                heap1.add(x);
            else
                heap2.add(x);
        }
        else if (heap1.get(0) > heap2.get(0)){
            if (x > heap2.peek())
                heap2.add(x);
            else {
                heap2.add(heap1.remove());
                heap1.add(x);
            }
        }
        else{
            if (x < heap1.peek())
                heap1.add(x);
            else {
                heap1.add(heap2.remove());
                heap2.add(x);
            }
        }
    }
    
}