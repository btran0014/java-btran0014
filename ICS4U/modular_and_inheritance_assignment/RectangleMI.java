package modular_and_inheritance_assignment;

public class RectangleMI {
    double length;
    private double width;

    RectangleMI(){
        length = 1.0;
        width = 1.0;
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
