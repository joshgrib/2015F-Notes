import java.util.ArrayList;
import java.util.List;
public class JArchive{
    private List<ListNode> theList;
    private int idCount;

    public JArchive(){
        this.idCount = 0;
        this.theList = new ArrayList<ListNode>();
    }

    public void add(ErrorItem e){
        try{
            ListNode node = new ListNode(e, idCount);
            theList.add(node);
            this.idCount++;
        }
        catch(NullPointerException err){
            System.out.println("Found a null pointer exception!");
        }
    }

    private class ListNode{
        int ID;
        String data;
        private ListNode(ErrorItem e, int UID){
            this.data = e.toString();
            this.ID = UID;
        }
    }
}
