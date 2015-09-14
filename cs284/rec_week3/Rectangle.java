public class Rectangle extends Shape{
    private double width;
    private double height;
    //constructor
    public Rectangle(String shapeID_init, double width_init, double height_init){
        if((width_init>0)&&(height_init>0)){
            shapeID = shapeID_init;
            width = width_init;
            height = height_init;
            System.out.println("Rectangle \"" + shapeID + "\" created with width:" + width + " and height:" + height);
        }
        else{
            System.out.println("Height and width must be greater than 0");
            System.exit(1);
        }
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public void setWidth(double width_init){
        if(width_init>0){
            width = width_init;
            System.out.println("New width is: " + width);
        }
        else{
            System.out.println("Width must be greater than 0");
            System.exit(1);
        }
    }
    public void setHeight(double height_init){
        if(height_init>0){
            height = height_init;
            System.out.println("New height is: " + height);
        }
        else{
            System.out.println("Height must be greater than 0");
            System.exit(1);
        }
    }
    public String toString(){
        return ("Rectangle \"" + shapeID + "\" with width:" + width + " and height:" + height);
    }
    //calculate area
    public double area(){
        //I already have the radius from above
        return (width*height);
    }
};
