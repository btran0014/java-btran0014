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
            System.out.print("Please enter the radius of the second circle: ");
            radius = sc.nextDouble();
            CircleMI c2 = new CircleMI (radius);
            c2.output();
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
            System.out.println( "Please enter the base of the second triangle: ");
            base = sc.nextDouble();
            System.out.println("Please enter the height of the second triangle: ");
            height = sc.nextDouble();
            System.out.println("Please enter the first side of the second triangle (NOT THE BASE): ");
            side1 = sc.nextDouble();
            System.out.println("Please enter the second side of the secon triangle (NOT THE BASE): ");
            side2 = sc.nextDouble();
            TriangleMI t2 = new TriangleMI (base, height, side1, side2);
            t2.output();
        }
        else if(shapeInp.equals("RECTANGLE")){
            System.out.println("You chose: RECTANGLE." + "\n" + "Please enter the length of the rectangle.");
            double length = sc.nextDouble();
            System.out.println("Please enter the width of the rectangle");
            double width = sc.nextDouble();
            RectangleMI r1 = new RectangleMI (length, width);
            r1.output();
            System.out.println("Please enter the length of the second rectangle.");
            length = sc.nextDouble();
            System.out.println("Please enter the width of the second rectangle");
            width = sc.nextDouble();
            RectangleMI r2 = new RectangleMI (length, width);
            r2.output();
        }
        else if(shapeInp.equals("SQUARE")){
            System.out.println("You chose: SQUARE." + "\n" + "Please enter the side length of the square.");
            double sidelength = sc.nextDouble();
            SquareMI s1 = new SquareMI (sidelength);
            s1.output();
            System.out.println("Please enter the side length of the second square.");
            sidelength = sc.nextDouble();
            SquareMI s2 = new SquareMI (sidelength);
            s2.output();
        }
        
    }
}