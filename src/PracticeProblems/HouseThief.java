package PracticeProblems;

public class HouseThief {

    public static void main(String[] args) {
        int [] worths = {2,6,7,8,9,10};
        System.out.println(maxHouseMoney(worths,0));
    }

    static int maxHouseMoney(int [] money,int index){
        if(index >= money.length){
            return 0;
        }
        int stealCurrent =  money[index] + maxHouseMoney(money,index+2);
        int skipCurrent = maxHouseMoney(money,index+1);
        return Math.max(stealCurrent,skipCurrent);
    }

}
