import java.util.Random;

class LinkedList {  
	public static class Node {
	    int data; 
	    Node nextNode;
	   // Node next;
	   // int count;
 
	    public Node(int data) {
	        this.data = data;
	        this.nextNode = null;       
	    }
 
	    public int getData() {
	        return this.data;
	    }
	    
	   
	} // Node class
 
    private  Node head;
    private int size; 
 
    public LinkedList(){
        this.head = null;
        this.size = 0;
       
        
    }
    
 
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while(currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = node;
        }
        size++;     
    }
 
    public void sort() {
    	int count=0;
    	int comp=0;
    	int trav=0;
    	int exc=0;
    	System.out.println("UNSORTED LIST");
    	this.printData();
    	
        if (size > 1) {
        	boolean wasChanged;
 
            do {
            	
                Node current = head;
                Node previous = null;
                Node next = head.nextNode;
                wasChanged = false;
 
                while ( next != null ) {
                	
                    if (current.data > next.data) {
                    	comp++;
                      
                        wasChanged = true;
 
                        if ( previous != null ) {
                        	//System.out.println("Singly");
                        	Node sig = next.nextNode;
                            count++;
                        	previous.nextNode = next;
                        	count++;
                        	next.nextNode = current;
                        	count++;
                        	current.nextNode = sig;
                        	count++;
                        } else {
                        	//System.out.println("Singly");
                        	Node sig = next.nextNode;
                        	count++;
                        	head = next;
                        	count++;
                        	next.nextNode = current;
                        	count++;
                        	current.nextNode = sig;
                        	count++;
                        }
 
                        previous = next;
                        count++;
                        next = current.nextNode;
                        count++;
                    } else { 
                    	comp++;
                    	//System.out.println("Singly");
						previous = current;
						count++;
	                    current = next;
	                    count++;
	                    next = next.nextNode;
	                    count++;
                    }trav++;
                   
                } 
                if(wasChanged){
                	exc++;
                }
            } while( wasChanged );
            
            
        }
        System.out.println("No of Comparisons "+comp);
        System.out.println("No of Traversals "+trav);
       System.out.println("No of Exchanges "+exc);
    }
    
 
 
 
    public int listSize() {     
        return size;
    }
 
    public void printData() {
        Node currentNode = head;
 
        System.out.print("=");
        while(currentNode != null) {
            int data = currentNode.getData();

	        
	       
        
            System.out.print(data + " ");
            currentNode = currentNode.nextNode;
           
        }
 
       // System.out.print(" ]");
       
        System.out.println("");
    }
 
    public boolean isEmpty() {
        return size == 0;
    }


	public Node getFirst() {
		
		return null;
	}
} // 