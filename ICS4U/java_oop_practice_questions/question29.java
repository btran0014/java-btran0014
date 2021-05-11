package java_oop_practice_questions;

public class question29 {
    public static void main(String[]args){
        final int SIZE = 30;
        int [] numbers = new int[SIZE];
        for(int i = 0; i <= 29; i++){
            numbers[i] = i;
            System.out.print(numbers[i] + "\n");
        }
        System.out.println("END OF LOOP");
    }
}
