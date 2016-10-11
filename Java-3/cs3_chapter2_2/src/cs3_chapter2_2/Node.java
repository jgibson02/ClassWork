package cs3_chapter2_2;

public class Node
{
    private Object data;
    private Node link;
    
    public Node() {
        data=null;
        link = null;
    }
    
    public Node(Object e, Node l) 
    {
        data = e;
        link = l;
    }
    
    public Node getLink() {
        return this.link;
    }
    
    public Object getData() {
        return this.data;
    }
    
    public void setLink(Object e) {
        this.link = new Node(e, this);
    }
}