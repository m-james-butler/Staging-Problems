import java.util.Scanner;

public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      String ms = sc.nextLine();
      

      System.out.println(rs(ms));
    }
    
    static String rs (String ms) {
        double as = Double.parseDouble(ms.substring(0, ms.length() - 2));
        String ut = ms.substring(ms.length() - 2);
        double rs = 0;
        
        if (ut.toUpperCase().equals("GB")) {
            rs = Math.round(as * 0.93 * 100) / 100.0;
            if (rs < 1) {
                rs = Math.round(rs * 1000);
                return String.format("%.0f", rs) + "MB";
            } else {
                return rs + ut;
            }
        } else if (ut.toUpperCase().equals("MB")) {
            rs = Math.round(as * 0.93);
            return String.format("%.0f", rs) + ut;
        } else {
            return "Invalid Input. Please input only MB or GB.";
        }
    }
}
