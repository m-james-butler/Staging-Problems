import java.util.Scanner;
public class MyClass {
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int x = sc.nextInt();
      int y = sc.nextInt();
      int k1 = sc.nextInt();
      int k2 = sc.nextInt();
      
      System.out.println("X is " + x + " and Y is " + y);
      swapSimple(x,y);
      oneLine(x,y);
      
      System.out.println("Passing K1 = " + k1 + " and K2 = " + k2 + " results in " + numWays(2, 2) + " combinations.");
      
    }
    
    /*
    *This version swaps the variables by simple arithmetic. It is subject to errors for overflow.
    */
    public static void swapSimple(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("Simple reversal X is " + x + " and Y is " + y);
    }
    
    /*
    *This version swamp the variables through XOR logic. See Generally, https://www.baeldung.com/java-xor-operator
    */
    public static void oneLine(int x, int y) {
        x = x ^ y ^ (y = x);
        System.out.println("XOR reversal X is " + x + " and Y is " + y);
    }
    
    /*
    * Use dynamic programming for this. Interestingly, N is completely irrelevant since it is equal to K1 + k2, so I have omitted it here.
    */
    public static int numWays(int k1, int k2) {
        
        //init an array to hold computations
        int[][] vals = new int[k1 + 1][k2 +1];
        
        //there is always exactly 1 way to end a sequnce, namely with k2
        for (int i = 0; i <= k2; i++) {
            vals[k1][i] = 1;
        }
        
        //compute the possible permutations of the rest of the series. This will result in cell [0][0] holding the correct number of possible outcomes (it will be calculated last);
        for (int i = k1 -1; i >= 0; i--) {
            for (int j = k2 - 1; j >= 0; j--) {
                vals[i][j] = vals[i][j+1] + vals[i+1][j];
            }
        }
        
        return vals[0][0];
    }
}
