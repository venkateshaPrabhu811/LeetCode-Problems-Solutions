class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j]){
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] arr = res.stream().mapToInt(x -> x).toArray();
        return arr;*/
        
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int i = 0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) != 0){
                res.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    } 
}