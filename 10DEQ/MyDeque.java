public class MyDeque<T>{
    public Object[] stuff = new Object[1000];
    public int head = 0;
    public int tail = 1;
    public void headMinus(){
	if (head == 0){
	    copyArray();
	    head = stuff.length - 1;
	}
	
    public void addFirst(T value){
	headMinus();
	stuff[head] = value;
    }
    public void addLast(T value){
    }						
    public T removeFirst(){
    }
    public T removeLast(){
    }
    public T getFirst(){
    }
    public T getLast(){
    }
}
    