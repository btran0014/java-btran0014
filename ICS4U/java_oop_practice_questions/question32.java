package java_oop_practice_questions;
import java.util.Scanner;
public class question32 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String Inpname = sc.nextLine();
        System.out.println("Enter your username:");
        String Inpusername = sc.nextLine();
        System.out.println("Enter the address for your email.");
        String Inpaddress = sc.nextLine();
        Entry e1 = new Entry(Inpname, Inpusername, Inpaddress);
        e1.output();
    }
}