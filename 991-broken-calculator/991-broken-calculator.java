class Solution {
    public int brokenCalc(int startValue, int target) {
        int jumps = 0;
        if(startValue > target){
            return startValue - target;
        }
        else{
            while(startValue < target){
                jumps++;
                if(target % 2 == 0){
                    target /= 2;
                }
                else{
                    target++;
                }
            }
            return jumps + (startValue - target);
        }
    }
}