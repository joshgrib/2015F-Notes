/*
    Josh Gribbon
    CS284 - EC1
    I pledge my honor I have abided by the Stevens Honor System.
*/
/*
    Assignment:
    Create a class to represent complex numbers
*/
public class Complex{
    //declare variables
    private double r; // real
    private double i; // imaginary

    //methods
    public Complex (double real, double im){
        r = real;
        i = im;
        //System.out.println("New complex number created");
    }

    public String toString(){
        return "Complex number: ( " + r + ", " + i + ")";
    }

    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        double real = a.r + b.r;
        double imag = a.i + b.i;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.r - b.r;
        double imag = a.i - b.i;
        return new Complex(real, imag);
    }

    public Complex times(Complex b) {
        Complex a = this;
        double real = a.r * b.r - a.i * b.i;
        double imag = a.r * b.i + a.i * b.r;
        return new Complex(real, imag);
    }

    public double r() {
        return r;
    }

    public double i() {
        return i;
    }

    public void setR(double real) {
        r = real;
    }

    public void setI(double im) {
        i = im;
    }

    public static Complex plus(Complex a, Complex b) {
        double real = a.r + b.r;
        double imag = a.i + b.i;
        Complex sum = new Complex(real, imag);
        return sum;
    }

    public double polarR() {
        //returns the radius of the polar version of the complex number
        return Math.sqrt( (r * r) + (i * i) ); //the hypotenuse
    }

    public double polarA() {
        //returns the angle of the polar version of the complex number in radians
        return Math.tan(r / i);
    }

    public String polarToString() {
        //returns the polar string of the complex number as (radius, angle)
        return "Polar complex number (" + polarR() + " ," + polarA() + " )";
    }

    public static void main(String[] args) {
        Complex a = new Complex(5.0, 6.0);
        Complex b = new Complex(-3.0, 4.0);

        System.out.println("a            = " + a               );
        System.out.println("b            = " + b               );
        System.out.println("R(a)         = " + a.r()           );
        System.out.println("I(a)         = " + a.i()           );
        System.out.println("b + a        = " + b.plus(a)       );
        System.out.println("a - b        = " + a.minus(b)      );
        System.out.println("a * b        = " + a.times(b)      );
        System.out.println("b * a        = " + b.times(a)      );
        System.out.println("Polar radius = " + a.polarR()       );
        System.out.println("Polar angle  = " + a.polarA()       );
        System.out.println("Polar string = " + a.polarToString());
    }
}
