package exceptions_and_gui;
import java.util.Scanner;
public class question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startval=0;
        int endval = 0;
        int increment = 0;
        while(true){
          try{
            System.out.println("What is the starting value? ");
            startval = sc.nextInt();
            System.out.println("What is the ending value? ");
            endval = sc.nextInt();
            System.out.println("What is the increment? ");
            increment = sc.nextInt();
            System.out.printf("%20s%20s%n","List Value:", "Square:");
            for(int i = startval; i <= endval; i+=increment){
            System.out.printf("%14d%23d%n", i, i*i);
            } 
            break;
            }catch (Exception NotAnInteger){
            System.out.println("Error. Please enter a valid integer.");
            System.out.println("");
            break; // had to put this here in order to prevent an infinite loop of print statements. delete break to see.
          }
        }
      }  
}
