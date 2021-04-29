package java_exercises;
import java.util.Scanner;
public class question7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;
    
        System.out.println("Enter a word. Type \"quit\" or \"exit\" to terminate the program.");
        while( true){
            String signalword = sc.nextLine();
    
          if (signalword.equals("quit") || signalword.equals("exit")) {
            break;
          } 
          else{
            count+=1;
          }
          }
          System.out.println("Your total is: " + count + " words.");
        }
}
