package java_exercises;
import java.util.Scanner;
import java.math.*;
public class question9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many marks would you like to calculate? ");
    
        int numofmarks = sc.nextInt();
        int marks = 0;
        int counter = 0;
    
        for (int i = 0; i < numofmarks; i++) {
          System.out.println("Enter mark (-1 to quit): ");
          int mark = sc.nextInt();
          if (mark == -1) {
            break;
          }
    
          else if (mark >= -1 && mark <= 100) {
            marks += mark;
            counter += 1;
          } else{
            System.out.println("Invalid entry. Please enter a value from 0-100.");
    
          }
        }
        if(counter == 0){ 
          System.out.println("Average cannot be calculated.");
        }
        else{
           System.out.println("The average is: " + (Math.round((marks / counter) * 10) / 10.0));
        }
        
    }
}
