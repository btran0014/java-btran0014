package modular_and_inheritance_assignment;

public class RectangleMI extends TwoDShape{
    double length;
    private double width;

    RectangleMI(){
        this(1.0, 1.0);
    }

    RectangleMI(double length, double width){
        this.length = length;
        this.width = width;
    }
    double area(){
        return(Math.round((length*width)*100)/100.0);
    }
    double perimeter(){
        return(Math.round((length*2 + width*2)*100)/100.0);
    }
    public void output(){
        System.out.println("The area for your rectangle is: " + this.area());
        System.out.println("The perimeter for your rectangle is: " + this.perimeter());
    }
}
