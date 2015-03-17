import java.util.*;
import java.io.*;
public class MyLinkedList<T> implements Iterable<T>{
    private LNode<T> head, current, tail;
    private int size;
    public String name(){
	return "chowdhury.wayez";
    }
    public Iterator<T> iterator(){
	Iterator<Integer> c = new Iterator<Integer>();
	return c;
    }
    public class MyIterator<T> implements Iterator<T>{
	public boolean hasNext(){
	    return true;
	}
	public T next(){
	    return "0";
	}
	public void remove(){
	}
    }
    public String toString(){
	if (head != null){
	    String ans = "[";
	    LNode<T> temp = head;
	    while (temp.getNext() != null){
		ans += " " + temp.getValue() + ",";
		temp = temp.getNext();
	    }
	    ans += " " + temp.getValue() +" ]";
	    return ans;
	}
	return "[ ]";
    }
    public T get(int index){
	int currentIndex = 0;
	LNode<T> temp = head;
	while (currentIndex != index && temp != null){
	    currentIndex++;
	    temp = temp.getNext();
	}
	if (currentIndex == index){
	    return temp.getValue();
	} else {
	    throw new IndexOutOfBoundsException();
	}
    }
    public T set(int index, T value){
	int currentIndex = 0;
	LNode<T> temp = head;
	LNode<T> next = new LNode<T>(value);
	while (currentIndex != index && temp != null){
	    currentIndex++;
	    temp = temp.getNext();
	}
	if (currentIndex == index){
	    T i = temp.getValue();
	    temp.setValue(value);
	    return i;
	} else {
	    throw new IndexOutOfBoundsException();
	}
    }
    public boolean add(T value){
	LNode<T> next = new LNode<T>(value);
	if (head == null){
	    head = next;
	    tail = head;
	    size++;
	    return true;
	}
	tail.setNext(next);
	tail = next;
	current = head;
	size++;
	return true;
    }
    public boolean add(int index, T value){
	int currentIndex = 0;
	LNode<T> temp = head;
	LNode<T> next = new LNode<T>(value);
	if (index == 0){
	    next.setNext(head);
	    head = next;
	} else {
	    while (currentIndex + 1 < index && temp.getNext() != null){
		currentIndex++;
		temp = temp.getNext();
	    }
	    if (currentIndex + 1 != index)
		throw new IndexOutOfBoundsException();
	    if (temp == tail)
		tail = next;
	    next.setNext(temp.getNext());
	    temp.setNext(next);
	    size++;
	}
	return true;
    }
    public T remove(int index){
	int currentIndex = 0;
	LNode<T> temp = head;
	if (index == 0){
	    if (size != 0){ 
		T i = head.getValue();
		head = head.getNext();
		size--;
		return i;
	    } else {
		throw new IndexOutOfBoundsException();
	    }
	} else {
	    while (currentIndex + 1 < index && temp.getNext() != null){
		currentIndex++;
		temp = temp.getNext();
	    }
	    if (currentIndex + 1 != index)
		throw new IndexOutOfBoundsException();
	    if (temp.getNext() == tail)
		tail = temp;
	    T i = temp.getNext().getValue();
	    temp.setNext(temp.getNext().getNext());
	    size--;
	    return i;
	}
    }
    public int size(){
     	return size;
    }
    public int indexOf(T value){
	LNode<T> current = head;
	int currentIndex = 0;
	while (current != tail){		
	    if (current.getValue()==value)
		return currentIndex;
	    currentIndex++;
	    current=current.getNext();
	}
	if (current.getValue()==value)
	    return currentIndex;
	return -1;
    }

    // public static void main(String[] args){
    // 	MyLinkedList<Integer> A = new MyLinkedList<Integer>();
    // 	A.add(1);
    // 	A.add(2);
    // 	A.add(3);
    // 	A.add(5);
    // 	A.add(7);
    // 	System.out.println(A.toString());
    // 	System.out.println(A.size());
    // 	System.out.println(A.get(4));
    // 	System.out.println(A.set(4, 3));
    // 	System.out.println(A.toString());
    // 	System.out.println(A.remove(4));
    // 	System.out.println(A.size());
    // 	System.out.println(A.toString());
    // 	System.out.println(A.add(4, 5));
    // 	System.out.println(A.size());
    // 	System.out.println(A.toString());
    // 	System.out.println(A.indexOf(5));
    // 	MyLinkedList<String> B = new MyLinkedList<String>();
    // 	B.add("AP");
    // 	B.add("BC");
    // 	B.add("CD");
    // 	B.add("EA");
    // 	B.add("GO");
    // 	System.out.println(B.toString());
    // 	System.out.println(B.size());
    // 	System.out.println(B.get(4));
    // 	System.out.println(B.set(4, "CE"));
    // 	System.out.println(B.toString());
    // 	System.out.println(B.remove(4));
    // 	System.out.println(B.size());
    // 	System.out.println(B.toString());
    // 	System.out.println(B.add(4, "ED"));
    // 	System.out.println(B.size());
    // 	System.out.println(B.toString());
    // 	System.out.println(B.indexOf("AP"));
    // 	System.out.println(B.indexOf("AB"));

		
    // }
}
    
