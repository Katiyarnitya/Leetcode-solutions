class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        long topSum = 0;

        int[] topFreq = new int[100001];
        int[] bottomFreq = new int[100001];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bottomFreq[grid[i][j]]++;
            }
        }

        for (int cut = 0; cut < m - 1; cut++) {
            for (int j = 0; j < n; j++) {
                int val = grid[cut][j];
                topSum += val;
                topFreq[val]++;
                bottomFreq[val]--;
            }

            long bottomSum = total - topSum;

            if (topSum == bottomSum) return true;

            if (topSum > bottomSum) {
                long diff = topSum - bottomSum;
                if (diff <= 100000 && validHorizontal(grid, true, cut, (int) diff, topFreq)) {
                    return true;
                }
            } else {
                long diff = bottomSum - topSum;
                if (diff <= 100000 && validHorizontal(grid, false, cut, (int) diff, bottomFreq)) {
                    return true;
                }
            }
        }

        long leftSum = 0;

        int[] leftFreq = new int[100001];
        int[] rightFreq = new int[100001];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rightFreq[grid[i][j]]++;
            }
        }

        for (int cut = 0; cut < n - 1; cut++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][cut];
                leftSum += val;
                leftFreq[val]++;
                rightFreq[val]--;
            }

            long rightSum = total - leftSum;

            if (leftSum == rightSum) return true;

            if (leftSum > rightSum) {
                long diff = leftSum - rightSum;
                if (diff <= 100000 && validVertical(grid, true, cut, (int) diff, leftFreq)) {
                    return true;
                }
            } else {
                long diff = rightSum - leftSum;
                if (diff <= 100000 && validVertical(grid, false, cut, (int) diff, rightFreq)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean validHorizontal(int[][] grid, boolean isTop, int cut, int diff, int[] freq) {
        int m = grid.length;
        int n = grid[0].length;

        int rows = isTop ? cut + 1 : m - cut - 1;
        int cols = n;
        int area = rows * cols;

        if (area <= 1) return false;

        if (rows > 1 && cols > 1) {
            return freq[diff] > 0;
        }

        if (rows == 1) {
            int row = isTop ? cut : cut + 1;
            return grid[row][0] == diff || grid[row][n - 1] == diff;
        }

        if (cols == 1) {
            int topRow = isTop ? 0 : cut + 1;
            int bottomRow = isTop ? cut : m - 1;
            return grid[topRow][0] == diff || grid[bottomRow][0] == diff;
        }

        return false;
    }

    private boolean validVertical(int[][] grid, boolean isLeft, int cut, int diff, int[] freq) {
        int m = grid.length;
        int n = grid[0].length;

        int rows = m;
        int cols = isLeft ? cut + 1 : n - cut - 1;
        int area = rows * cols;

        if (area <= 1) return false;

        if (rows > 1 && cols > 1) {
            return freq[diff] > 0;
        }

        if (rows == 1) {
            int leftCol = isLeft ? 0 : cut + 1;
            int rightCol = isLeft ? cut : n - 1;
            return grid[0][leftCol] == diff || grid[0][rightCol] == diff;
        }

        if (cols == 1) {
            int col = isLeft ? cut : cut + 1;
            return grid[0][col] == diff || grid[m - 1][col] == diff;
        }

        return false;
    }
}