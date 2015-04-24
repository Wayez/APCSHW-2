public class MyQueue<T> extends MyLinkedList<T>{
    private MyLinkedList<T> Q;
    public MyQueue(){
	Q = new MyLinkedList<T>();
    }
    public String name(){
	return "chowdhury.wayez";
    }
    public boolean enqueue(T value){
	Q.add(value);
	return true;
    }
    public T dequeue(){
	if (Q.size()== 0){
	    throw new NoSuchElementException();
	}
	return Q.remove(0);
    }
    public boolean empty(){
	return Q.size()==0;
    }
}