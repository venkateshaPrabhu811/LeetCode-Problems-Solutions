class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes , (a,b) -> (b[1] - a[1]));
        int currWeight = 0,units = 0;
        for(int i = 0;i<boxTypes.length;++i){
            int w = boxTypes[i][0];
            int u = boxTypes[i][1];
            
            if(currWeight + w <= truckSize){
                currWeight += w;
                units += w * u;
            }
            else{
                units += (truckSize - currWeight) * u;
                break;
            }
        }
        return units;
    }
}