package java_exercises;
import java.util.Scanner;
public class question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first value: ");
        int w = sc.nextInt();
        System.out.println("Enter second value: ");
        int x = sc.nextInt();
        System.out.println("Enter third value: ");
        int y = sc.nextInt();
        System.out.println("Enter fourth value: ");
        int z = sc.nextInt();
        
        System.out.println("You entered: " + w + " " + x + " " + y + " " + z);
    
        int max = 0;
    
        if (w >= x && w >= y && w >= z){
          max = w;
        }
        else if (x >= w && x >= y && x >= z){
          max = x;
        }
        else if (y >= w && y >= x && y >= z){
          max = y;
        }
        else if (z >= w && z >= x && z >= y){
          max = z;
        }
        System.out.println("The largest value of the entered values is: " + max);
      }
}
