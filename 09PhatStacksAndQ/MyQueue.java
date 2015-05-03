public class MyQueue<T>{
    public MyLinkedList<T> Q;
    public MyQueue(){
	Q = new MyLinkedList<T>();
    }
    public boolean enqueue(T value){
	Q.add(value);
	return true;
    }
    public T dequeue(){
	if (Q.head != null)
	    return Q.remove(0);
	throw new NoSuchElementException();
    }
}
