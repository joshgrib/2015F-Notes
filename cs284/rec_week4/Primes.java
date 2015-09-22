import java.util.ArrayList;
public class Primes{
    public ArrayList<Integer> prime_list;
    //constructor
    public Primes(int max)
    {
        this.prime_list = new ArrayList<Integer>();
        for(int i=2; i<=max; i++){
            if(isPrime(i)){
                prime_list.add(i);
            }
        }
        System.out.println("Primes \"" + "\" created with max:" + max);
    }
    private boolean isPrime(int n){
        for(int i=2; i<n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public boolean contains(int n){
        if(prime_list.indexOf(n) != -1){
            return true;
        }
        return false;
    }
    public int size(){
        return prime_list.size();
    }
    public String toString(){
        return ("Primes: \"" + prime_list);
    }
};
