class Solution {
    public int minSetSize(int[] arr) {
        int[] freq = new int[100001];
        int n = arr.length;
        for(int i = 0;i<n;++i){
            ++freq[arr[i]];
        }
        Arrays.sort(freq);
        int count = 0;
        int temp = n;
        for(int i = freq.length-1;i>=0;--i){
            if(freq[i] > 0){
                temp -= freq[i];
                ++count;
            }
            if(temp <= n/2) break;
            
        }
        return count;
    }
}