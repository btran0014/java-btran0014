package java_exercises;
import java.util.Scanner;
import java.util.Arrays;
public class question14 {
    public static void histogram(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
          for (int j = 1; j <= arr[i]; j++) {
            System.out.print("*");
          }
          System.out.println("");
        }
      }
    
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the list value. Enter -1 to exit and print histograms.");
        int assignment = 0;
    
        int[] arr = {};
        while (assignment != -1) {
          arr = Arrays.copyOf(arr, arr.length + 1);
          arr[arr.length - 1] = assignment;
          assignment = sc.nextInt();
        }
        histogram(arr);
      }
}
