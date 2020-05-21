package PracticeProblems;

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {
        int [] arr = {20 ,10 ,90 ,50 ,40 ,30 ,5};
        selectionSort(arr);
    }
    public static void selectionSort(int [] arr){

        int size = arr.length;

        for(int i=0;i<size; i++){
            int min = i;
            for(int j=i+1;j<size;j++){

                if(arr[j] < arr[min]){
                    min = j;
                }

                if(min != i){
                    int temp = arr[i];
                    arr[i]  = arr[min];
                    arr[min] = temp;
                }
            }

            }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
