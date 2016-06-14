import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Assignment1Test {
	 public static void main(String[] args) throws FileNotFoundException, IOException {
	      Assignment1Solution soln = new Assignment1Solution();
	         
	      /**
	       * LOAD INPUT FILE HERE
	       */
	     // String inputFile = readFile("C:/input/PositiveScenarioInput.txt");
	      String inputFile = readFile("/AlgoAssignment1/input/PositiveScenarioInput.java");
	      
	      if (soln.validateClass(inputFile)) {
	            System.out.println("Its a valid Java Class File or true"); 
	            printFileStats(inputFile);
	        } else {
	            System.out.println("Its not a valid Java Class File"); 
	        }
	      
	      
	    }
	 

	    private static void printFileStats(String inputFile)  {
	        /**
	         * TODO -- implement this
	         */
	    	
	    	
	    	
	   
	    	
	    	  HashMap map = new HashMap();  // word --> Its occurences
	    	  
	    	    // Reads each word from the file
	    	  StringTokenizer st = new StringTokenizer(inputFile);
	    	 
                   
	    	 

				System.out.println("Split by space here");
				while (st.hasMoreElements()) {
	    	      String word = st.nextToken();
	    	
	    	   
	    	      

	    	   
	    	  
	    	      if(map.containsKey(word)) {
	    	        //if the word already exits, increment
	    	    	  
	    	        Integer count = (Integer)map.get(word);
	    	        map.put(word, new Integer(count.intValue() + 1));
	    	       
	    	    	  
	    	      } else {
	    	       //if this is not seen again
	    	        map.put(word, new Integer(1));
	    	      }
	    	     
	    	    }

	    	    //prints out every word in the input file scenario, along with its count,
	    	   
	    	    ArrayList arraylist = new ArrayList(map.keySet()); 
	    	    Collections.sort(arraylist);
	    	    
	    	    for (int i = 0; i < arraylist.size(); i++) {
	    	      String key = (String)arraylist.get(i);
	    	      Integer count = (Integer)map.get(key);
	    	      System.out.println(key + " -> " + count);
	    	    }

	    
	    }
	    
	    
	    /**
	     * DO NOT CHANGE THIS
	     * @param fileName
	     * @return
	     * @throws IOException 
	     */
	    
	    public static String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	    	
	    
	    	
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	    }
}
