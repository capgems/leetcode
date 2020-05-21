package PracticeProblems;

public class NumberOfWaysInteger {
    //3,6,1
    //5,1,2
    //3,1,4
    public static void main(String[] args) {
        System.out.println(findNumberOfWays(3));
    }

    static int findNumberOfWays(int n) {

        if (n == 0 || n == 1) {

            return 1;
        }

        if (n == 2) {

            return 1;
        }

        return findNumberOfWays(n-1)  + findNumberOfWays(n-2); // 3,6,1
        //return  findNumberOfWays(n-3)  +  findNumberOfWays(n-2)+  findNumberOfWays(n-4)+  findNumberOfWays(n-1);
       // return findNumberOfWays(n - 5)+ findNumberOfWays(n-4) + findNumberOfWays(n-3);
        // return findNumberOfWays(n-5) + findNumberOfWays(n-1);
    }
}
