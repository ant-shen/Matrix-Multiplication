import java.util.Random;
import java.util.Scanner;

public class classical {
    
    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int p = B[0].length;
        
        int[][] C = new int[m][p];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return C;
    }
    
    public static void main(String[] args) {
        
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
  
                    int[][] C = multiply(A, B);
                    System.out.print(C[i][j] + " ");
                }

                System.out.println();
            }
        /*System.out.println("Matrix A: ");
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
        
    } */
    System.out.println("Time: " + duration + " nanoseconds");
 
    }
}
