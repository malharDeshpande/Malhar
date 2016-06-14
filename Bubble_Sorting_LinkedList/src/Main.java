import java.util.Random;

public class Main {
	
		 
	    public static void main (String[]args) {
	 
	        LinkedList dll = new LinkedList();
	        
	        DoublyLinkedList dl = new DoublyLinkedList();
	 
	        
	        
	        Random random = new Random();
	        int n=random.nextInt(100)+1;
	       
	        	int[] j=new int[n];
	        	for(int k=0;k<n;k++){
	        		j[k]=random.nextInt(50000)+1;
	        	}
	           //i=random.nextInt(50)+1;
	        	for(int i=0;i<n;i++){
	           dll.add(j[i]);
	           dl.insert(j[i]);
	           
	          // dl.bubbleSort(j[i]);
	        }
	         
	       
	        
	        	dll.sort();
	       
	        	System.out.println("\n\n"+"_________________________________________________________________________________________________________________");
	        	
	        	System.out.println("DOUBLY LINKED LIST ");dl.display();
	        	System.out.println("\n\n"+"_________________________________________________________________________________________________________________");
	        	
	      //  dl.Print();
	        System.out.println("SINGLY LINKED LIST ");dll.printData();
	        System.out.println("\n\n"+"_________________________________________________________________________________________________________________");
        	
	        System.out.println("List size: " + dll.listSize());
	    }
	}
//}
