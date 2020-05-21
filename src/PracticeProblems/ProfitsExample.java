package PracticeProblems;

public class ProfitsExample {

    public static void main(String[] args) {
        int profits [] ={2,5,3,4};
        int weights [] = {3,1,4,2};
        int capacity = 4;
        System.out.println(findTheProfitableSolution(profits,weights,capacity,0));
    }

    static int findTheProfitableSolution(int[] profits, int[] weights, int capacity, int currentIndex) {
        if(capacity<0 || currentIndex<0 || currentIndex >= profits.length){
            return 0;
        }
        int profit1 = 0;
        //picking first element
        if(weights[currentIndex] <= capacity){
            profit1 = profits[currentIndex] + findTheProfitableSolution(profits,weights,capacity-weights[currentIndex],currentIndex+1);
        }
        int profit2 =  findTheProfitableSolution(profits,weights,capacity,currentIndex+1);
        return Math.max(profit1,profit2);
    }
}
