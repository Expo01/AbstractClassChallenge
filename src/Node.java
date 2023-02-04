public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    } //really just a getter of next item in list 'rightLink'

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem previous() {   //really just a getter of previous item in list 'leftLink'
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) { //instance of Node will call super class method and compare value to the value of passed parameter of ListItem
        if(item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue()); //cast as string since super class method actually returns Object
                                                                                //and defining as String means we can use the .compareTo inbuilt method
        } else {
            return -1;
        }
    }
}
