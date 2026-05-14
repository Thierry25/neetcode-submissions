class DynamicArray {
    private int[] myDynamicArray;
    private int size;

    public DynamicArray(int capacity) {
        if (capacity > 0) {
            myDynamicArray = new int[capacity];
            size = 0;
        }
    }

    public int get(int i) {
        return myDynamicArray[i];
    }

    public void set(int i, int n) {
        myDynamicArray[i] = n;
    }

    public void pushback(int n) {
        if (size == myDynamicArray.length) {
            resize();
        }
        myDynamicArray[size] = n;
        size++;
    }

    public int popback() {
        var element = myDynamicArray[size - 1];
        size--;
        return element;
    }

    public void resize() {
        int[] newArray = new int[myDynamicArray.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = myDynamicArray[i];

        }
        myDynamicArray = newArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return myDynamicArray.length;
    }
}
