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

    public List<Pair> mergeSort(List<Pair> pairs, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            mergeSort(pairs, startIndex, middleIndex);
            mergeSort(pairs, middleIndex + 1, endIndex);

            merge(pairs, startIndex, middleIndex, endIndex);
        }
        return pairs;
    }

    public void merge(List<Pair> pairs, int startIndex, int middleIndex, int endIndex) {
        int leftListLength = middleIndex - startIndex + 1;
        int rightListLength = endIndex - middleIndex;

        List<Pair> tempLeftList = new ArrayList<>();
        List<Pair> tempRightList = new ArrayList<>();

        for (int i = 0; i < leftListLength; i++) {
            tempLeftList.add(pairs.get(i + startIndex));
        }

        for (int j = 0; j < rightListLength; j++) {
            tempRightList.add(pairs.get(middleIndex + 1 + j));
        }

        int leftArrPointer = 0;
        int rightArrPointer = 0;
        int mergedArrPointer = startIndex;

        while (leftArrPointer < leftListLength && rightArrPointer < rightListLength) {
            if (tempLeftList.get(leftArrPointer).key <= tempRightList.get(rightArrPointer).key) {
                pairs.set(mergedArrPointer, tempLeftList.get(leftArrPointer));
                leftArrPointer++;
            } else {
                pairs.set(mergedArrPointer, tempRightList.get(rightArrPointer));
                rightArrPointer++;
            }
            mergedArrPointer++;
        }

        while (leftArrPointer < leftListLength) {
            pairs.set(mergedArrPointer, tempLeftList.get(leftArrPointer));
            leftArrPointer++;
            mergedArrPointer++;
        }

        while (rightArrPointer < rightListLength) {
            pairs.set(mergedArrPointer, tempRightList.get(rightArrPointer));
            rightArrPointer++;
            mergedArrPointer++;
        }
    }
}
