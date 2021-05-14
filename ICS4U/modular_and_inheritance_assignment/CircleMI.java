package modular_and_inheritance_assignment;

public class CircleMI {
    double radius;
    final double PI = Math.PI;

    CircleMI(double radius){
        this.radius = radius;
    }
    public double area(){
        return((PI*radius*radius)*100/100.0);
    }
    public double circumference(){
        return((2*PI*radius)*100/100.0);
    }
    public void output(){
        System.out.println("The area of your circle is: " + this.area());
        System.out.println("The circumference of your circle is: " + this.circumference());
    }
}
