package modular_and_inheritance_assignment;

public class CircleMI extends TwoDShape{
    double radius;
    final double PI = Math.PI;

    CircleMI(){
        this(1.0);
    }

    CircleMI(double radius){
        this.radius = radius;
    }
    public double area(){
        return(Math.round((PI*radius*radius)*100)/100.0);
    }
    public double perimeter(){
        return(Math.round((2*PI*radius)*100)/100.0);
    }
    public void output(){
        System.out.println("The area of your circle is: " + this.area());
        System.out.println("The circumference of your circle is: " + this.perimeter());
    }
}
