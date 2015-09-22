/*
Generate prime numbers from 1 to 100 and store as a list
*/
public class main{
    public static void main(String[] args){
        System.out.println("---");
        System.out.println("Running recitation week 4 program");
        Primes myP = new Primes(100);
        System.out.println(myP.prime_list);
        System.out.println(myP.size());
        System.out.println(myP.contains(17));
        System.out.println(myP.toString());
        System.out.println("---");
    }
}
