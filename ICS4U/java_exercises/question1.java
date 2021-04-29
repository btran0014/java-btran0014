package java_exercises;
import java.math.*;
import java.util.Scanner;

public class question1 {
        public static void main(String[] args) {
        double Pi = Math.PI;
        System.out.println("What is the radius? ");
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        System.out.println("Circumference: " + (Math.round((2 * Pi * radius)*10))/10.0);
        System.out.println("Area: " + (Math.round((Pi * radius*radius)*10)/10.0));
        }
}
