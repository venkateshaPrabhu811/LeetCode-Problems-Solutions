class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romToInt = new HashMap<Character, Integer>();
        romToInt.put('I', 1);
        romToInt.put('V', 5);
        romToInt.put('X', 10);
        romToInt.put('L', 50);
        romToInt.put('C', 100);
        romToInt.put('D', 500);
        romToInt.put('M', 1000);
        int sum = 0;
        int test = 0;
        for(int i = s.length()-1; i >= 0; i--){
            int val = romToInt.get(s.charAt(i));
            if(val < test){
                sum -= val;
            }else{
                sum += val;
                test = val;
            }
        }
        return sum;
    }
}