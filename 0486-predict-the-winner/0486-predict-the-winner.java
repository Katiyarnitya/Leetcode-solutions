class Solution {
    public int solve(int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return nums[i];
        }
        int take_i = nums[i] + Math.min(solve(i + 2, j, nums), solve(i + 1, j - 1, nums));
        int take_j = nums[j] + Math.min(solve(i + 1, j - 1, nums), solve(i, j - 2, nums));

        return Math.max(take_i, take_j);
    }

    public boolean predictTheWinner(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        int score1 = solve(0, nums.length - 1, nums);
        int score2 = totalSum - score1;
        return score1 >= score2;
    }
}