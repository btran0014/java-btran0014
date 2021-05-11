package java_oop_practice_questions;
import java.util.Scanner;
public class question31 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius:");
        double InpR = sc.nextDouble();
        Circle c1 = new Circle(InpR);
        c1.output();
    }
}
