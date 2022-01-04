package ss.week4;

public class DoublyLinkedList<E> {

    private int size;
    private Node head;

    /**
     * @ensures the list is empty (size is 0)
     */
    public DoublyLinkedList() {
        size = 0;
        this.head = new Node(null);
        this.head.next = null;
        this.head.previous = null;
    }

    /**
     * Inserts a new element at a given index in the list.
     * @requires element is not null
     * @requires the index to be within the bounds of the list
     * @ensures the size of the list to increase by one
     * @ensures the element in the list at index index to be element
     * @param index The index at which to insert the element
     * @param element The element to add
     */
    public void add(int index, E element) {
    	Node newNode = new Node(element);
		Node p = getNode(index - 1);
		
		newNode.next = p.next;
		p.next = newNode;
		newNode.previous = p;
		
		if (newNode.next != null) {
			newNode.next.previous = newNode;
		}
    		
    	this.size++;
    }

    /**
     * Removes an element at a given index.
     * @requires the index to be within the bounds of the list
     * @ensures the size of the list to decrease by one
     * @param index the index to remove the element at 
     */
    public void remove(int index) {
    	Node r = getNode(index);
    	
    	r.previous.next = r.next;
    	r.next.previous = r.previous;
    	r = null;
    	
    	this.size--;
    }

    /**
     * @requires the index to be within the bounds of the list
     */
    public E get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     * @requires i to be between -1 and the size of the list
     */
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(E element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private E element;
        public Node next;
        public Node previous;

        public E getElement() {
            return element;
        }
    }
}
