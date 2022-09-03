class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        if(n == 0) return new int[0];
        if(n == 1) res.add(0);
        dfs(n,k,res,0);
        return res.stream().mapToInt(i -> i).toArray();
    }
    private void dfs(int n,int k,List<Integer> res,int num){
        if(n == 0){
            res.add(num);
            return;
        }
        for(int digit = 0;digit < 10;++digit){
            if(num == 0 && digit == 0) continue;
            else if(num == 0 && digit != 0) dfs(n-1,k,res,digit);
            else{
                if(Math.abs(num%10 - digit) == k){
                    dfs(n-1,k,res,num*10+digit);
                }
            }            
        }
    }
}