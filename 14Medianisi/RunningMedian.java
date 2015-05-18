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
        if (heap1.heap.get(0) == 0 && heap2.heap.get(0) == 0)
            throw new IndexOutOfBoundsException();
        if (heap1.heap.get(0) == heap2.heap.get(0))
            return (heap2.peek() + heap1.peek()) / 2.0;
        if (heap1.heap.get(0) > heap2.heap.get(0))
            return heap1.peek();
        return heap2.peek();
    }
    public void add(int x){
        if (heap1.heap.get(0) == 0 && heap2.heap.get(0) == 0)
            heap1.add(x);
        else if (heap1.heap.get(0) == heap2.heap.get(0)){
            if (x < heap1.peek())
                heap1.add(x);
            else
                heap2.add(x);
        }
        else if (heap1.heap.get(0) > heap2.heap.get(0)){
            if (heap2.heap.get(0) == 0){
                if (x > heap1.peek())
                    heap2.add(x);
                else{
                    heap2.add(heap1.remove());
                    heap1.add(x);
                }
            }
            else if (x > heap2.peek())
                heap2.add(x);
            else {
                heap2.add(heap1.remove());
                heap1.add(x);
            }
        }
        else{
            if (heap1.heap.get(0) == 0){
                if (x < heap2.peek())
                    heap1.add(x);
                else{
                    heap1.add(heap2.remove());
                    heap2.add(x);
                }
            }
            else if (x < heap1.peek())
                heap1.add(x);
            else {
                heap1.add(heap2.remove());
                heap2.add(x);
            }
        }
    }
    public String toString(){
        String ans1 = heap1.toString().substring(8 + (heap1.heap.get(0) / 10));
        String ans2 = heap2.toString().substring(8 + (heap2.heap.get(0) / 10));
        return ans1 + "\n" + getMedian() + "\n" + ans2;
        
    }
    public static void main(String[]args){
        RunningMedian speedy = new RunningMedian();
        speedy.add(34);
        speedy.add(23);
        speedy.add(3);
        System.out.println(speedy.toString());
        speedy.add(5);
        System.out.println(speedy.toString());
        speedy.add(203);
        System.out.println(speedy.toString());
        speedy.add(356);
        System.out.println(speedy.getMedian());
        System.out.println(speedy.toString());
        /**speedy.add(15);
        speedy.add(140);
        speedy.add(91);
        speedy.add(0);
        speedy.add(207);
        System.out.println(speedy.getMedian());
        System.out.println(speedy.toString());
        **/
    }
}