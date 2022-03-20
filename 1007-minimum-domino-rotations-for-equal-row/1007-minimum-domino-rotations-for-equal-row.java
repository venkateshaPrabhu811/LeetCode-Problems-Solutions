class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] count1 = new int[7];
        int[] count2 = new int[7];
        int max = 0;
        int dir = 0;
        int maxEle = -1;
        int swaps = 0;
        for(int i = 0;i<tops.length;i++){
            count1[tops[i]]++;
            count2[bottoms[i]]++;
            if(count1[tops[i]] > max){
                max = count1[tops[i]];
                dir = 1;
                maxEle = tops[i];
            }
            if(count2[bottoms[i]] > max){
                max = count2[bottoms[i]];
                dir = 0;
                maxEle = bottoms[i];
            }
        }
        //System.out.println(max);
        //System.out.println(maxEle);
        if(max < tops.length/2.0){
            return -1;
        }
        else{
            if(dir == 0){
                for(int i = 0;i<bottoms.length;i++){
                    if(bottoms[i] != maxEle && tops[i] != maxEle){
                        return -1;
                    }
                    else if(bottoms[i] != maxEle){
                        swaps++;
                    }
                }
            }
            else{
                for(int i = 0;i<tops.length;i++){
                    if(bottoms[i] != maxEle && tops[i] != maxEle){
                        return -1;
                    }
                    else if(tops[i] != maxEle){
                        swaps++;
                    }
                }
            }
        }
        return swaps;
    }
}