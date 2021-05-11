package java_oop_practice_questions;

public class Circle {
    double radius = 10.0;
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
        System.out.println(this.diameter());
        System.out.println(this.circumference());
        System.out.println(this.area());
    }
}
