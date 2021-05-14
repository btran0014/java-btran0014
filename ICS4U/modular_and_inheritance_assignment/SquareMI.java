package modular_and_inheritance_assignment;

public class SquareMI extends RectangleMI {
    SquareMI(){
        length = 1.0;
    }
    SquareMI(double length){
        this.length = length;
    }
    double area(){
        return(Math.round((length*length)*100)/100.0);
    }
    double perimeter(){
        return(Math.round((length*4)*100)/100.0);
    }
    public void output(){
        System.out.println("The area for your square is: " + this.area());
        System.out.println("The perimeter for your square is: " + this.perimeter());
    }
}
