package modular_and_inheritance_assignment;

public class TriangleMI {
    double base;
    double height;
    double side1;
    double side2;

    TriangleMI(double base, double height, double side1, double side2){
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }
    public double area(){
        return((base*height)/2);
    }
    public double perimeter(){
        return(base+side1+side2);
    }
    public void output(){
        System.out.println("The area of your triangle is: " + this.area());
        System.out.println("The perimeter of your triangle is: " + this.perimeter());
    }
}
