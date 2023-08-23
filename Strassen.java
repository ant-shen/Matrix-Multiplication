import java.util.Random;
import java.util.Scanner;

public class Strassen {
    public int[][] multiply(int[][] A, int[][] B)
    {
        // Order of matrix
        int n = A.length;
 
   
        int[][] Result = new int[n][n];
 
        if (n == 1)
            Result[0][0] = A[0][0] * B[0][0];
 

        else {
          //Dividing Matrix into subparts
            
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];
 
            // Step 2: Dividing matrix A into 4 halves
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
 
            // Step 2: Dividing matrix B into 4 halves
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);
 

            int[][] P1 = multiply(add(A11, A22), add(B11, B22));
            int[][] P2 = multiply(add(A21, A22), B11);
            int[][] P3 = multiply(A11, subtract(B12, B22));    
            int[][] P4 = multiply(A22, subtract(B21, B11));      
            int[][] P5 = multiply(add(A11, A12), B22);
            int[][] P6 = multiply(subtract(A21, A11), add(B11, B12));
            int[][] P7 = multiply(subtract(A12, A22), add(B21, B22));
            
            int[][] C11 = add(subtract(add(P1, P4), P5), P7);
            int[][] C12 = add(P3, P5);
            int[][] C21 = add(P2, P4);
            int[][] C22 = add(subtract(add(P1, P3), P2), P6);

            join(C11, Result, 0, 0);
            join(C12, Result, 0, n / 2);
            join(C21, Result, n / 2, 0);
            join(C22, Result, n / 2, n / 2);
        }
 
        return Result;
    }
 
    public int[][] subtract(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
 
        return C;
    }
 
    
    public int[][] add(int[][] A, int[][] B)
    {

        int n = A.length;
        int[][] C = new int[n][n];
 
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
 
    public void split(int[][] P, int[][] C, int iB, int jB)
    {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
 
                C[i1][j1] = P[i2][j2];
    }
 
 
    public void join(int[][] C, int[][] P, int iB, int jB)
 
    {
   
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
 
                P[i2][j2] = C[i1][j1];
    }
 
    
    public static void main(String[] args)
    {
        Strassen s = new Strassen();
        
        Random r = new Random();
        System.out.println("Please enter the size");
        Scanner input = new Scanner(System.in);
 
        int size = input.nextInt();
        
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime); 
        
        int A [][]  = new int[size][size];
        int[][] B = new int[size][size];
        
        System.out.println(
            "\nProduct of matrices A and  B : ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                A [i][j] = r.nextInt(10);
                B [i][j] = r.nextInt(10);
                int[][] C = s.multiply(A, B);
                System.out.print(C[i][j] + " ");
                }

            System.out.println();
        }
        System.out.println("Matrix A: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
    }
        System.out.println();
        
        System.out.println("Matrix B: ");
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            System.out.print(B[i][j] + " ");
        }
        System.out.println();
    }
        System.out.println("Time: " + duration + " nanoseconds");
    
       
    }
    
}
 
