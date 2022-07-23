class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //Brute Force
        /*List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0;i<n;++i){
            int count = 0;
            for(int j = i+1;j<n;++j){
                if(nums[j] < nums[i]) ++count;
            }
            res.add(count);
        }
        return res;*/
        
        //Wrong need to cover duplicates
        /*TreeSet<Integer> ts = new TreeSet<>();
        int n = nums.length;
        
        List<Integer> res = new LinkedList<>();
        for(int i = n-1;i>=0;--i){
            TreeSet<Integer> hs = (TreeSet<Integer>)ts.headSet(nums[i]);
            res.add(hs.size());
            ts.add(nums[i]);
        }
        Collections.reverse(res);
        return res;*/
        
        
        //merge sort approach
        int n = nums.length;
        int[] result = new int[n];
        
        OrigNumIndex[] temp = new OrigNumIndex[n];
        for(int i = 0;i<n;++i){
            temp[i] = new OrigNumIndex(nums[i],i);
        }
        mergeSort(temp,0,n-1,result);
        
        List<Integer> res = new LinkedList<>();
        for(int i : result) res.add(i);
        return res;
    }
    
    private void mergeSort(OrigNumIndex[] nums,int start,int end,int[] result){
        if(start >= end) return;
        
        int mid = (start + end)/2;
        mergeSort(nums,start,mid,result);
        mergeSort(nums,mid+1,end,result);
        
        int leftPos = start;
        int rightPos = mid + 1;
        LinkedList<OrigNumIndex> merged = new LinkedList<>();
        
        int smallCount = 0;
        while(leftPos < mid + 1 && rightPos <= end){
            if(nums[leftPos].val > nums[rightPos].val){
                ++smallCount;
                merged.add(nums[rightPos++]);
            }
            else{
                result[nums[leftPos].index] += smallCount;
                merged.add(nums[leftPos++]);
            }
        }
        while(leftPos < mid + 1){
            result[nums[leftPos].index] += smallCount;
            merged.add(nums[leftPos]);
            ++leftPos;
        }
        while(rightPos <= end){
            merged.add(nums[rightPos]);
            ++rightPos;
        }
        int pos = start;
        for(OrigNumIndex m : merged){
            nums[start++] = m;
        }
    }
}
class OrigNumIndex{
    int val;
    int index;
    OrigNumIndex(int val,int index){
        this.val = val;
        this.index = index;
    }
}