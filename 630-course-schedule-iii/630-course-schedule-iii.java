class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int total = 0;
        for(int[] c : courses){
            int dur = c[0],end = c[1];
            if(total + dur <= end){
                total += dur;
                pq.add(dur);
            }
            else if(pq.size() > 0 && pq.peek() > dur){
                total += dur - pq.poll();
                pq.add(dur);
            }
        }
        return pq.size();
    }
}