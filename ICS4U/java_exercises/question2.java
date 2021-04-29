package java_exercises;
import java.util.Scanner;
public class question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your first name? ");
        String firstname = sc.nextLine();
        System.out.println("What is your middle name?");
        String midname = sc.nextLine();
        System.out.println("What is your last name?");
        String lastname = sc.nextLine();
    
        System.out.println("I can list you as: ");
        System.out.println (lastname + ", " + firstname + " " + midname);
        System.out.println(firstname + " " + midname + " " + lastname);
        System.out.println(firstname + " " + lastname);
        System.out.println(firstname + " " + midname.charAt(0) + ". " + lastname);
      }
    }
