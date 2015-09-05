public class hw1 {

    public static class PolySeries{
        int degree;
        double coef;
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
            coef = coef_init;
            System.out.println("PolySeries created with coefficient:" + coef + " and degree:" + degree);
        }
        //Given x, return the series
        public double P(double x){
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
        PolySeries seriesError = new PolySeries(-2,8.7);
        double resultError = seriesError.P(3);
    }
}
