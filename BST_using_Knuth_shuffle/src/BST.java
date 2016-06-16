import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.ToIntFunction;

public class BST{
	
	public static  Node root;
	public BST(){
		this.root = null;
	}
	
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;  		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	//Calculate Height
	public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	//Knuth Reshuffle Algorithm
	public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // choose index uniformly in [i, N-1]
            int r = i + (int) (Math.random() * (N - i));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }
	//Pre-order traversal
	public void preorder(Node root) {  
	    if(root !=  null) {  
	   //Visit the node-Printing the node data    
	      System.out.printf("%d ",root.data);  
	      preorder(root.left);  
	      preorder(root.right);  
	    }  
	  }  
	   

	
	//In order traversal
	 public void inOrder(Node root) {  
		  if(root !=  null) {  
		   inOrder(root.left);  
		   //Visit the node by Printing the node data    
		   System.out.printf("%d ",root.data);  
		   inOrder(root.right);  
		  }  
		 }  
	 
	 //Post Order Traversal
	 public void postOrder(Node root) {  
		  if(root !=  null) {  
		   postOrder(root.left);  
		   postOrder(root.right);  
		   //Visit the node by Printing the node data    
		   System.out.printf("%d ",root.data);  
		  }  
		 }  

	

	 public static int[] toInt(Set<Integer> hashset) {
	        int[] arr = new int[hashset.size()];
	        int i = 0;
	        for (Integer val : hashset) arr[i++] = val;
	         
	        return arr;
	    }
	
	
	
	public static void main(String arg[]){
		BST b = new BST();
		int num=0;
		int Num = 0;
		
		for(int in = 0; in<= 100; in++){
			Random random = new Random();
		    int n=random.nextInt(100)+1;
	        int[] j=new int[n];
			//Integer[] arr = new Integer[1000];
		    //for (int i = 0; i < arr.length; i++) {
		     //   arr[i] = i;
		    //}
		    //Collections.shuffle(Arrays.asList(arr));
	        
		    //System.out.println(Arrays.toString(arr));

		//}
			
	        System.out.println("Random"+"\n");
	        
	     
	        Set<Integer> generated = new LinkedHashSet<Integer>();
        	for(int k=0;k<n;k++){
	        //for(int k=0;k<;k++){
        		/*while (generated.size() < 100)
        		{
        		    Integer next = random.nextInt(100) + 1;
        		    // As we're adding to a set, this will automatically do a containment check
        		    generated.add(next);
        		    j=toInt(generated);
        		    
        		}*/
        	
        	j[k]=random.nextInt(100)+1;
            
        		 System.out.print(j[k]+" "); 
        	}
        	/*for(int bb=0;bb<n;bb++){
        		System.out.print(j[bb]+" ");
        	}*/
        /*	Iterator itr = generated.iterator();
            while(itr.hasNext()){
                System.out.print(itr.next()+" ");
            }*/
           
        	//for(int m=0;m<=100;m++){
        	
        	
        	b.shuffle(j);
        	System.out.println("\n"+"After reshuffle"+"\n");
        	for(int i=0;i<n;i++){
                System.out.print(j[i]+" "); 
                b.insert(j[i]);
        	}
        	
        	
        
        
		//here traversals
		
        	System.out.println("\n"+"Original Tree : ");
    		b.display(b.root);		
    		System.out.println("");
    		
    		System.out.println("\n"+"Preorder Traversal: ");
    		b.preorder(root);
    		//b.display(root);
    		
    		System.out.println("\n"+"Inorder Traversal: ");
    		b.inOrder(root);
    		//b.display(root);
    		
    		System.out.println("\n"+"Postorder Traversal: ");
    		b.postOrder(root);
    		//b.display(root);
		
		
		//System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		//System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		//b.display(root);
		//System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		//b.display(root);
		//System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		//b.display(root);
        //b.display(root);
       System.out.println("\n"+"height "+b.height(root));
        	}
		
		
		
       
	}
	}
//}

class Node{
	int data;
	Node left;
	Node right;	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}