public class LNode{
    private int value;
    private LNode next;
    public LNode(int value){
	setValue(value);
    }
    public void setValue(int value){
	this.value=value;
    }
    public int getValue(){
	return value;
    }
    public void setNext(){
	this.next=next;
    }
    public LNode getNext(){
	return next;
    }
    public String toString(){
	return Integer.toString(value);
    }
}