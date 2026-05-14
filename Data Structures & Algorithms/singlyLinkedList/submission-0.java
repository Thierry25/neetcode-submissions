class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = this.head;
    }

    public int get(int index) {
        int i = 0;
        Node current = this.head;
        while (current != null) {
            if (index == i) {
                return current.val;
            }
            i++;
            current = current.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        var newNode = new Node(val);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public void insertTail(int val) {
        var newNode = new Node(val);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public boolean remove(int index) {
        if (this.head == null) return false;
        if (index == 0) {
            if (this.head == this.tail) this.tail = null;
            this.head = this.head.next;
            return true;
        }

        int i = 0;
        var current = this.head;
        while (current != null && i < index - 1) {
            i++;
            current = current.next;
        }

        if (current == null || current.next == null) return false;
        if (current.next == this.tail) this.tail = current;
        current.next = current.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        var current = this.head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        return values;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

}
