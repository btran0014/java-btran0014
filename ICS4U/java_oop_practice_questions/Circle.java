package java_oop_practice_questions;

public class Circle {
    double radius;
    final double PI = 3.14159;
    Circle(double radius){
        this.radius = radius;
    }
    public double diameter(){
        return(radius*2);
    }
    public double circumference(){
        return(2*PI*radius);
    }
    public double area(){
        return(PI*radius*radius);
    }
    public void output(){
        System.out.println("Radius: " + radius + " Diameter: " +  this.diameter());
        System.out.println("Circumference: " + Math.round(this.circumference()*100)/100.0);
        System.out.println("Area: " + Math.round(this.area()*100)/100.0);
    }
}
