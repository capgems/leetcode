package PracticeProblems;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "elepahnt";
        String s2 = "elephant";
        System.out.println(longestCommonSubSequence(s1.split(""),s2.split(""),0,0));
    }

    static int longestCommonSubSequence(String[] s1, String[] s2, int i1, int i2) {

        if(i1 == s1.length || i2 == s2.length){
            return 0;
        }
        int c1=0;
        if(s1[i1].equals(s2[i2])){
        c1 = 1 + longestCommonSubSequence(s1,s2,i1+1,i2+1);
        }
        int c3 = longestCommonSubSequence(s1,s2,i1+1,i2);
        int c2 = longestCommonSubSequence(s1,s2,i1,i2+1);

        return findMaxElement(new int[]{c1,c2,c3},0,Integer.MIN_VALUE);
    }

    static int findMaxElement(int[] arr, int index, int min) {

        if (index >= arr.length) {
            return min;
        }

        if (arr[index] > min) {
            min = arr[index];
        }
        return findMaxElement(arr, index + 1, min);
    }
}
