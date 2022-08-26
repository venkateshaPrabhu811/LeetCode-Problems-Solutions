class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] freq = new int[10];
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
        return false;
    }
}