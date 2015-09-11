public class hw1{
    public static class PolySeries{
        public int degree;
        public double coef;
        //Instantiate values
        public PolySeries(int degree_init, double coef_init){
            //validate values
            if(degree_init < 0){
                System.out.println("Sorry, degree cannot be negative, exiting...");
                System.exit(1);
            }
            else{
                degree = degree_init;
            }
            // coefficient can be any double
            coef = coef_init;
            System.out.println("PolySeries created with coefficient:" + coef + " and degree:" + degree);
        }
        //Given x, return the series
        public double P(double x){
            System.out.println("PolySeries called as P(" + x + ")");
            //loop through the series
            double result = 0;
            for(int i=0; i<(degree + 1); i++){
                double newResult = result + (coef * Math.pow(x,i));
                System.out.println(result + "  +  " + coef + "*" + x + "^" + i + "=" + newResult);
                result = newResult;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        System.out.println("---");
        PolySeries seriesOne = new PolySeries(3,1);
        double result1 = seriesOne.P(2);
        System.out.println("Result:" + result1);
        PolySeries seriesTwo = new PolySeries(4,-2.1);
        double result2 = seriesTwo.P(4);
        System.out.println("Result:" + result2);
        System.out.println("Addition:");
        System.out.println(result2 + "+" + result1 + "=" + (result1 + result2));
        System.out.println("---");
        System.out.println("And now an error on purpose:");
        PolySeries seriesError = new PolySeries(-2,8.7);
        double resultError = seriesError.P(3);
    }
}

/*TERMINAL OUTPUT
    ---
    PolySeries created with coefficient:1.0 and degree:3
    PolySeries called as P(2.0)
    0.0  +  1.0*2.0^0=1.0
    1.0  +  1.0*2.0^1=3.0
    3.0  +  1.0*2.0^2=7.0
    7.0  +  1.0*2.0^3=15.0
    Result:15.0
    PolySeries created with coefficient:-2.1 and degree:4
    PolySeries called as P(4.0)
    0.0  +  -2.1*4.0^0=-2.1
    -2.1  +  -2.1*4.0^1=-10.5
    -10.5  +  -2.1*4.0^2=-44.1
    -44.1  +  -2.1*4.0^3=-178.5
    -178.5  +  -2.1*4.0^4=-716.1
    Result:-716.1
    Addition:
    -716.1+15.0=-701.1
    ---
    And now an error on purpose:
    Sorry, degree cannot be negative, exiting...
*/

/*
http://rosettacode.org/wiki/Horner's_rule_for_polynomial_evaluation

a_i is an array s.t. a polynomial P(x) can be defined as:
[12, 3, -4, 0, 1, 0, 4]
P(x) = 4x^6 + x^4 - 4x^2 + 3x + 12

The class should take in the array, the degree would be the length of the array, and the coefficients would be the awway values. Each term would be:
    a[i] * x^i

Two polynomials could be added(without giving x values first) by adding the array terms together. There would probably need to be something for arrays of different lengths.
*/

/* PYTHON - Horner's method of adding polynomials
>>> def horner(coeffs, x):
    acc = 0
    for c in reversed(coeffs):
        acc = acc * x + c
    return acc

>>> horner( (-19, 7, -4, 6), 3)
128
*/

/* JAVA - Horner's method of adding polynomials
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Horner {
    public static void main(String[] args){
        List<Double> coeffs = new ArrayList<Double>();
        coeffs.add(-19.0);
        coeffs.add(7.0);
        coeffs.add(-4.0);
        coeffs.add(6.0);
        System.out.println(polyEval(coeffs, 3));
    }

    public static double polyEval(List<Double> coefficients, double x) {
        Collections.reverse(coefficients);
        Double accumulator = coefficients.get(0);
        for (int i = 1; i < coefficients.size(); i++) {
            accumulator = (accumulator * x) + (Double) coefficients.get(i);
        }
        return accumulator;
    }
}
*/
