class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<count> pq = new PriorityQueue<>(new CustComp());
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            count ob = new count(entry.getKey(),entry.getValue());
            pq.offer(ob);
        }
        List<Integer> res = new ArrayList<>();
        while(pq.size() > k){
            pq.poll();
        }
        while(pq.size() > 0){
            res.add(pq.poll().num);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
class CustComp implements Comparator<count>{
    public int compare(count a,count b){
        return a.fr - b.fr;
    }
}
class count{
    int num;
    int fr;
    count(int a,int b){
        this.num = a;
        this.fr = b;
    }
}