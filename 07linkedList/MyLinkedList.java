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
	while (currentIndex != index && temp != null){
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
	while (currentIndex != index && temp != null){
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
    public boolean add(int index, int value){
	int currentIndex = 0;
	LNode temp = head;
	LNode next = new LNode(value);
	while (currentIndex + 1 < index && temp.getNext() != null){
	    currentIndex++;
	    temp = temp.getNext();
	}
	if (currentIndex + 1 != index)
	    throw new IndexOutOfBoundsException();
	if (temp == tail)
	    tail = next;
	next.setNext(temp.getNext());
	temp.setNext(next);
	size++;
	return true;
    }
    public int remove(int index){
	int currentIndex = 0;
	LNode temp = head;
	while (currentIndex + 1 < index && temp.getNext() != null){
	    currentIndex++;
	    temp = temp.getNext();
	}
	if (currentIndex + 1 != index)
	    throw new IndexOutOfBoundsException();
	if (temp.getNext() == tail)
	    tail = temp;
	int i = temp.getNext().getValue();
	temp.setNext(temp.getNext().getNext());
	size--;
	return i;
    }
    public int size(){
     	return size;
    }
    public int indexOf(int value){
	LNode current = head;
	int currentIndex = 0;
	while (current != tail){		
	    if (current.getValue()==value)
		return currentIndex;
	    currentIndex++;
	    current=current.getNext();
	}
	if (current.getValue()==value)
	    return currentIndex;
	return -1;
    }

    public static void main(String[] args){
	MyLinkedList A = new MyLinkedList();
	A.add(1);
	A.add(2);
	A.add(3);
	A.add(5);
	A.add(7);
	System.out.println(A.toString());
	System.out.println(A.size());
	System.out.println(A.get(4));
	System.out.println(A.set(4, 3));
	System.out.println(A.toString());
	System.out.println(A.remove(4));
	System.out.println(A.size());
	System.out.println(A.toString());
	System.out.println(A.add(4, 5));
	System.out.println(A.size());
	System.out.println(A.toString());
    }
}
    
