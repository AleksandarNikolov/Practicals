package ss.week4;


public class LinkedList<E> {

    private int size;
    private Node first;

    /**
     * @ensures the list is empty
     */
    public LinkedList() {
        size = 0;
        first = null;
    }

    public void add(int index, E element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index - 1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    /**
     * @ensures the size of the list has decreased by one
     * @param element the element to remove
     */
    public void remove(E element) {
    	
    	if (first.getElement() == element) {
    		first = first.next;
    	} else {
	    	Node r = findBefore(element);
	    	r.next = r.next.next;
    	}
    	size--;
    }

    public Node findBefore(E element) {
    	Node p = first;
    	int pos = 0;
    	
    	if (p.getElement() == element) {
    		return null;
    	}
    	
    	while (pos < this.size - 1) {
    		if (p.next.getElement() == element) {
    			return p;
    		}
    		p = p.next;
    		pos++;
    	}
    	return  null;
    }

    /**
     * @requires the index to be within the bounds of the list
     * @param index the index to get the element at 
     * @return the element at index index
     */
    public E get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * @requires i to be within the bounds of the list
     * @param i the index to get the Node at
     * @return the Node at index i
     */
    private Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    /**
     * @ensures the result to be 0 or greater
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    public class Node {
        private E element;
        public Node next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public E getElement() {
            return element;
        }
    }
}
