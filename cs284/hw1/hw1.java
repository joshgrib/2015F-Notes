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
