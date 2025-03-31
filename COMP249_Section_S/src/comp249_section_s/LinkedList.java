package comp249_section_s;

// Define class LinkedList
// head, add, remove, display
public class LinkedList {

    private Node head;
    private Node tail; // Optional: improves performance if we add to tail often
    private int numberOfElements; // Optional, improves performance when getting the size

    public LinkedList() {
        head = null;
        tail = null;
    }

    // Add
    // addToHead
    public void addToHead(String data) {
        Node n = new Node(data, head);

        if (head == null) { // if first element, update tail
            tail = n;
        }

        head = n;

        numberOfElements++;
    }

    // addToTail
    public void addToTail(String data) {
        if (head == null) {
            addToHead(data);
        } else {

            Node n = new Node(data, null);
            tail.setLink(n); // The order of this and following statement is VERY important
            tail = n;
            numberOfElements++;
        }
    }

    // addAfter (addBefore)
    // Remove
    // removeHead
    public String removeHead() {

        if (head == null) {
            return null; // Probably throw an exception
        } else {
            String data = head.getData();

            head = head.getLink();
            numberOfElements--;

            if (numberOfElements == 0) { // Take care of tail if the removed element was the head and tail
                tail = null;
            }

            return data;
        }
    }

    // removeTail
    public String removeTail() {
        if (numberOfElements == 1) {
            return removeHead();
        } else {
            Node position = head;
            while (position.getLink() != tail) {
                position = position.getLink();
            }
            String data = tail.getData();
            position.setLink(null);
            tail = position;
            numberOfElements--;
            return data;
        }
    }

    // removeValue
    public String removeValue(String value) {
        if (head == null) {
            return null;
        }
        if (head.getData().equals(value)) {
            return removeHead();
        } else if (tail.getData().equals(value)) {
            return removeTail();
        } else {
            Node position = head;
            while (position != null && !position.getLink().getData().equals(value)) {
                position = position.getLink();
            }
            if (position == null) {
                return null;
            } else {
                String data = position.getLink().getData();
                position.setLink(position.getLink().getLink());
                numberOfElements--;
                return data;
            }
        }
    }

    // removeAfter (remove before)
        public String removeAfter(String value) {
            if (head == tail) {
                return null;
            }
            else {
                Node position = head;
                while (position != tail && !position.data.equals(value)) {
                    position = position.link;
                }
                if (position.link == null) {
                        System.out.println("Value" + value + "does not exist in the list.");
                        return null;
                    } else if (position == tail) {
                    System.out.println("There is no value after " + tail);
                } else {
                    String data = position.link.data;
                    // Check if the removed value was on tail
                    if (position.link == tail) {
                        tail = position;
                    }
                            
                    position.link = position.link.link;
                    numberOfElements--;
                    return data;
                }
            }
    }
    
    // contains: Check if a specific data (value) exists in the list
    // display (go through all elements and display each one)
    public void display() {
        if (head == null) {
            System.out.println("This list has no element.");
        } else {
            Node position = head;
            while (position != null) {
                // display element
                System.out.println(position);
                position = position.getLink();
            }
        }
    }

    // getSize (how many elements in the list)
    public int getSize() {
        return numberOfElements;
    }
}
