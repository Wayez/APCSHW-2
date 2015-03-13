public class MyLinkedList{
    private LNode head, current, tail;
    private int size;
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
    public int get(int index){
	int currentIndex = 0;
	LNode temp = head;
	while (currentIndex != index){
	    currentIndex++;
	    temp = temp.getNext();
	}
	if (currentIndex == index){
	    return temp.getValue();
	} else {
	    throw new IndexOutOfBoundsException();
	}
    }
    public int set(int index, int value){
	int currentIndex = 0;
	LNode temp = head;
	LNode next = new LNode(value);
	while (currentIndex != index){
	    currentIndex++;
	    temp = temp.getNext();
	}
	if (currentIndex == index){
	    int i = temp.getValue();
	    temp.setValue(value);
	    return i;
	} else {
	    throw new IndexOutOfBoundsException();
	}
    }
    public boolean add(int value){
	LNode next = new LNode(value);
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
    // public boolean add(int index, int value){

    // }
    public void remove(int index){

    }
    public int size(){
     	return size;
    }
    //public int indexOf(int value){
	
    //}

    public static void main(String[] args){
	MyLinkedList A = new MyLinkedList();
	A.add(1);
	A.add(2);
	A.add(3);
	A.add(5);
	A.add(7);
	System.out.println(A.toString());
	System.out.println(A.size());
	System.out.println(A.get(3));
	System.out.println(A.set(3, 3));
	System.out.println(A.toString());
    }
}
    
