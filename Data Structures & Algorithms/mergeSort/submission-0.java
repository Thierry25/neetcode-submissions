// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs == null || pairs.size() <= 1) return pairs;
        return mergeSort(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeSort(List<Pair> pairs, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(pairs, left, middle);
            mergeSort(pairs, middle + 1, right);
            merge(pairs, left, middle, right);
        }
        return pairs;
    }

    public void merge(List<Pair> pairs, int left, int middle, int right) {
        int leftListLength = middle - left + 1;
        int rightListLength = right - middle;

        // Create temp arrays here
        List<Pair> leftArr = new ArrayList<>();
        List<Pair> rightArr = new ArrayList<>();

        for (int i = 0; i < leftListLength; i++) {
            leftArr.add(pairs.get(i + left));
        }

        for (int j = 0; j < rightListLength; j++) {
            rightArr.add(pairs.get(middle + 1 + j));
        }

        int i = 0; // pointer for left array
        int j = 0; // pointer for right array
        int k = left; // pointer for final merged array

        while (i < leftListLength && j < rightListLength) {
            if (leftArr.get(i).key <= rightArr.get(j).key) {
                pairs.set(k, leftArr.get(i));
                i++;
            } else {
                pairs.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }

        // remaining left array items if any
        while (i < leftListLength) {
            pairs.set(k, leftArr.get(i));
            i++;
            k++;
        }

        while (j < rightListLength) {
            pairs.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }
}
