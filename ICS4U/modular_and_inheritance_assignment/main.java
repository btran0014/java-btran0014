package modular_and_inheritance_assignment;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("What type of shape do you have? Please type your shape in ALL CAPITAL LETTERS. You can choose from: CIRCLE, TRIANGLE, RECTANGLE, SQUARE");
        String shapeInp = sc.nextLine();

        if (shapeInp.equals("CIRCLE")){
            System.out.print("You chose: CIRCLE." + "\n" + "Please enter the radius of the circle: ");
            double radius = sc.nextDouble();
            CircleMI c1 = new CircleMI (radius);
            c1.output();
        }
        else if(shapeInp.equals("TRIANGLE")){
            System.out.println("You chose: TRIANGLE." + "\n" + "Please enter the base of the triangle: ");
            double base = sc.nextDouble();
            System.out.println("Please enter the height of the triangle: ");
            double height = sc.nextDouble();
            System.out.println("Please enter the first side of the triangle (NOT THE BASE): ");
            double side1 = sc.nextDouble();
            System.out.println("Please enter the second side of the triangle (NOT THE BASE): ");
            double side2 = sc.nextDouble();
            TriangleMI t1 = new TriangleMI (base, height, side1, side2);
            t1.output();
        }
        
    }
}
