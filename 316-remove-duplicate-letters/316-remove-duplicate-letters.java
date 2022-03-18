class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stk = new Stack<>();
        boolean[] visited = new boolean[26];
        int[] lastIndex = new int[26];
        for(int i = 0;i<s.length();i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0;i<s.length();i++){
            int curr = s.charAt(i) - 'a';
            if(visited[curr]) continue;
            while(!stk.isEmpty() && stk.peek() > curr && i < lastIndex[stk.peek()]){
                visited[stk.pop()] = false;
            }
            stk.push(curr);
            visited[curr] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append((char)(stk.pop() + 'a'));
        }
        return sb.reverse().toString();
    }
}