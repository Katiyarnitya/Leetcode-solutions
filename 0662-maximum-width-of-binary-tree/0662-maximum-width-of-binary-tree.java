class Pair {
    TreeNode node;
    long idx;

    Pair(TreeNode node, long idx) {
        this.node = node;
        this.idx = idx;
    }
}

class Solution {

    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            long minIdx = 0;
            long lastIdx = 0;

            for(int i = 0; i < size; i++) {

                Pair p = q.poll();

                TreeNode node = p.node;
                long idx = p.idx;

                // first node of level
                if(i == 0) {
                    minIdx = idx;
                }

                // last node of level
                if(i == size - 1) {
                    lastIdx = idx;
                }

                if(node.left != null) {
                    q.offer(new Pair(node.left, 2 * idx + 1));
                }

                if(node.right != null) {
                    q.offer(new Pair(node.right, 2 * idx + 2));
                }
            }

            int width = (int)(lastIdx - minIdx + 1);

            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}