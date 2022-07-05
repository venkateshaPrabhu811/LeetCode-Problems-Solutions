class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int max = 0;
        for(int i : nums){
            if(map.containsKey(i)) continue;
            
            int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
            int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;
            int sum = right + left + 1;
            
            max = Math.max(sum,max);
            
            map.put(i,sum);
            map.put(i-left,sum);
            map.put(i+right,sum);
        }
        return max;
    }
}