class Solution {
    List<Integer> res;
    public int[] numsSameConsecDiff(int n, int k) {
        res = new ArrayList<>();
        for(int i = 1;i<=9;++i){
            dfs(i + "",n,k);
        }
        int[] arr = new int[res.size()];
        for(int i = 0;i<arr.length;++i){
            arr[i] = res.get(i);
        }
        return arr;
    }
    private void dfs(String num,int n,int k){
        if(num.length() == n){
            res.add(Integer.parseInt(num));
            return;
        }
        for(int digit = 0;digit<=9;++digit){
            int prev = num.charAt(num.length()-1) - '0';
            if(Math.abs(prev - digit) == k){
                dfs(num + digit,n,k);
            }
        }
    }
}