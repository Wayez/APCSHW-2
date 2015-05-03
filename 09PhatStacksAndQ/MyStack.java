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
