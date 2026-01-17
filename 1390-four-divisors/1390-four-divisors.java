class Solution {
    public int sumFourDivisors(int[] nums) {

        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            int numOfDiv=0;
            int divSum=0;
            for(int j=1; j*j<=nums[i]; j++){ // checking upto root(nums[i])
                if(nums[i]%j == 0){
                    int otherFact = nums[i]/j;
                    if(j==otherFact){
                        numOfDiv++;
                        divSum+=j;
                    }else{
                        numOfDiv+=2;
                        divSum += j+otherFact;
                    }
                }
                if(numOfDiv >4){
                    break;
                }
            }
            if(numOfDiv==4){
                totalSum += divSum;
            }
        }
        return totalSum;
    }
}