package java_exercises;

public class question8 {
    public static void main(String[] args) {
        int rows = 7;
   
       for (int i = 1; i <= rows; ++i) {
         for (int j = 1; j <= i; ++j) {
           System.out.print(j + " ");
         }
         System.out.println();
         }
       }
}
