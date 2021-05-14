package modular_and_inheritance_assignment;

public class RectangleMI {
    double length;
    private double width;

    RectangleMI(double length, double width){
        this.length = length;
        this.width = width;
    }
    private double area(){
        return(length*width);
    }
    private double perimeter(){
        return(length*2 + width*2);
    }
    public void output(){
        System.out.println("The area for your rectangle is: " + this.area());
        System.out.println("The perimeter for your rectangle is: " + this.perimeter());
    }
}
