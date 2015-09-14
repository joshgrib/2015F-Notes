public class week3_main{
    public static void main(String[] args){
        Circle myCircle = new Circle("c1", 4);
        myCircle.setRadius(5);
        System.out.println(myCircle.toString());

        Rectangle myRect = new Rectangle("r1", 3, 4);
        myRect.setWidth(6);
        myRect.setHeight(8);
        System.out.println(myRect.toString());
        System.out.println("Area:" + myRect.area());
    }
}
