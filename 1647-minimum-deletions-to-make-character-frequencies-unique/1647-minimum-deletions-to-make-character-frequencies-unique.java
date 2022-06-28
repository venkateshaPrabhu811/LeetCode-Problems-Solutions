class Solution {
    public int minDeletions(String s) {
        /*char[] arr = s.toCharArray();
        Set<Integer> freq = new HashSet<>();
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
        return min;*/
        
        //Space : O(n) + O(26)
        //Time : O(nlogn) + O(n)
        
        int[] count = new int[26];
        int min = 0;
        for(char ch : s.toCharArray()){
            ++count[ch - 'a'];
        }
        Set<Integer> isUsed = new HashSet<>();
        for(int i = 0;i<26;++i){
            int temp = count[i];
            while(temp > 0 && !isUsed.add(temp)){
                --temp;
                ++min;
            }
        }
        return min;
    }
}