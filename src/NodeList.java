public interface NodeList {
    ListItem getRoot(); //all Lists must have a starting node, in case of LinkedList we call this the head but can also
    //use the term 'root'
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
