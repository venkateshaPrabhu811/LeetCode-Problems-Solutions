class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i< numRows; i++){
            List<Integer> arr = new ArrayList<>();
            while(arr.size() <= i){
                if(arr.size() == 0){
                    arr.add(1);
                }
                if(arr.size() <= i-1){
                    int sum = ans.get(i-1).get(arr.size()-1) + ans.get(i-1).get(arr.size());
                    arr.add(sum);
                }
                if(arr.size() == i){
                    arr.add(1);
                }
            }
            ans.add(arr);     
        }
        return ans;
    }
}