<<<<<<< HEAD
public class MyQueue<T>{
    public MyLinkedList<T> Q;
    public MyQueue(){
	Q = new MyLinkedList<T>();
    }
=======
public class MyQueue<T> extends MyLinkedList<T>{
    private MyLinkedList<T> Q;
    public MyQueue(){
	Q = new MyLinkedList<T>();
    }
    public String name(){
	return "chowdhury.wayez";
    }
>>>>>>> 0fcdc231c0de79b5ec964ce15e8d7e24edba6f8f
    public boolean enqueue(T value){
	Q.add(value);
	return true;
    }
    public T dequeue(){
<<<<<<< HEAD
	if (Q.head != null)
	    return Q.remove(0);
	throw new NoSuchElementException();
    }
}
=======
	if (Q.size()== 0){
	    throw new NoSuchElementException();
	}
	return Q.remove(0);
    }
    public boolean empty(){
	return Q.size()==0;
    }
}
>>>>>>> 0fcdc231c0de79b5ec964ce15e8d7e24edba6f8f
