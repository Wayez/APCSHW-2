public class LNode<T>{
    private T value;
    private LNode<T> next;
    public LNode(T value){
	setValue(value);
    }
    public void setValue(T value){
	this.value=value;
    }
    public T getValue(){
	return value;
    }
    public void setNext(LNode<T> next){
	this.next=next;
    }
    public LNode<T> getNext(){
	return next;
    }
    public String toString(){
	return "" + value;
    }
}
