
 
 import java.util.Scanner;

 

 class Node
{
    protected int data;
    public Node next, prev;
 
  
    public Node()
    {
        next = null;
        prev = null;
        data = 0;
    }
   
    public Node(int d, Node n, Node p)
    {
        data = d;
        next = n;
        prev = p;
    }

    public void setLinkNext(Node n)
    {
        next = n;
    }

    public void setLinkPrev(Node p)
    {
        prev = p;
    }    

    public Node getLinkNext()
    {
        return next;
    }
   
    public Node getLinkPrev()
    {
        return prev;
    }
    
    public void setData(int d)
    {
        data = d;
    }
 
    public int getData()
    {
        return data;
    }
}
 

class DoublyLinkedList
{
    protected Node start;
    public int size;
    

    public DoublyLinkedList()
    {
        start = null;
        size = 0;
        
    }

    public boolean isEmpty()
    {
        return start == null;
    }
  
    public int getSize()
    {
        return size;
    }
   
    public void insert(int val)
    {
    	int count=0;
    	int comp=0;
    	int trav=0;
    	int exc=0;
        Node nptr = new Node(val, null, null);
        Node tmp, ptr;        
        boolean ins = false;
        
        if(start == null)
            start = nptr;
        else if (val <= start.getData())
        {
            nptr.setLinkNext(start);
            start.setLinkPrev(nptr);
            start = nptr;
        }
        else
        {
        	
            tmp = start;
            ptr = start.getLinkNext();
            while(ptr != null)
            {
                if(val >= tmp.getData() && val <= ptr.getData())
                {
                	comp++;
                    tmp.setLinkNext(nptr);
                    count++;
                    
                    nptr.setLinkPrev(tmp);
                    count++;
                    nptr.setLinkNext(ptr);
                    count++;
                    ptr.setLinkPrev(nptr);
                    count++;
                    ins = true;
                    break;
                    
                }
                else
                {
                	comp++;
                    tmp = ptr;
                    count++;
                    ptr = ptr.getLinkNext();
                    count++;
                }
                trav++;
                if(ins){
                	exc++;
                }

            }
            if(!ins)
            {
                tmp.setLinkNext(nptr);
                count++;
                nptr.setLinkPrev(tmp);
                count++;
                
 
            }
                        
        }
       
        
       
        	
        	//System.out.println("No. of exchanges "+exc);
            //System.out.println("No. of traversals "+trav);
            //System.out.println("No. of comparisons "+comp);
            
        
            size++;  
    }
    
    
  



    	public void sort() {
    	    	
    	    	//this.printData();
    		int count =0;
    	    	
    	        if (size > 1) {
    	        	boolean wasChanged;
    	 
    	            do {
    	                Node current = start;
    	                Node previous = null;
    	                Node next = start.next;
    	                wasChanged = false;
    	 
    	                while ( next != null ) {
    	                    if (current.data > next.data) {
    	                       
    	                        wasChanged = true;
    	 
    	                        if ( previous != null ) {
    	                        	
    	                        	//System.out.println("Singly");
    	                        	Node sig = next.next;
    	                            count++;
    	                        	previous.next = next;
    	                        	count++;
    	                        	next.next = current;
    	                        	count++;
    	                        	current.next = sig;
    	                        	count++;
    	                        	
    	                        	
    	                        } else {
    	                        	//System.out.println("Singly");
    	                        	
    	                        	Node sig = next.next;
                                    count++; 	 
    	                        	start = next;
    	                        	count++;
    	                        	next.next = current;
    	                        	count++;
    	                        	current.next = sig;
    	                        	count++;
    	                        	//sig.prev=next;
    	                        	//previous.next=start;
    	                        }
    	 
    	                        previous = next;
    	                        count++;
    	                        next = current.next;
    	                        count++;
    	                    } else { 
    	                    	//System.out.println("Singly");
    							previous = current;
    							count++;
    		                    current = next;
    		                    count++;
    		                    next = next.next;
    		                    count++;
    	                    }
    	                } 
    	            } while( wasChanged );
    	        }
    	      //  System.out.println(count);
    	    } 
    
    

    
    
    
   
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            if (size == 1)
            {
                start = null;
                size = 0;
                return; 
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node ptr = start;
 
            for (int i = 1; i < size - 1; i++)
                ptr = ptr.getLinkNext();
            ptr.setLinkNext(null);            
            size --;
            return;
        }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();
 
                p.setLinkNext(n);
                n.setLinkPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getLinkNext();
        }        
    }    
    
    public Node GetNth(int val)
    {
    	Node pNode = start;
        
        /* traverse the list */
        while (pNode != null) {
            /* Target! */
            if(pNode.data == val)
            {
                return pNode;
            }
            /* move to the next one */
            pNode = pNode.next;
        }
        return null;
    }
    
    
    
  /*  public void bubbleSort(int val){ //static method used to sort the linked list using bubble sort {
    	Node tmp = start;
         Node ptr = start.getLinkNext();
         boolean ins=false;
         Node nptr=GetNth(val);
         while(ptr != null)
         {
             if(val >= tmp.getData() && val <= ptr.getData())
             {
            	 
            	 nptr.setData(val);
                 tmp.setLinkNext(nptr);
                 nptr.setLinkPrev(tmp);
                 nptr.setLinkNext(ptr);
                 ptr.setLinkPrev(nptr);
                 ins = true;
                 break;
             }
             else
             {
                 tmp = ptr;
                 ptr = ptr.getLinkNext();
             }
         }
         if(!ins)
         {
             tmp.setLinkNext(nptr);
             nptr.setLinkPrev(tmp);

         }
    }
    
    */
    
    

    public void display()
    {
    	//start.getData();
    	
    	
        System.out.print("=");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
      
        System.out.print(start.getData()+ " ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)
        {
            System.out.print(ptr.getData()+ " ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
    
    
    
}