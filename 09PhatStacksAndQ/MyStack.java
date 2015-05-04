<<<<<<< HEAD
public class MyStack<T>{    
    public MyLinkedList<T> S;
    public MyStack(){
	S = new MyLinkedList<T>();
    }
    public T push(T stuff){
	S.add(0, stuff);
	return stuff;
    }
    public T pop(){
	if (S.size() != 0)
	    return S.remove(0);
	throw new EmptyStackException();
    }
    public T peek(){
	if (S.size() != 0)
	    return S.get(0);
	throw new EmptyStackException();
    }

}
=======
import java.util.*;
public class MyStack<T>{
    private MyLinkedList<T> ll;
    public String name(){
	return "chowdhury.wayez";
    }
    public MyStack(){
	ll = new MyLinkedList<T>();
    }
    public T push(T item){
	ll.add(0,item);
	return item;
    }
    public T pop(){
	if (!empty()){
	    //peek();
	    return ll.remove(0);
	}
	throw new EmptyStackException();
    }
    public T peek(){
	if (!empty()){
	    return ll.get(0);
	}
	throw new EmptyStackException();
    }
    public boolean empty(){
	return ll.size()==0;
    }
}
>>>>>>> 0fcdc231c0de79b5ec964ce15e8d7e24edba6f8f
