class Solution {
    public boolean reorderedPowerOf2(int n) {
        /*int[] freq = new int[10];
        int temp = n;
        while(temp > 0){
            ++freq[temp % 10];
            temp /= 10;
        }
        for(int pow = 0;pow < 32;++pow){
            int val = (int)Math.pow(2,pow);
            int[] map = new int[10];
            while(val > 0){
                ++map[val % 10];
                val /= 10;
            }
            int i = 0;
            for(;i<10;++i){
                if(map[i] != freq[i]) break;
            }
            if(i == 10) return true;
        }
        return false;*/
        
        //TC : O(10) + O(32*(10 + 10));
        
        long c = count(n);
        for(int i = 0;i<32;++i){
            if(count(1 << i) == c) return true;
        }
        return false;
    }
    private long count(int N){
        long res = 0;
        for(;N > 0;N /= 10) res += (int)Math.pow(10,N%10);
        return res;
    }
}