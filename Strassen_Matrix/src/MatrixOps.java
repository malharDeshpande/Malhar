
import java.io.*;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
public class MatrixOps
{
	public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
         Scanner input = new Scanner( System.in );
        String s;
            Random r = new Random();
	public MatrixOps()   throws IOException
	{
		int n;
		int[][] a, b, c;
                int x, y;
		System.out.print("Enter the number of rows or colums: ");
		n = Integer.parseInt(br.readLine());
               
		a = new int[n][n];
		b = new int[n][n];
		c = new int[n][n];
                
        System.out.println("Enter x(min value):");
        
        s= input.next();
        x= Integer.parseInt(s);
        System.out.println("Enter y(max value):");
        s= input.next();
        y= Integer.parseInt(s);
        
        System.out.println();
       
		System.out.print("\n\n 1st Matrix:\n\n");
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				a[i][j] = r.nextInt((y - x) + 1) + x;
			}
		}
                //Print here
                printArray(a);
                
		System.out.print("\n\n The values for 2nd Matrix:\n");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				//System.out.print("Enter the value of cell ("+(i+1)+","+(j+1)+"): ");
				b[i][j] = r.nextInt((y - x) + 1) + x;
			}
		}
		//Print here
                printArray(b);
            
		Calendar t1 = Calendar.getInstance();
		System.out.print("\n\nMatrix 1 X Matrix 2 is:\nBy Regular matrices method:\n");
		traditionalMatrixMultiplication(a, b);
		//printArray(c);
		Calendar t2 = Calendar.getInstance();
		System.out.print("Time taken to solve: "+(t2.getTimeInMillis() - t1.getTimeInMillis()  ));
             
                
		 t1 = Calendar.getInstance();
		System.out.print("\n\nBy Strassen Algorithm Multiplication method:\n");
		c = strassenMatrixMultiplication(a, b);
                
		//printArray(c);
		 t2 = Calendar.getInstance();
		System.out.print("Calculation for time: "+(t2.getTimeInMillis() - t1.getTimeInMillis()  ));
             
                System.out.println();
	}
	
	
    //    
	public int[][] traditionalMatrixMultiplication(int[][] a, int[][] b)
	{
            
		int n = a.length;
                int [][] c = new int[n][n] ;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				for(int k=0; k<n; k++)
					c[i][j] += a[i][k] * b[k][j];
                
                return c;
	}
	
	
	//Strassen's Algorithm for matrix multiplication
	public int [][] strassenMatrixMultiplication(int [][] A, int [][] B)
	{
           // int [][] c = null;
		int n = A.length;
		int [][] result = new int[n][n];
               
                if(n<128){
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				for(int k=0; k<n; k++)
					result[i][j] += A[i][k] * B[k][j];
                
              
                }
                else{
            //n should be even 
		if((n%2 != 0 ) && (n !=1) )
		{
                  
			int[][] a1, b1, c1;
			int n1 = n+1;
			a1 = new int[n1][n1];
			b1 = new int[n1][n1];
			c1 = new int[n1][n1];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
				{
					a1[i][j] =A[i][j];
					b1[i][j] =B[i][j];
				}
			c1 = strassenMatrixMultiplication(a1, b1);
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					result[i][j] =c1[i][j];
			return result;
                                     
		}
                 else if(n == 1)
		{
			result[0][0] = A[0][0] * B[0][0];
		}
                
               
		else
		{
            
			int [][] A11 = new int[n/2][n/2];
			int [][] A12 = new int[n/2][n/2];
			int [][] A21 = new int[n/2][n/2];
			int [][] A22 = new int[n/2][n/2];
			int [][] B11 = new int[n/2][n/2];
			int [][] B12 = new int[n/2][n/2];
			int [][] B21 = new int[n/2][n/2];
			int [][] B22 = new int[n/2][n/2];
			divideArray(A, A11, 0 , 0);
			divideArray(A, A12, 0 , n/2);
			divideArray(A, A21, n/2, 0);
			divideArray(A, A22, n/2, n/2);
			divideArray(B, B11, 0 , 0);
			divideArray(B, B12, 0 , n/2);
			divideArray(B, B21, n/2, 0);
			divideArray(B, B22, n/2, n/2);
 
                        
			int [][] P1 = strassenMatrixMultiplication(addMatrices(A11, A22), addMatrices(B11, B22));
			int [][] P2 = strassenMatrixMultiplication(addMatrices(A21, A22), B11);
			int [][] P3 = strassenMatrixMultiplication(A11, subtractMatrices(B12, B22));
			int [][] P4 = strassenMatrixMultiplication(A22, subtractMatrices(B21, B11));
			int [][] P5 = strassenMatrixMultiplication(addMatrices(A11, A12), B22);
			int [][] P6 = strassenMatrixMultiplication(subtractMatrices(A21, A11), addMatrices(B11, B12));
			int [][] P7 = strassenMatrixMultiplication(subtractMatrices(A12, A22), addMatrices(B21, B22));
                        
			int [][] C11 = addMatrices(subtractMatrices(addMatrices(P1, P4), P5), P7);
			int [][] C12 = addMatrices(P3, P5);
			int [][] C21 = addMatrices(P2, P4);
			int [][] C22 = addMatrices(subtractMatrices(addMatrices(P1, P3), P2), P6);
			copySubArray(C11, result, 0 , 0);
			copySubArray(C12, result, 0 , n/2);
			copySubArray(C21, result, n/2, 0);
			copySubArray(C22, result, n/2, n/2);
                        }
                }
                return result;
	}
	
	//Addition
	
	public int [][] addMatrices(int [][] A, int [][] B)
	{
		int n = A.length;
		int [][] result = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			result[i][j] = A[i][j] + B[i][j];
		return result;
	}
	
	
	//Subtraction
	
	public int [][] subtractMatrices(int [][] A, int [][] B)
	{
		int n = A.length;
		int [][] result = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			result[i][j] = A[i][j] - B[i][j];
		return result;
	}
	
	
	//Division
	
	
	public void divideArray(int[][] parent, int[][] child, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<child.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<child.length; j1++, j2++)
			{
				child[i1][j1] = parent[i2][j2];
			}
	}
	public void copySubArray(int[][] child, int[][] parent, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<child.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<child.length; j1++, j2++)
			{
				parent[i2][j2] = child[i1][j1];
			}
	}
	
	//print array
	
	public void printArray(int [][] array)
	{
		int n = array.length;
		System.out.println();
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Main
	public static void main(String[] args) throws IOException
	{
		new MatrixOps();
		
	}
}  

