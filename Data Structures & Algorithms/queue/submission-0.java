class Deque {
    Node head;
    Node tail;

    public Deque() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void append(int value) {
       var newNode = new Node(value);
       if (head == null) {
        this.head = newNode;
        this.tail = newNode;
       } else {
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
       }
    }

    public void appendleft(int value) {
        var newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
    }

    public int pop() {
        if (this.tail == null) return -1;
        
        var value = this.tail.val;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        return value;
    }

    public int popleft() {
        if (this.head == null) return -1;

        var value = this.head.val;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        return value;
    }
}

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
