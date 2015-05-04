import java.util.*;
import java.io.*;

public class TreeNode<E> {
    
    public TreeNode p = null;
    public TreeNode c1 = null;
    public TreeNode c2 = null;
    public E value;

    public TreeNode(){
	this(null);
    }

    public TreeNode(int value){
	this.value = value;
    }

    
    
}