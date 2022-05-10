class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(1,new ArrayList<>(),k,n);
        return res;
    }
    public void helper(int start,List<Integer> ans,int digits,int target){
        if(ans.size() == digits && target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = start;i<=9;i++){
            ans.add(i);
            helper(i+1,ans,digits,target - i);
            ans.remove(ans.size()-1);
        }
    }
}