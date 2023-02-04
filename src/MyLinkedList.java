public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // The list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root; //compares head of LinkedList to newItem
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                // newItem is greater, move right if possible. goal is to have lesser to greater progression in the list
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next, so insert at end of list
                    currentItem.setNext(newItem).setPrevious(currentItem); // currentItem is less than newItem, so we set next
                    // as newItem, then set currentItem as previous to newItem so they are both linked to each other, both pointing
                    // to each other via next and previous. Just doing this all in one statement which was confusing
                    // but it works beecause the setNext method returns a ListItem
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is less, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous()); //the item before
                    //currentItem (lets call this item 'a') points to newItem as being 'next'. then newItem points back to
                    // item 'a' as being previous through currentItem.previous
                    newItem.setNext(currentItem).setPrevious(newItem); // then currentItem and newItem point to each other
                } else {
                    // the node without a previous is the root
                    newItem.setNext(this.root).setPrevious(newItem); //makes the newItem point right and root point left
                    this.root = newItem; //then redefines the root as the value of newItem since its less than prior root
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root; //sets currentItem to head of list
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // found the item to delete
                if (currentItem == this.root) { //if, during the while loop, currentItem equals item (the item we want to
                    // delete is th head), we assign the next item in the list as the new heead of the list using .next
                    this.root = currentItem.next(); // new head created
                } else { //if the item to be removed is not the head, the previous item points to the next item (a>b>c) now (a>c)
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) { //if a 'c' exists, then c points to a
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) { // if, during the while loop, the current item does not match the passed 'item'
                // the currentItem seet to the next item in the list. CurrentItem which initially was the head, loops
                // through and is defined as each item in the list to test for matching value
                currentItem = currentItem.next();
            } else { // comparison > 0
                // We are at an item greater than the one to be deleted
                // so the item is not in the list since we started at the head so item was never found
                return false;
            }
        }

        // We have reached the end of the list
        // Without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
