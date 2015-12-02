public class ErrorItem{
    String user = null;
    String host = null;
    String problem = null;
    int priority = -1;

    public ErrorItem(String u, String h, String pro, String pri){
        this.user = u;
        this.host = h;
        this.problem = pro;
        int x = Integer.parseInt(pri);
        this.priority = x;
    }

    public String user(){
        return this.user;
    }
    public String host(){
        return this.host;
    }
    public String problem(){
        return this.problem;
    }
    public int priority(){
        return this.priority;
    }
}
