package PracticeProblems;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int [] arr = {20 ,10 ,90 ,50 ,40 ,30 };
        sortArrayInts(arr);
    }

    public static void sortArrayInts(int arr[]){
        int size = arr.length;
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] =  arr[j+1];
                    arr[j+1] =temp;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
