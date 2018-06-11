import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MainTree {
	
	  NodeTree root;
	 ArrayList<Products> arr2 = new ArrayList<Products>(); 
	
	
	private NodeTree addRecursive(NodeTree root, Products value) {
	    if (root == null) {
	        return root = new NodeTree(value);
	    }
	 
	    if (value.getSaled() < root.getPro().getSaled()) {
	    	root.tLeft = addRecursive(root.tLeft, value);
	    } else if (value.getSaled() > root.getPro().getSaled()) {
	    	root.tRight = addRecursive(root.tRight, value);
	    } else {
	        return root;
	    }
	 
	    return root;
	}
	
	public void add(Products value) {
	    root = addRecursive(root, value);
	}
	
	public void traverseInOrder(NodeTree node) {
		
	    if (node != null) {
	    	
	    	
	        traverseInOrder(node.tLeft);
	        System.out.println(" " + node.pro.getSaled() + " " + node.pro.getBcode());  	
	        traverseInOrder(node.tRight);
	       
	    }

	}
	
	
	public void traverseLevelOrder() {
	    if (root == null) {
	        return;
	    }
	 
	    Queue<NodeTree> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	 
	    	NodeTree node = nodes.remove();
	 
	        System.out.println(" " + node.pro.getSaled()+" "+node.pro.getBcode());
	 
	        if (node.tLeft != null) {
	            nodes.add(node.tLeft);
	        }
	 
	        if (node.tRight!= null) {
	            nodes.add(node.tRight);
	        }
	    }
	}
	
	public NodeTree Search(String code) {
		boolean bool = false;
		NodeTree current = null;
	    if (root == null) {
	         current = null;
	    }
	 
	    Queue<NodeTree> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty() && bool == false) {
	 
	    	NodeTree node = nodes.remove();
	    	
	    	if(node.pro.getBcode().equals(code)) {
	    		bool = true;
	    		current = node;
	    	}else {
	    		 if (node.tLeft != null) {
	 	            nodes.add(node.tLeft);
	 	        }
	 	 
	 	        if (node.tRight!= null) {
	 	            nodes.add(node.tRight);
	 	        }
	    	}
	    }
		return current;
	    
	}
	
	
	private NodeTree deleteRecursive(NodeTree current, int value) {
	    if (current == null) {
	        return null;
	    }
	 
	    if (value == current.pro.getSaled()) {
	    	if (current.tLeft == null && current.tRight == null) {
	    	    return null;
	    	}
	    	if (current.tRight == null) {
	    	    return current.tLeft;
	    	}
	    	 
	    	if (current.tLeft == null) {
	    	    return current.tRight;
	    	}
	    	if(current.tRight!= null && current.tLeft != null ) {
	    		NodeTree smallestValue = nodeMin(current.tRight);
		    	current.pro.setBcode(smallestValue.pro.getBcode());
		    	current.pro.setPrice(smallestValue.pro.getPrice());
		    	current.pro.setProdName(smallestValue.pro.getProdName());
		    	current.pro.setQuantity(smallestValue.pro.getQuantity());
		    	current.pro.setSaled(smallestValue.pro.getSaled());
		    	
		    	current.tRight = deleteRecursive(current.tRight, smallestValue.pro.getSaled());
		    	return current;
	    	}
	    } 
	    if (value < current.pro.getSaled()) {
	        current.tLeft = deleteRecursive(current.tLeft, value);
	        return current;
	    }else {
	    	 current.tRight = deleteRecursive(current.tRight, value);
	 	     return current;
	    }  
	}
	
	public void delete(int value) {
	    deleteRecursive(root, value);
	}
	
	public NodeTree nodeMin(NodeTree node) {
		NodeTree min = null;
		while(node != null) {
			min = node;
			node = node.tLeft;
		}
		return min;
	}
	
	public int soNode(NodeTree root) {
		if(root == null) {
			return 0;
		}else {
			int countL,countR;		
        	 countL= soNode(root.tLeft);
        	 countR =	 soNode(root.tRight);;
			 return (countL+countR) +1;
		}
	}
	
	public NodeTree balancedBST(ArrayList<Products> arr2,int start,int end) {
		if(start > end)
			return null;
		int mid = (start + end) / 2;
		NodeTree root = new NodeTree(arr2.get(mid));
		root.tLeft = (balancedBST(arr2,start,mid -1));	
		 root.tRight = (balancedBST(arr2,mid+1,end));
		 return root;
	}
	
	public void preOrder(NodeTree node) {
	        if (node == null) {
	            return;
	        }
	        System.out.print(node.pro.getSaled() + " ");
	        preOrder(node.tLeft);
	        preOrder(node.tRight);
	    }
	
	public void arrNode(NodeTree node) {
		
	    if (node != null) {
	    	arrNode(node.tLeft);
	        arr2.add(node.pro); 	
	        arrNode(node.tRight);
	       
	    }

	}

}
