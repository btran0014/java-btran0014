package java_exercises;
import java.util.Scanner;
public class question11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
      
        System.out.println("Enter an integer:");
        int userinp = sc.nextInt();
        int oguserinp = userinp;
        int sum = 0;
      
        while (userinp > 0){
          sum = sum + userinp % 10;
          userinp = userinp/10;
        }
        String lengthstring = Integer.toString(oguserinp);
        int length = lengthstring.length();
        System.out.println(oguserinp + " has " + length + " digits with a sum of " + sum + ".");
        }
}
