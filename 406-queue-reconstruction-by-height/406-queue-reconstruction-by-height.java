class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new LinkedList<>();
        for(int[] temp : people){
            res.add(temp[1],temp);
        }
        return res.toArray(new int[people.length][2]);
    }
}