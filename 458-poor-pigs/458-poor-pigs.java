class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int round = (minutesToTest/minutesToDie) + 1;
        while(Math.pow(round,pigs) < buckets) ++pigs;
        return pigs;
    }
}