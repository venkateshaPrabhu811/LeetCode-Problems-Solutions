class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] temp = new int[n*m];
        int index = 0;
        for(int r = 0;r<m;r++){
            for(int c = 0;c<n;c++){
                temp[index++] = grid[r][c];
            }
        }
        k = k % (n*m);
        reverse(0,m*n-1,temp);
        reverse(0,k-1,temp);
        reverse(k,n*m-1,temp);
        index = 0;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<m;i++){
            List<Integer> ans = new ArrayList<>();
            for(int j = 0;j<n;j++){
                ans.add(temp[index++]);
            }
            res.add(ans);
        }
        return res;
    }
    public static void reverse(int start,int end,int[] temp){
        while(start < end){
            int t = temp[start];
            temp[start] = temp[end];
            temp[end] = t;
            ++start;
            --end;
        }
    }
}