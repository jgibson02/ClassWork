package sortable1;

import java.util.ArrayList;

/**
 * A list of network users in alphabetical order by login name.
 * 
 * @author John Gibson
 */
public class SortedListOfNetworkUsers {
    private ArrayList<NetworkUser> list;
    
    /**
     * Creates an empty list.
     */
    public SortedListOfNetworkUsers() {
        list = new ArrayList<>();
    }
    
    /**
     * Returns the number of network users in this list.
     */
    public int size() {
        return list.size();
    }
    
    /**
     * Returns a network user at a given index.
     * @param i the index of the network user to return
     */
    public NetworkUser get(int i)  {
        return list.get(i);
    }
    
    /**
     * Adds a network user to the list in its proper position.
     * @param user 
     */
    public void add(NetworkUser user) {
        int size = list.size();
        boolean found = false;
        int i = 0;
        String t = user.getLogin();
        while (i < size && !found) {
            String s = list.get(i).getLogin();
            if(s.compareToIgnoreCase(t) >= 0) {
                found = true;
            } else {
                i++;
            }
        }
        list.add(i, user);
    }
    
    public static void main(String[] args) {
        SortedListOfNetworkUsers list = new SortedListOfNetworkUsers();
        NetworkUser u1 = new NetworkUser("Walrus", "wk5tg");
        NetworkUser u2 = new NetworkUser("JohnCena", "!cme");
        NetworkUser u3 = new NetworkUser("zabazak", "ytgj6j");
        NetworkUser u4 = new NetworkUser("holdit", "jrt98");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        
        for (int i = 0; i < 4; i++) {
            System.out.println(list.get(i));
        }
    }
}
