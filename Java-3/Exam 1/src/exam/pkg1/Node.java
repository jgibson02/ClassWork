package exam.pkg1;

/**
 * Represents a Node in a linked list structure.
 * @author John Gibson
 * @param <D> the type of the data being stored in the Node.
 */
public class Node<D>
{

    private D data;
    private Node link;

    /**
     * Explicit constructor
     */
    public Node()
    {
        data = null;
        link = null;
    }

    /**
     * @param d the data of the Node.
     * @param l the next Node linked to this Node.
     */
    public Node(D d, Node l)
    {
        data = d;
        link = l;
    }

    /**
     * @return the next Node linked to this Node.
     */
    public Node getLink()
    {
        return this.link;
    }

    /**
     * @return the data of this Node.
     */
    public D getData()
    {
        return this.data;
    }

    /**
     * Sets the data of this Node.
     * @param d the data being set to this Node.
     */
    public void setData(D d)
    {
        data = d;
    }

    /**
     * Sets the link of this Node. 
     * @param l the Node being linked to this Node.
     */
    public void setLink(Node l)
    {
        link = l;
    }
}
