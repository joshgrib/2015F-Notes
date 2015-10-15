public class toh{
    public static void run(String from, String using, String to, int n){
        if(n>0){
            run(from, to, using, n-1);
            System.out.println(from + "-->" + to);
            run(using, from , to, n-1);
        }
    }
    public static void main(String[] args) {
        run("1", "2", "3", 3);
    }
}
