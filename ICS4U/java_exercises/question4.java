package java_exercises;
import java.math.*;
import java.util.Scanner;
public class question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the cost? ");
        double price = sc.nextDouble();
        if (price <=0.0){
          System.out.println("Invalid price.");
        }
        else if (price > 100.0){
          price *=0.6;
        }
        else if (price >= 75.0 && price <=100.0){
          price *=0.7;
        }
        else if (price >= 50.0 && price <75.0 ){
          price *=0.8;
        }
        else if (price >=25.0 && price <50.0){
          price *=0.9;
        }
        System.out.println("Your price is: " + (Math.round((price) * 100)/100.0));
      }
}
