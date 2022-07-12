class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if(n == 0) return false;
        int target = 0;
        for(int i : matchsticks){
            target += i;
        }
        if(target % 4 != 0) return false;
        Arrays.sort(matchsticks);
        target = target/4;
        int[] sides = new int[4];
        return dfs(matchsticks,n,target,sides,n-1);
    }
    private boolean dfs(int[] matchsticks,int n,int target,int[] sides,int idx){
        if(idx == -1){
            if(sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3])
                return true;
            return false;
        }
        
        for(int i = 0;i<4;++i){
            if(sides[i] + matchsticks[idx] > target) continue;
            
            int j = i-1;
            while(j >= 0){
                if(sides[j] == sides[i])
                    break;
                --j;
            }
            if(j != -1){
                continue;
            }
            sides[i] += matchsticks[idx];
            if(dfs(matchsticks,n,target,sides,idx-1)) return true;
            sides[i] -= matchsticks[idx];
        }
        return false;
    }
}