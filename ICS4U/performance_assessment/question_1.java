package performance_assessment;

public class question_1 {
    public static int fibonacci (int term){
        if(term == 1 || term ==2){
            return 1;
        } else {
            return fibonacci(term-1)+fibonacci(term-2);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i<20; i++)  
            System.out.print(fibonacci(i));
    
    }
}


