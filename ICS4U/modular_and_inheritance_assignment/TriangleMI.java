package modular_and_inheritance_assignment;

public class TriangleMI extends TwoDShape {
    double base;
    double height;
    double side1;
    double side2;

    TriangleMI(){
        this(1.0, 1.0, 1.0, 1.0);
    }
    TriangleMI(double base, double height, double side1, double side2){
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }
    public double area(){
        return(Math.round(((base*height)/2)*100)/100.0);
    }
    public double perimeter(){
        return(Math.round((base+side1+side2)*100)/100.0);
    }
    public void output(){
        System.out.println("The area of your triangle is: " + this.area());
        System.out.println("The perimeter of your triangle is: " + this.perimeter());
    }
}
