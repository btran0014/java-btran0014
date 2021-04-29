package java_exercises;
import java.lang.Math;
import java.util.Scanner;
public class question12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        System.out.println("Enter the minimum value.");
        int min = sc.nextInt();
     
        System.out.println("Enter the maximum value.");
        int max = sc.nextInt();
     
       int range = max - min + 1;
     
       for (int i = 0; i < 10; i++){
         int rand = (int)(Math.random()*range) + min;
         System.out.println("Value " + (i+1) + ": " + rand);
       }
       }
}
