public class MyLinkedList{
    private LNode head, current;
    public String toString(){
	if (head != null){
	    String ans = "[";
	    LNode temp = head;
	    while (temp.getNext() != null){
		ans += " " + temp.getValue() + ",";
		temp = temp.getNext();
	    }
	    ans += " " + temp.getValue() +" ]";
	    return ans;
	}
	return "[ ]";
    }
    // public int get(int index){
    
    // }
    // public int set(int index, int value){
	
    // }
    public boolean add(int value){
	LNode next = new LNode(value);
	if (head == null){
	    head = next;
	    return true;
	}
	current = head;
	while (current.getNext() != null){
	    current = current.getNext();
	}
	current.setNext(next);
	return true;
    }
    // public boolean add(int index, int value){

    // }
    public void remove(int index){

    }
    // public int size(){
    // 	current = head;
    // 	int length;
    // 	while(current.getNext()!=null){
    // 	    length++;
    // 	}
    // 	return length;
    // }
    // public int indexOf(int value){

    // }

    public static void main(String[] args){
	MyLinkedList A = new MyLinkedList();
	A.add(1);
	A.add(2);
	A.add(3);
	A.add(5);
	A.add(7);
	System.out.println(A.toString());
    }
}
    
