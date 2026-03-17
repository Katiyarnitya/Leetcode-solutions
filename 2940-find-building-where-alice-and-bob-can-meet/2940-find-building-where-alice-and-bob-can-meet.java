class Solution {
    static int[] st;
    public static void build(int idx, int L, int R, int[] heights){
        if(L == R){
            st[idx] = heights[L];
            return;
        }
        int mid = L + (R - L)/2;
        build(2*idx+1, L, mid, heights);
        build(2*idx+2, mid+1, R, heights);
        st[idx] = Math.max(st[2*idx+1], st[2*idx+2]);
    }

    public static int findQuery(int idx, int L, int R, int qs, int target){
        if(R < qs || st[idx] <= target) return -1;

        if(L == R) return L;

        int mid = L + (R - L)/2;
        int ans = findQuery(2*idx+1, L, mid, qs, target);

        if(ans != -1) return ans;

        return findQuery(2*idx+2, mid+1, R, qs, target);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        st = new int[4*n];

        build(0, 0, n-1, heights);

        int ans[] = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];

            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }

            if(a == b){
                ans[i] = a;
                continue;
            }

            if(heights[b] > heights[a]){
                ans[i] = b;
                continue;
            }

            int target = Math.max(heights[a], heights[b]);

            ans[i] = findQuery(0, 0, n-1, b+1, target);
        }

        return ans;
    }
}