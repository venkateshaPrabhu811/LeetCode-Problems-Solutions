class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        /*int[] count = new int[mat.length];
        for(int r = 0;r<mat.length;r++){
            int sum = 0;
            for(int c = 0;c<mat[0].length;c++){
                if(mat[r][c] == 0){
                    break;
                }
                sum++;
            }
            count[r] = sum;
        }
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0;j<count.length;j++){
                if(count[j] < min){
                    min = count[j];
                    minIndex = j;
                }
            }
            ans[i] = minIndex;
            count[minIndex] = Integer.MAX_VALUE;
        }
        return ans;*/
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int r = 0;r < mat.length;r++){
            int sum = 0;
            for(int c = 0;c < mat[0].length;c++){
                if(mat[r][c] == 0){
                    break;
                }
                sum++;
            }
            pq.add(new int[]{sum,r});
        }
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = pq.remove()[1];
        }
        return ans;
    }
}