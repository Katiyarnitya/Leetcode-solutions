class Solution {
    public String maxSumOfSquares(int num, int sum) {
        

        StringBuilder sb = new StringBuilder();
        int maxDigit = 9;

        for(int i=0;i<num;i++){
            // if(sum==0){
            //     sb.append(0);
            // }
            if(maxDigit<sum){
                sb.append(maxDigit);
                sum -= maxDigit;
            }else{

                while(maxDigit>sum){
                    maxDigit--;
                }
                sb.append(maxDigit);
                sum -= maxDigit;
                
            }
        }
        return (sb.length()==num && sum>0) ? "" : sb.toString();

    }
}

// class Solution {
//     public int sumOfDigits(int num){
//         int sum = 0;
//         while(num>0){
//             sum += (num%10);
//             num /= 10;
//         }
//         return sum;
//     }
//     public String maxSumOfSquares(int num, int sum) {

//         int maxNumber = (int) Math.pow(10,num) - 1;
//         int minNumber = (int) Math.pow(10,num-1);


//         for(int i=maxNumber ;i>=minNumber;i--){
//             if(sumOfDigits(i)==sum){
//                 return String.valueOf(i);
//             }
//         }
//         return "";
//     }
// }