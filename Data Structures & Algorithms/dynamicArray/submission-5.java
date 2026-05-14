class DynamicArray {

    private int[] arr;
    private int length;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 16;
    
    public DynamicArray(int capacity) {
        int size = capacity > 0 ? capacity : DEFAULT_CAPACITY;
        this.capacity = size;
        this.length = 0;
        this.arr = new int[size];
    }

    public int get(int i) {
        if (i < 0 || i > this.length) return -1;
        return this.arr[i];
    }

    public void set(int i, int n) {
        if (i < 0 || i > this.length) return;

        this.arr[i] = n;
    }

    public void pushback(int n) {
        if (this.length == this.capacity) 
            resize();

        this.arr[this.length] = n;
        this.length++;
    }

    public int popback() {
        if (length > 0) {
            // soft delete the last element
            length--;
        }
        return arr[length];
    }

    private void resize() {
       this.capacity *= 2;
       int[] newArr = new int[capacity];
       for (int i = 0; i < this.length; i++) {
        newArr[i] = arr[i];
       }
       arr = newArr;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
