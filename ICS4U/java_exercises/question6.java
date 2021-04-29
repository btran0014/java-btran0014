package java_exercises;

public class question6 {
    public static void main(String[] args) {
        // original loop
        int count1 = 1;
        while (count1 < 20){
          count1++;
          System.out.print(count1 + " ");
        }
    
        //do while loop
        int count2 = 1;
        do{
          count2++;
          System.out.print(count2 + " ");
        } while(count2<20);
    
        // for loop
        int count3 = 1;
        for( count3 = count3+1; count3 <=20; count3++){
          System.out.print(count3 + " ");
        }
    
        // altered while loop 1
        int count4 = 1;
        while (count4 !=20){
          count4++;
          System.out.print(count4 + " ");
        }
    
        //altered while loop 2
        int count5 = 19;
        while(count5 > 0){
          count5--;
          System.out.print(20-count5 + " ");
        }
      }
}
