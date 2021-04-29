package java_exercises;
import java.util.Scanner;
public class question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number from 1-7. ");
        int userinp = sc.nextInt();
        String day;
        switch (userinp){
          case 1: 
          System.out.println("Sunday");
          break;
          case 2: 
          System.out.println("Monday");
          break;
          case 3: 
          System.out.println("Tuesday");
          break;
          case 4: 
          System.out.println("Wednesday");
          break;
          case 5: 
          System.out.println("Thursday");System.out.println("Tuesday");
          break;
          case 6: 
          System.out.println("Friday");
          break;
          case 7: 
          System.out.println("Saturday");
          break;
        }
        if (userinp > 7 || userinp <= 0){
          System.out.println("Please enter a valid number (between 1-7). ");
        }
      }
}
