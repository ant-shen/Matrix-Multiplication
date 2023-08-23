import java.util.Random;
import java.util.Scanner;

public class DivAndConq {
    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = getSubmatrix(A, 0, 0, n/2);
            int[][] A12 = getSubmatrix(A, 0, n/2, n/2);
            int[][] A21 = getSubmatrix(A, n/2, 0, n/2);
            int[][] A22 = getSubmatrix(A, n/2, n/2, n/2);
            
            int[][] B11 = getSubmatrix(B, 0, 0, n/2);
            int[][] B12 = getSubmatrix(B, 0, n/2, n/2);
            int[][] B21 = getSubmatrix(B, n/2, 0, n/2);
            int[][] B22 = getSubmatrix(B, n/2, n/2, n/2);
            
            int[][] C11 = addMatrix(multiply(A11, B11), multiply(A12, B21));
            int[][] C12 = addMatrix(multiply(A11, B12), multiply(A12, B22));
            int[][] C21 = addMatrix(multiply(A21, B11), multiply(A22, B21));
            int[][] C22 = addMatrix(multiply(A21, B12), multiply(A22, B22));
            
            copySubmatrix(C11, C, 0, 0);
            copySubmatrix(C12, C, 0, n/2);
            copySubmatrix(C21, C, n/2, 0);
            copySubmatrix(C22, C, n/2, n/2);
        }
        
        return C;
    }
    
    public static int[][] getSubmatrix(int[][] matrix, int rowStart, int colStart, int size) {
        int[][] submatrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                submatrix[i][j] = matrix[rowStart + i][colStart + j];
            }
        }
        
        return submatrix;
    }
    
    public static int[][] addMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        
        return C;
    }
    
    public static void copySubmatrix(int[][] submatrix, int[][] matrix, int rowStart, int colStart) {
        int size = submatrix.length;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[rowStart + i][colStart + j] = submatrix[i][j];
            }
        }
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