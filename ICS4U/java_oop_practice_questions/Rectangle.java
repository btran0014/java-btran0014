package java_oop_practice_questions;

public class Rectangle {
    double length = 10.0;
    double width = 10.0;

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public double area(){
        return(length*width);
    }
    public double perimeter(){
        return(length*2 + width*2);
    }
    public double diagonal(){
        return (Math.sqrt((length*length) + (width*width)));
    }
    public void output(){
        System.out.println(this.area());
        System.out.println(this.perimeter());
        System.out.println(this.diagonal());
    }    
}

