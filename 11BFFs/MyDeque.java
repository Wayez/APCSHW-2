import java.util.*;
public class MyDeque<T>{
    public Object[] stuff = new Object[10];
    public int head = 0;
    public int tail = 0;
    public int size = 0;
    public boolean headMinus(){
	if ((head == 0 && tail == stuff.length - 1) || tail == head - 1)
	    return false;
	if (stuff[head] == null)
	    return true;
	if (head == 0)
	    head = stuff.length - 1;
	else 
	    head--;
	return true;
    }
    public boolean tailPlus(){
	if (stuff[head] == null)
	    return true;
	if ((head == 0 && tail == stuff.length - 1) || tail == head - 1)
	    return false;
	if (tail == stuff.length - 1)
	    tail = 0;
	else 
	    tail++;
	return true;
    }
    public T headPlus(){
	T temp = getFirst();
	stuff[head] = null;
	if (head != tail){
	    if (head == stuff.length - 1)
		head = 0;
	    else
		head++;
	}
	return temp;
    }
    public T tailMinus(){
	T temp = getLast();
	stuff[tail] = null;
	if (head != tail){
	    if (tail == 0)
		tail = stuff.length - 1;
	    else
		tail--;
	}
	return temp;
    }
	
    public void addFirst(T value){
	if (!headMinus()){
	    resize();
	    head = stuff.length - 1;
	}
	stuff[head] = (T)value;
	size++;
    }
    public void addLast(T value){
	if (!tailPlus()){
	    resize();
	    tail++;
	}
	stuff[tail] = (T)value;
	size++;
    }						
    public T removeFirst(){
	if (stuff[head] != null){
	    size--;
	    return headPlus();
	}
	throw new NoSuchElementException();
    }
    public T removeLast(){
	if (stuff[tail] != null){
	    size--;
	    return tailMinus();
	}
	throw new NoSuchElementException();
    }
    public T getFirst(){
	if (stuff[head] != null)
	    return (T)stuff[head];
	throw new NoSuchElementException();
    }
    public T getLast(){
	if (stuff[tail] != null)
	    return (T)stuff[tail];
	throw new NoSuchElementException();
    }
    public int getSize(){
	return size;
    }
    public void resize(){
	Object[] stuff2 = new Object[stuff.length*2];
	if (head < tail){
	    for (int x = 0; x < stuff.length; x++){
		stuff2[x] = stuff[x];
	    }
	} else {
	    int w = 0;
	    for (int y = head; y < stuff.length; y++){
		stuff2[w] = stuff[y];
		w++;
	    }
	    for (int z = 0; z <= tail; z++){
		stuff2[w] = stuff[z];
		w++;
	    }
	}
	head = 0;
	tail = stuff.length - 1;
	stuff = stuff2;
    }
    public String toString(){
	String ans = "[";
	if (stuff[head] != null){
	    if (head <= tail){
		for (int x = head; x <= tail; x++){
		    ans += " " + stuff[x] + ",";
		}
	    } else {
		for (int z = head; z < stuff.length; z++){
		    ans += " " + stuff[z] + ",";
		   
		}
		for (int w = 0; w <= tail; w++){
		    ans += " " + stuff[w] + ",";
		}
	    }
	} else
	    return "[ ]";
	ans = ans.substring(0, ans.length() - 1) + " ]";
	return ans;
    }
    public static void main(String[] args){
	MyDeque<Integer> q = new MyDeque<Integer>();
	System.out.println(q);
	q.addFirst(0);
	q.addLast(1);
	q.addFirst(2);
	System.out.println(q);
	q.addLast(3);
	q.addFirst(4);
	q.addLast(5);
       
	System.out.println(q);
	q.addFirst(6);
	System.out.println(q.getFirst());
	q.addLast(7);
	q.addFirst(8);
	System.out.println(q.getFirst());
	q.addLast(9);
	System.out.println(q);
	q.addFirst(10);
	System.out.println(q);
	q.addLast(11);
	System.out.println(q);
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q.removeLast());
	System.out.println(q.removeFirst());
	System.out.println(q);
    }
}
    
