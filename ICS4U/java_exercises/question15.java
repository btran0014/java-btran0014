package java_exercises;
import java.util.Scanner;
public class question15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userinp = 0;
        while (true) {
          try {
            System.out.println("Enter an integer.");
            userinp = Integer.parseInt(sc.nextLine());
            System.out.println("You entered the number: " + userinp + ".");
            System.out.println("Thank you.");
            break;
          } catch (Exception NotAnInteger) {
            System.out.println("Error. Please enter a valid integer.");
            System.out.println("");
    
          }
        }
    
      }
    
}
