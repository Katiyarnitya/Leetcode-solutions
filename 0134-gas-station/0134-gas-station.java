class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int gasSum=0;
        int costSum=0;
        int[] gain = new int[n];
        for(int i=0;i<n;i++){
            gasSum+=gas[i];
            costSum+=cost[i];
            gain[i] = gas[i] - cost[i];
        }
        if(gasSum<costSum) return -1;

        int curr=0;
        int idx = 0;
        for(int i=0;i<n;i++){
            curr+=gain[i];
            if(curr<0){
                curr = 0;
                idx=i+1;
            }
        }
        return idx;
    }
}