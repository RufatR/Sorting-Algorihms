package metods.impl;

import metods.SortAlgorithm;

public class MergeSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        if (array.length < 2) {
            return;
        }

//=================================== P A R C A L A M A ====================================
        int lengt = array.length;
        int midIndex = lengt / 2;
        int[] leftArr = new int[midIndex];
        int[] rightArr = new int[lengt - midIndex];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = array[i];
        }
        for (int i = midIndex; i < array.length; i++) {
            rightArr[i - midIndex] = array[i];
        }

        sort(leftArr);
        sort(rightArr);
        merge(array, leftArr, rightArr);


    }

    //================================= M E R G E ==============================
    private void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] > rightArr[j]) {
                arr[k] = rightArr[j++];
            } else {
                arr[k] = leftArr[i++];
            }
            k++;
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
}

