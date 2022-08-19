class Solution {
    public boolean isPossible(int[] nums) {
        //Using two HashMaps
        /*HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,Integer> end = new HashMap<>();
        for(int i : nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for(int i : nums){
            if(freq.get(i) == null || freq.get(i) == 0) continue;
            freq.put(i,freq.get(i)-1);
            if(end.getOrDefault(i-1,0) > 0){
                end.put(i-1,end.get(i-1)-1);
                end.put(i,end.getOrDefault(i,0)+1);
            }
            else if(freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0){
                freq.put(i+1,freq.get(i+1)-1);
                freq.put(i+2,freq.get(i+2)-1);
                end.put(i+2,end.getOrDefault(i+2,0)+1);
            }
            else return false;
        }
        return true;*/
        
        //Without space
        int pre = Integer.MIN_VALUE;
	    int p1 = 0;
	    int p2 = 0;
	    int p3 = 0;
	
        int cur = 0;
        int cnt = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
            for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; i++) {
                cnt++;
            }

            if (cur != pre + 1) {
                if (p1 != 0 || p2 != 0) {
                    return false;
                }

                c1 = cnt;
                c2 = 0;
                c3 = 0;

            } else {
                if (cnt < p1 + p2) {
                    return false;
                }

                c1 = Math.max(0, cnt - (p1 + p2 + p3));
                c2 = p1;
                c3 = p2 + Math.min(p3, cnt - (p1 + p2));
            }
        }

        return (p1 == 0 && p2 == 0);
    }
}