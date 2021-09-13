import java.util.Scanner;

//for the purposes of the assignment I've assumed all input for the octal conversion are representable as an int. The logic would work equally well with Long. 
//for the ROT13 I've accepted any character from space thru tilde as acceptable, just for fun. It is case sensitive and will encode spaces and punctuation.
public class MyClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            System.out.println("Easy result is: " + easyToOctal(num));
            System.out.println("Logic result it: " + logicOctal(num));
        }
        
        int M = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < M/2; i++) {
            String str = sc.nextLine();
            System.out.println("Encrypt " + str + " is: " + encrypt(str));
            str = sc.nextLine();
            System.out.println("Decrypt of " + str + " is: " + decrypt(str));
        }
    }
    
    public static String easyToOctal (int num) {
        return Integer.toOctalString(num);
    }
    
    public static String logicOctal (int num) {
        int r;
        String output = "";
        char octals[]={'0','1','2','3','4','5','6','7'};
        
        while(num > 0) {
            r = num % 8;
            output = octals[r] + output;
            num = num/8;
        }
        
        return output;
    }
    
    public static String encrypt(String str) {
        String out = "";
        for (char c : str.toCharArray()) {
            c += 13;
            if (c > 126) {
                c -= 94;
            }
            out += c;
        }
        return out;
    }
    
    public static String decrypt(String str) {
        String out = "";
        for (char c : str.toCharArray()) {
            c -= 13;
            if (c < 32) {
                c += 94;
            }
            out += c;
        }
        return out;
    }
}
