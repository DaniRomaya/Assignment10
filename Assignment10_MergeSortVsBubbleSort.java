//Program compares the speed of bubble sort and merge sort//

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Assignment10_MergeSortVsBubbleSort{
    public static void main(String[] args) {
        Scanner elements = new Scanner(System.in);
        System.out.print("Enter the amount of elements in the array: ");
        int arrElements= elements.nextInt();
        System.out.println("Array before bubble sorting");
        int[] array1 =  generateArray(arrElements);
        System.out.println(Arrays.toString(array1));
        long start = System.currentTimeMillis();
        bubbleSort(array1, array1.length-1);
        long end = System.currentTimeMillis();
        float result1 = end-start;
        System.out.println("Array after bubble sorting:");
        System.out.println(Arrays.toString(array1));
        System.out.println("Time taken to bubble sort: "  +result1 +"ms");
        System.out.println("Array before merge sorting:");
        int[] array2 = generateArray(arrElements);
        System.out.println(Arrays.toString(array2));
        long start1 = System.currentTimeMillis();
        mergeSort(array2);
        long end1 = System.currentTimeMillis();
        float result = end1-start1;
        System.out.println("Array after merge sorting:");
        System.out.println(Arrays.toString(array2));
        System.out.println("Time taken to merge sort: " + result + "ms");
        elements.close();
    }

    public static int[] generateArray(int n){
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i]=rand.nextInt(100);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        if(arr==null||i<0||j<0||i>arr.length||j>=arr.length){
            return;
        }
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void bubbleSort(int[] array, int n){
        if (array==null || n<=1){
            return;
        }
        for (int i=0; i<n; i++){
            if(array[i]>array[i+1]){
                swap(array, i, i+1);
            }
        }
        bubbleSort(array, n-1);
    }

    public static void mergeSort(int[] arr, int left, int right){
        if (right-left>1){
            int mid =(left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] leftArr= Arrays.copyOfRange(arr, left, mid);
        int[] rightArr= Arrays.copyOfRange(arr, mid, right);
        int i=0, j=0;
        for (int k = left; k<right; k++){
            if(i == leftArr.length){
                arr[k] = rightArr[j++];
            } else if (j == rightArr.length){
                arr[k] = leftArr[i++];
            } else if (leftArr[i]<=rightArr[j]){
                arr[k]= leftArr[i++];
            } else{
                arr[k] = rightArr[j++];
            }
        }
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length);
    }



    
}