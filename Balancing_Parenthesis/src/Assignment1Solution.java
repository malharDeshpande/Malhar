import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Assignment1Solution {
	
	    private static final char LEFT_PARENTHESES     = '(';
	    private static final char RIGHT_PARENTHESES    = ')';
	    private static final char LEFT_CURLYBRACE     = '{';
	    private static final char RIGHT_CURLYBRACE    = '}';
	    private static final char LEFT_BRACKET   = '[';
	    private static final char RIGHT_BRACKET  = ']';

	
	 public static boolean validateClass(String inputfile){
		 Stack<Character> stack = new Stack<Character>();
	        for (int i = 0; i < inputfile.length(); i++) {
	            if (inputfile.charAt(i) == LEFT_PARENTHESES)   stack.push(LEFT_PARENTHESES);
	            if (inputfile.charAt(i) == LEFT_CURLYBRACE)   stack.push(LEFT_CURLYBRACE);
	            if (inputfile.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);

	            if (inputfile.charAt(i) == RIGHT_PARENTHESES) {
	                if (stack.isEmpty())           return false;
	                if (stack.pop() != LEFT_PARENTHESES) return false;
	            }

	            else if (inputfile.charAt(i) == RIGHT_CURLYBRACE) {
	                if (stack.isEmpty())           return false;
	                if (stack.pop() != LEFT_CURLYBRACE) return false;
	            }

	            else if (inputfile.charAt(i) == RIGHT_BRACKET) {
	                if (stack.isEmpty())             return false;
	                if (stack.pop() != LEFT_BRACKET) return false;
	            }
	        }
	        return stack.isEmpty();
	    }


	  /*  public static void main(String[] args) throws FileNotFoundException {
	    	String str = "public {"
	    			+ "static void main }}";
	        System.out.println(validateClass(str)); 
	    	//Scanner in = new Scanner(new File("C:/input/NegativeScenarioInput.java"));
	    	//System.out.println(in);
	    //	Scanner in = new Scanner(new File("C:/input/NegativeScenarioInput.java"));
	    }*/
	    }