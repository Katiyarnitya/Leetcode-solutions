class Solution {
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int countWalls(int[] walls, int L, int R){
        // count = index of first element > R  - index of first element >= L
        if (L > R) return 0;
        int left = lowerBound(walls, L);
        int right = upperBound(walls, R);
        return right - left;
    }
    public int solve(int idx, int prevDir, int[][] roboDist, int[]walls, int[][] range, int[][] dp){
        
        if(idx == roboDist.length) return 0;

        if(dp[idx][prevDir] != -1) return dp[idx][prevDir];

        int leftStart = range[idx][0]; //From where we can start counting walls if robot is firing in left

        if(prevDir == 1){
            leftStart = Math.max(leftStart, range[idx-1][1] +1); // if prev robot fired right , so we need to update our leftstart as there is a possibility that some of the walls would have killed by prev robot, so we will update our leftStart accordingly
        }

        int left = countWalls(walls, leftStart, roboDist[idx][0]) + solve(idx+1, 0, roboDist, walls, range, dp); // If fired left, count walls what next robot can fire
        int right = countWalls(walls,roboDist[idx][0] , range[idx][1]) + solve(idx+1, 1, roboDist, walls, range, dp); // if fired right, count the walls

        return dp[idx][prevDir] =  Math.max(left,right); // store from where you got maximum
    }
    public int maxWalls(int[] robots, int[] distance, int[] walls) {

        int n = robots.length;
        int[][] roboDist = new int[n][2];

        for(int i=0;i<n;i++){
            roboDist[i][0] = robots[i];
            roboDist[i][1] = distance[i];
        }
        Arrays.sort(roboDist, ((a,b) -> a[0]-b[0]));
        Arrays.sort(walls);

        int[][] range = new int[n][2]; // For each robot How far max he can fire in both left and right considering other robots in midway as well as the distance till his bullet can go

        for(int i=0;i<n;i++){
            int currRoboPos = roboDist[i][0];
            int leftLimit = (i==0) ? Integer.MIN_VALUE / 2 : roboDist[i-1][0] +1;
            int rightLimit = (i==n-1) ? Integer.MAX_VALUE / 2 : roboDist[i+1][0] -1;

            int leftRange = Math.max(currRoboPos - roboDist[i][1], leftLimit);
            int rightRange = Math.min(currRoboPos + roboDist[i][1], rightLimit);

            range[i][0] = leftRange;
            range[i][1] = rightRange;
        }
        int[][] dp= new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,roboDist,walls,range,dp);
    }
}