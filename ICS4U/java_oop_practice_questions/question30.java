package java_oop_practice_questions;
import java.util.Scanner;
public class question30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length: ");
        int InpL = sc.nextInt();
        System.out.println("Enter width: ");
        int InpW = sc.nextInt();
        Rectangle r1 = new Rectangle(InpL, InpW);
        r1.output();
    }
    
}

