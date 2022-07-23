class Solution {
    int[] count;
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
        /*int n = nums.length;
        int[] result = new int[n];
        
        OrigNumIndex[] temp = new OrigNumIndex[n];
        for(int i = 0;i<n;++i){
            temp[i] = new OrigNumIndex(nums[i],i);
        }
        mergeSort(temp,0,n-1,result);
        
        List<Integer> res = new LinkedList<>();
        for(int i : result) res.add(i);
        return res;*/
        
        //MergeSort optimal
        /*List<Integer> res = new ArrayList<Integer>();     
        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
    	    indexes[i] = i;
        }
        mergesort(nums, indexes, 0, nums.length - 1);
        for(int i = 0; i < count.length; i++){
        	res.add(count[i]);
        }
        return res;*/
        
        //Binary Search
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        
        for(int i = nums.length-1;i>=0;--i){
            int index = findIndex(sorted,nums[i]);
            ans[i] = index;
            sorted.add(index,nums[i]);
        }
        return Arrays.asList(ans);
    }
    private int findIndex(List<Integer> sorted,int target){
        if(sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size()-1;
        
        if(sorted.get(end) < target) return end+1;
        if(sorted.get(start) >= target) return 0;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(sorted.get(mid) < target){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        if(sorted.get(start) >= target) return start;
        return end;
    }
    
    /*private void mergeSort(OrigNumIndex[] nums,int start,int end,int[] result){
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
    }*/
    
    
    /*private void mergesort(int[] nums, int[] indexes, int start, int end){
	    if(end <= start){
		    return;
	    }
	    int mid = (start + end) / 2;
	    mergesort(nums, indexes, start, mid);
	    mergesort(nums, indexes, mid + 1, end);
	
	    merge(nums, indexes, start, end);
    }
    
    private void merge(int[] nums, int[] indexes, int start, int end){
	    int mid = (start + end) / 2;
	    int left_index = start;
	    int right_index = mid+1;
	    int rightcount = 0;    	
	    int[] new_indexes = new int[end - start + 1];\
	    int sort_index = 0;
	    while(left_index <= mid && right_index <= end){
		    if(nums[indexes[right_index]] < nums[indexes[left_index]]){
			    new_indexes[sort_index] = indexes[right_index];
			    rightcount++;
			    right_index++;
		    }else{
			    new_indexes[sort_index] = indexes[left_index];
			    count[indexes[left_index]] += rightcount;
			    left_index++;
		    }
		    sort_index++;
	    }
	    while(left_index <= mid){
		    new_indexes[sort_index] = indexes[left_index];
		    count[indexes[left_index]] += rightcount;
		    left_index++;
		    sort_index++;
	    }
	    while(right_index <= end){
		    new_indexes[sort_index++] = indexes[right_index++];
	    }
	    for(int i = start; i <= end; i++){
		    indexes[i] = new_indexes[i - start];
    	}
    }*/
}
class OrigNumIndex{
    int val;
    int index;
    OrigNumIndex(int val,int index){
        this.val = val;
        this.index = index;
    }
}