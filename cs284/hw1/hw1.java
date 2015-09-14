/*
Josh Gribbon
CS284 - HW1
I pledge my honor I have abided by the Stevens Honor System.

Note: I didn't need to check for a negative degree or anything like that because it's determined by the length of the array. Any values in the array or fine(assuming they're real numbers).
*/
import java.util.Arrays;
public class hw1{
    public static class PolySeries{
        //declare variables
        private int degree;
        private double[] coefs;
        private String series_str;

        //constructor
        public PolySeries(double[] coefs_init){
            coefs = coefs_init;
            //Everything below is just for presentation
            System.out.println("PolySeries created with coefficients:" + Arrays.toString(coefs));
            degree = coefs.length;
            series_str = "P(x)=";
            for(int i=0; i<degree; i++){
                if(coefs[degree-(i+1)] != 0)
                {
                    if(i!=0)
                    {
                        //if the coefficient is zero no need to print out that term
                        series_str = series_str + " + ";
                    }
                    //wanted to reverse the order so it shows the summation starting with the highest degree terms
                    series_str = series_str + coefs[degree-(i+1)] + "*x^" + (degree-(i+1));
                }
            }
            System.out.println(series_str);
        }

        //Given x, return the value of the summation
        public double P(double x){
            System.out.println("PolySeries called as P(" + x + ")");
            double result = 0;
            for(int i=0; i<degree; i++){
                double newResult = result + (coefs[i] * Math.pow(x,i));
                result = newResult;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println("---");

        //Polynomial 1
        double[] input1 = {5.4, 7, 11.1, -17, 1.3};
        PolySeries series1 = new PolySeries(input1);
        System.out.println("Result:" + series1.P(2));

        System.out.println();

        //Polynomial 2
        double[] input2 = {0, 0, 4, 6.7, -1.2};
        PolySeries series2 = new PolySeries(input2);
        System.out.println("Result:" + series2.P(4));

        System.out.println();

        //Adding the polynomials
        double seriesAdded = series1.P(2) + series2.P(4);
        System.out.println("Sum: " + seriesAdded);

        System.out.println("---");
    }
}
/* TERMINAL OUTPUT
---
PolySeries created with coefficients:[5.4, 7.0, 11.1, -17.0, 1.3]
P(x)=1.3*x^4 + -17.0*x^3 + 11.1*x^2 + 7.0*x^1 + 5.4*x^0
PolySeries called as P(2.0)
Result:-51.400000000000006

PolySeries created with coefficients:[0.0, 0.0, 4.0, 6.7, -1.2]
P(x)=-1.2*x^4 + 6.7*x^3 + 4.0*x^2
PolySeries called as P(4.0)
Result:185.60000000000002

PolySeries called as P(2.0)
PolySeries called as P(4.0)
Sum: 134.20000000000002
---
*/
