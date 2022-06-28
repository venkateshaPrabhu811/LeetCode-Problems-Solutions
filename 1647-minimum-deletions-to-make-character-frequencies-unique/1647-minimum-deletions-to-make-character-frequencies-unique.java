class Solution {
    public int minDeletions(String s) {
        char[] arr = s.toCharArray();
        Set<Integer> freq = new HashSet<>();//O(26)
        Arrays.sort(arr);
        int left = 0,right = 1;
        int min = 0;
        for(;right <= s.length();++right){
            if(right == s.length() || arr[right] != arr[left]){
                int temp = right - left;
                while(freq.contains(temp)){
                    --temp;
                    ++min;
                }
                if(temp != 0) freq.add(temp);
                left = right;
            }
        }
        return min;
    }
}