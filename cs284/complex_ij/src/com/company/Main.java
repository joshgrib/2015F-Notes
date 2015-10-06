package com.company;

public class Main {
    /*Abstract class of complex numbers
     * @symbol BT          The base type
     * @symbol OT          The other type
     */
    public static abstract class Complex<BT,OT>{
        public abstract String toString();
        public abstract BT plus(OT x);
        public abstract BT minus(OT x);
        public abstract BT times(OT x);
    }


    /**Complex number in cartesian form : (real, imaginary)*/
    public static class ComplexCart extends Complex<ComplexCart,ComplexPolar>{
        /** The real part of the complex number*/
        private double r;
        /**The imaginary part of the complex number*/
        private double i;

        /**Constructor
         * @param real      The real part of the complex number
         * @param im        The imaginary part of the complex number
         */
        public ComplexCart(double real, double im){
            this.r = real;
            this.i = im;
            //System.out.println("New cartesian complex number: (" + r + ", " + i + ")");
        }

        /**Getter for r
         * @return          The real part of the complex number
         */
        public double r() {
            return this.r;
        }

        /**Getter for i
         * @return          The imaginary part of the complex number
         */
        public double i() {
            return this.i;
        }

        /**Setter for r
         * @param real      The real part of the complex number to be set
         */
        public void setR(double real) {
            this.r = real;
        }

        /**Setter for i
         * @param im        The imaginary part of the complex number to be set
         */
        public void setI(double im) {
            this.i = im;
        }

        /**Method to add two complex numbers in cartesian form
         * @param b         A complex number in cartesian form
         * @return          The complex number representing the sum
         */
        public ComplexCart plus(ComplexCart b){
            //adding two cartesian complex numbers
            ComplexCart a = this;
            double real = a.r + b.r;
            double imag = a.i + b.i;
            return new ComplexCart(real, imag);
        }

        /**Method to add a complex number in polar form to one in cartesian form
         * @param b         A complex number in polar form
         * @return          The complex number representing the sum
         */
        public ComplexCart plus(ComplexPolar b){
            ComplexCart a = this;
            ComplexCart c = b.toCart();
            return a.plus(c);
        }

        /**Method to subtract two complex numbers in cartesian form
         * @param b         A complex number in cartesian form
         * @return          The complex number representing the difference
         */
        public ComplexCart minus(ComplexCart b){
            ComplexCart a = this;
            double real = a.r - b.r;
            double imag = a.i - b.i;
            return new ComplexCart(real, imag);
        }

        /**Method to subtract a complex number in polar form from one in cartesian form
         * @param b         A complex number in polar form
         * @return          The complex number representing the difference
         */
        public ComplexCart minus(ComplexPolar b){
            ComplexCart a = this;
            ComplexCart c = b.toCart();
            return a.plus(c);
        }

        /**Method to multiply two complex numbers in cartesian form
         * @param b         A complex number in cartesian form
         * @return          The complex number representing the product
         */
        public ComplexCart times(ComplexCart b) {
            //multiplies two cartesian complex numbers
            ComplexCart a = this;
            double real = a.r * b.r - a.i * b.i;
            double imag = a.r * b.i + a.i * b.r;
            return new ComplexCart(real, imag);
        }

        /**Method to multiply a complex number in polar form by one in cartesian form
         * @param b         A complex number in polar form
         * @return          The complex number representing the product
         */
        public ComplexCart times(ComplexPolar b) {
            //multiples a cartesian complex number by a polar one
            ComplexCart a = this;
            ComplexCart c = b.toCart();
            return a.times(c);
        }

        /**Method to convert the complex number in cartesian form into polar form
         * @return          The converted complex number now in polar form
         */
        public ComplexPolar toPolar(){
            double r_p = Math.sqrt( (r * r) + (i * i) );
            double a = Math.tan(r / i);
            return new ComplexPolar(r_p, a);
        }

        /**The toString method
         * @return            The string representation of the complex number
         */
        public String toString(){
            return "Cartesian complex number: (" + r + ", " + i + ")";
        }
    }


    /**Complex number in polar form : (radius, angle)*/
    public static class ComplexPolar extends Complex<ComplexPolar,ComplexCart>{
        /** The radius of the complex number*/
        private double r;
        /**The angle of the complex number, in radians*/
        private double a;

        /**Constructor
         * @param radius    The radius of the complex number
         * @param angle     The angle of the complex number, in radians
         */
        public ComplexPolar(double radius, double angle){
            this.r = radius;
            this.a = angle;
            //System.out.println("New polar complex number: (" + r + ", " + a + ")");
        }

        /**Getter for r
         * @return          The radius of the complex number
         */
        public double r() {
            return this.r;
        }

        /**Getter for a
         * @return          The angle of the complex number
         */
        public double a() {
            return this.a;
        }

        /**Setter for r
         * @param radius      The radius of the complex number to be set
         */
        public void setR(double radius){
            this.r = radius;
        }

        /**Setter for a
         * @param angle       The angle of the complex number to be set
         */
        public void setA(double angle){
            this.a = angle;
        }

        /**Method to add two complex numbers in polar form
         * @param b         A complex number in polar form
         * @return          The complex number representing the sum
         */
        public ComplexPolar plus(ComplexPolar b){
            ComplexPolar f = this; //has to be f because a is the angle
            ComplexCart c = f.toCart();
            ComplexCart d = b.toCart();
            ComplexCart e = c.plus(d);
            return e.toPolar();
        }

        /**Method to add a complex number in cartesian form to one in polar form
         * @param b         A complex number in cartesian form
         * @return          The complex number representing the sum
         */
        public ComplexPolar plus(ComplexCart b){
            ComplexPolar a = this;
            ComplexPolar c = b.toPolar();
            return a.plus(c);
        }

        /**Method to subtract two complex numbers in polar form
         * @param b         A complex number in polar form
         * @return          The complex number representing the difference
         */
        public ComplexPolar minus(ComplexPolar b){
            ComplexPolar f = this;
            ComplexCart c = f.toCart();
            ComplexCart d = b.toCart();
            ComplexCart e = c.minus(d);
            return e.toPolar();
        }

        /**Method to subtract a complex number in cartesian form from one in polar form
         * @param b         A complex number in cartesian form
         * @return          The complex number representing the difference
         */
        public ComplexPolar minus(ComplexCart b){
            ComplexPolar a = this;
            ComplexPolar c = b.toPolar();
            return a.minus(c);
        }

        /**Method to multiply two complex numbers in polar form
         * @param b         A complex number in polar form
         * @return          The complex number representing the product
         */
        public ComplexPolar times(ComplexPolar b){
            ComplexPolar f = this;
            ComplexCart c = f.toCart();
            ComplexCart d = b.toCart();
            ComplexCart e = c.times(d);
            return e.toPolar();
        }

        /**Method to multiply a complex number in cartesian form by one in polar form
         * @param b         A complex number in cartesian form
         * @return          The complex number representing the product
         */
        public ComplexPolar times(ComplexCart b){
            ComplexPolar a = this;
            ComplexPolar c = b.toPolar();
            return a.times(c);
        }

        /**Method to convert the complex number in polar form into cartesian form
         * @return          The converted complex number now in cartesian form
         */
        public ComplexCart toCart(){
            double r_c = r * Math.cos(a);
            double i = r * Math.sin(a);
            return new ComplexCart(r_c, i);
        }

        /**The toString method
         * @return            The string representation of the complex number
         */
        public String toString(){
            return "Polar complex number: (" + r + ", " + a + ")";
        }
    }


    /**Main method - used for testing*/
    public static void main(String[] args) {
        ComplexCart a = new ComplexCart(3.0, -4.0);
        ComplexCart b = new ComplexCart(-4.0, 3.0);
        ComplexPolar c = new ComplexPolar(5.0, 3.0);
        ComplexPolar d = new ComplexPolar(5.0, 4.0);
        System.out.println( "--------------Testing  plus--------------" );
        System.out.println( "Cart + cart    :   " + a.plus(b) );
        System.out.println( "Cart + polar   :   " + a.plus(c) );
        System.out.println( "Polar + cart   :   " + c.plus(a) );
        System.out.println( "Polar + polar  :   " + c.plus(d) );
        System.out.println( "--------------Testing minus--------------" );
        System.out.println( "Cart - cart    :   " + a.minus(b) );
        System.out.println( "Cart - polar   :   " + a.minus(c) );
        System.out.println( "Polar - cart   :   " + c.minus(a) );
        System.out.println( "Polar - polar  :   " + c.minus(d) );
        System.out.println( "--------------Testing times--------------" );
        System.out.println( "Cart * cart    :   " + a.times(b) );
        System.out.println( "Cart * polar   :   " + a.times(c) );
        System.out.println( "Polar * cart   :   " + c.times(a) );
        System.out.println( "Polar * polar  :   " + c.times(d) );
        System.out.println( "-----------Testing  conversion-----------" );
        System.out.println( "Cart --> polar :   " + a.toPolar() );
        System.out.println( "Polar --> cart :   " + c.toCart() );
        System.out.println( "---------Testing  getters/setters--------" );
        a.setI(1);
        a.setR(2);
        System.out.println( "New I: " + a.i() + ", new R: " + a.r());
        c.setA(3);
        c.setR(4);
        System.out.println( "New A: " + c.a() + ", new R: " + c.r());
        /* PRINTOUT
            --------------Testing  plus--------------
            Cart + cart    :   Cartesian complex number: (-1.0, -1.0)
            Cart + polar   :   Cartesian complex number: (-1.9499624830022269, -3.294399959700664)
            Polar + cart   :   Polar complex number: (3.848099454335094, 0.6765444990121996)
            Polar + polar  :   Polar complex number: (8.775825618903728, -0.5104544766167629)
            --------------Testing minus--------------
            Cart - cart    :   Cartesian complex number: (7.0, -7.0)
            Cart - polar   :   Cartesian complex number: (-1.9499624830022269, -3.294399959700664)
            Polar - cart   :   Polar complex number: (9.229958320032974, 9.020078088116755)
            Polar - polar  :   Polar complex number: (4.79425538604203, -0.3931480924056103)
            --------------Testing times--------------
            Cart * cart    :   Cartesian complex number: (0.0, 25.0)
            Cart * polar   :   Cartesian complex number: (-12.027487287809336, 21.916650052906917)
            Polar * cart   :   Polar complex number: (24.999999999999996, -0.6037873099523913)
            Polar * polar  :   Polar complex number: (25.0, 2.219689112726943)
            -----------Testing  conversion-----------
            Cart --> polar :   Polar complex number: (5.0, -0.9315964599440725)
            Polar --> cart :   Cartesian complex number: (-4.949962483002227, 0.7056000402993361)
        */
    }
}
