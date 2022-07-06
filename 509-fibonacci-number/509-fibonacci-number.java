class Solution {
    public int fib(int n) {
        //O(n) space
        
        /*if(n == 0 || n == 1) return n;
        int[] num = new int[n+1];
        num[1] = 1;
        for(int i = 2;i<=n;++i){
            num[i] = num[i-1] + num[i-2];
        }
        return num[n];*/
        
        if(n == 0 || n == 1) return n;
        int two = 0;
        int one = 1;
        int curr = 0;
        for(int i = 2;i<=n;++i){
            curr = two + one;
            two = one;
            one = curr;
        }
        return curr;
    }
}