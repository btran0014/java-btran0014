package java_exercises;
import java.util.Scanner;
public class question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the starting value? ");
        int startval = sc.nextInt();
        System.out.println("What is the ending value? ");
        int endval = sc.nextInt();
        System.out.println("What is the increment? ");
        int increment = sc.nextInt();
        System.out.printf("%20s%20s%n","List Value:", "Square:");
        for(int i = startval; i <= endval; i+=increment){
          System.out.printf("%14d%23d%n", i, i*i);
    
        }
      }
}
