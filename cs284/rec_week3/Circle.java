public class Circle extends Shape{
    private double radius;
    //constructor
    public Circle(String shapeID_init, double radius_init){
        if(radius_init>0){
            radius = radius_init;
            System.out.println("New circle created with radius: " + radius);
        }
        else{
            System.out.println("Radius must be greater than 0");
            System.exit(1);
        }
        shapeID = shapeID_init;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius_new){
        if(radius_new>0){
            radius = radius_new;
            System.out.println("New radius is: " + radius);
        }
        else{
            System.out.println("Radius must be greater than 0");
            System.exit(1);
        }
    }
    public String toString(){
        return ("Circle \"" + shapeID + "\" with radius:" + radius);
    }
    //calculate area
    public double area(){
        //I already have the radius from above
        return (3.14 * Math.pow(radius,2));
    }
}
