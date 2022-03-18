class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));
        String res = "";
        if(arr[0].equals("0")) return "0";
        for(int i = 0;i<arr.length;i++){
            res += arr[i];
        }
        return res;
    }
}