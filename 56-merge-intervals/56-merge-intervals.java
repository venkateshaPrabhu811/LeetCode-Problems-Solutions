class Solution {
    public int[][] merge(int[][] intervals) {
        int index = 0;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1;i<intervals.length;i++){
            if(end >= intervals[i][0]){
                end = Math.max(end,intervals[i][1]);
            }
            else{
                res.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}