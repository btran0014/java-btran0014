package exceptions_and_gui;
import java.util.Scanner;
public class question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userinp = 0;
        int oguserinp = userinp;
        int sum = 0;
        while (true) {
          try {
            System.out.println("Enter an integer:");
            userinp = Integer.parseInt(sc.nextLine());
            oguserinp = userinp;
            while (userinp > 0) {
              sum = sum + userinp % 10;
              userinp = userinp / 10;
            }
            String lengthstring = Integer.toString(oguserinp);
            int length = lengthstring.length();
            System.out.println(oguserinp + " has " + length + " digits with a sum of " + sum + ".");
            break;
          } catch (Exception NotAnInteger) {
            System.out.println("Error. Please enter a valid integer.");
            System.out.println("");
          }
        }
      }
}
